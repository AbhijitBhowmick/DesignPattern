package org.example.lld.moviebookingsystem;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class BookingService {
    private static final BookingService INSTANCE = new BookingService();

    // Map<ShowId, Set<SeatNumber>> to track booked seats concurrently
    private final Map<Integer, Set<Integer>> bookedSeats = new ConcurrentHashMap<>();
    private final Map<Integer, Booking> bookings = new ConcurrentHashMap<>();
    private final AtomicInteger bookingIdGenerator = new AtomicInteger(1);

    private BookingService() {}

    public static BookingService getInstance() {
        return INSTANCE;
    }

    // Thread-safe seat booking with functional style validation
    public Booking bookSeats(User user, Show show, List<Seat> requestedSeats) throws Exception {
        bookedSeats.putIfAbsent(show.id(), ConcurrentHashMap.newKeySet());
        Set<Integer> booked = bookedSeats.get(show.id());

        // Check seat availability functionally
        List<Integer> requestedSeatNumbers = requestedSeats.stream()
                .map(Seat::seatNumber)
                .toList();

        boolean allAvailable = requestedSeatNumbers.stream()
                .noneMatch(booked::contains);

        if (!allAvailable) {
            throw new Exception("One or more seats are already booked.");
        }

        // Atomically reserve seats
        synchronized (booked) {
            // Double-check inside synchronized block
            if (requestedSeatNumbers.stream().anyMatch(booked::contains)) {
                throw new Exception("One or more seats are already booked.");
            }
            booked.addAll(requestedSeatNumbers);
        }

        int bookingId = bookingIdGenerator.getAndIncrement();
        Booking booking = new Booking(bookingId, user, show, requestedSeats, BookingStatus.CONFIRMED);
        bookings.put(bookingId, booking);

        // Simulate payment processing
        processPayment(user, booking);

        return booking;
    }

    private void processPayment(User user, Booking booking) {
        // Simulate payment logic (could be async, external API call, etc.)
        System.out.printf("Processing payment for user %s, booking %d, amount %.2f%n",
                user.username(),
                booking.id(),
                booking.seats().stream().mapToDouble(Seat::price).sum());
    }

    public void cancelBooking(int bookingId) {
        Optional.ofNullable(bookings.get(bookingId))
                .filter(b -> b.status() == BookingStatus.CONFIRMED)
                .ifPresent(booking -> {
                    Set<Integer> booked = bookedSeats.get(booking.show().id());
                    synchronized (booked) {
                        booking.seats().stream()
                                .map(Seat::seatNumber)
                                .forEach(booked::remove);
                    }
                    bookings.put(bookingId, new Booking(booking.id(), booking.user(), booking.show(), booking.seats(), BookingStatus.CANCELLED));
                    System.out.printf("Booking %d cancelled.%n", bookingId);
                });
    }

    // Retrieve available seats functionally
    public List<Seat> getAvailableSeats(Show show) {
        Set<Integer> booked = bookedSeats.getOrDefault(show.id(), Collections.emptySet());
        return show.seats().stream()
                .filter(seat -> !booked.contains(seat.seatNumber()))
                .toList();
    }
}
