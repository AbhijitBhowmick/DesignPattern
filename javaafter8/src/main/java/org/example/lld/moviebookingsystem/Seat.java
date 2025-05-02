package org.example.lld.moviebookingsystem;

public sealed interface Seat permits NormalSeat, PremiumSeat {
    int seatNumber();
    double price();
}
