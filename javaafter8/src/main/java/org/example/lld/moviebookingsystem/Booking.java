package org.example.lld.moviebookingsystem;

import java.util.List;

public record Booking(int id, User user, Show show, List<Seat> seats, BookingStatus status) {}
