package org.example.lld.moviebookingsystem;

import java.time.LocalDateTime;
import java.util.List;

public class MovieBookingSystemMain {
    public static void main(String[] args) throws Exception {
        AdminService admin = AdminService.getInstance();
        BookingService bookingService = BookingService.getInstance();

        // Admin adds movies, theaters, shows
        Movie movie = admin.addMovie("Interstellar", "Sci-Fi", "English", 169);
        Theater theater = admin.addTheater("PVR Cinemas", "San Francisco");

        // Create seats functionally
        List<Seat> seats = List.<Seat>of(
                SeatFactory.createSeat("normal", 1),
                SeatFactory.createSeat("normal", 2),
                SeatFactory.createSeat("premium", 3),
                SeatFactory.createSeat("premium", 4),
                SeatFactory.createSeat("premium", 5),
                SeatFactory.createSeat("premium", 6),
                SeatFactory.createSeat("premium", 7)
        );

        Show show = admin.addShow(movie, theater, LocalDateTime.now().plusDays(1), seats);

        User user = new User(1, "alice", "alice@example.com");

        // Display available seats using streams
        System.out.println("Available seats before booking:");
        bookingService.getAvailableSeats(show).forEach(seat ->
                System.out.printf("Seat %d, Price: %.2f%n", seat.seatNumber(), seat.price())
        );

        // User books seats concurrently (simulate concurrency with threads)
        Runnable bookingTask = () -> {
            try {
                Booking booking1 = bookingService.bookSeats(user, show, List.of(seats.get(0), seats.get(2)));
                //Booking booking2 = bookingService.bookSeats(user, show, List.of(seats.get(0), seats.get(5)));
                System.out.println("Booking successful1: " + booking1);
                //System.out.println("Booking successful2: " + booking2);
            } catch (Exception e) {
                System.out.println("Booking failed: " + e.getMessage());
            }
        };

        Thread t1 = new Thread(bookingTask);
        Thread t2 = new Thread(bookingTask);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Available seats after booking:");
        bookingService.getAvailableSeats(show).forEach(seat ->
                System.out.printf("Seat %d, Price: %.2f%n", seat.seatNumber(), seat.price())
        );
    }
}
