package org.example.lld.moviebookingsystem;

public record PremiumSeat(int seatNumber, double price, String extraBenefits) implements Seat {}
