package org.example.lld.moviebookingsystem;

import java.time.LocalDateTime;
import java.util.List;

public record Show(int id, Movie movie, Theater theater, LocalDateTime startTime, List<Seat> seats) {}
