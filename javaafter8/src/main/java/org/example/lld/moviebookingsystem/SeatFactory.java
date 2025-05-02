package org.example.lld.moviebookingsystem;

import java.util.function.Function;

public class SeatFactory {
    private static final Function<Integer, Seat> NORMAL_SEAT_CREATOR = seatNum -> new NormalSeat(seatNum, 100.0);
    private static final Function<Integer, Seat> PREMIUM_SEAT_CREATOR = seatNum -> new PremiumSeat(seatNum, 200.0, "Extra legroom");

    public static Seat createSeat(String type, int seatNumber) {
        return switch (type.toLowerCase()) {
            case "normal" -> NORMAL_SEAT_CREATOR.apply(seatNumber);
            case "premium" -> PREMIUM_SEAT_CREATOR.apply(seatNumber);
            default -> throw new IllegalArgumentException("Unknown seat type: " + type);
        };
    }
}
