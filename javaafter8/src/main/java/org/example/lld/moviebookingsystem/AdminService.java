package org.example.lld.moviebookingsystem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class AdminService {
    private static final AdminService INSTANCE = new AdminService();

    private final Map<Integer, Movie> movies = new ConcurrentHashMap<>();
    private final Map<Integer, Theater> theaters = new ConcurrentHashMap<>();
    private final Map<Integer, Show> shows = new ConcurrentHashMap<>();

    private final AtomicInteger movieIdGen = new AtomicInteger(1);
    private final AtomicInteger theaterIdGen = new AtomicInteger(1);
    private final AtomicInteger showIdGen = new AtomicInteger(1);

    private AdminService() {}

    public static AdminService getInstance() {
        return INSTANCE;
    }

    // Movie operations
    public Movie addMovie(String title, String genre, String language, int duration) {
        int id = movieIdGen.getAndIncrement();
        Movie movie = new Movie(id, title, genre, language, duration);
        movies.put(id, movie);
        return movie;
    }

    public Optional<Movie> updateMovie(int id, String title, String genre, String language, int duration) {
        return Optional.ofNullable(movies.computeIfPresent(id, (k, v) -> new Movie(id, title, genre, language, duration)));
    }

    public void removeMovie(int id) {
        movies.remove(id);
    }

    public List<Movie> listMovies() {
        return new ArrayList<>(movies.values());
    }

    // Theater operations
    public Theater addTheater(String name, String city) {
        int id = theaterIdGen.getAndIncrement();
        Theater theater = new Theater(id, name, city);
        theaters.put(id, theater);
        return theater;
    }

    public Optional<Theater> updateTheater(int id, String name, String city) {
        return Optional.ofNullable(theaters.computeIfPresent(id, (k, v) -> new Theater(id, name, city)));
    }

    public void removeTheater(int id) {
        theaters.remove(id);
    }

    public List<Theater> listTheaters() {
        return new ArrayList<>(theaters.values());
    }

    // Show operations
    public Show addShow(Movie movie, Theater theater, LocalDateTime startTime, List<Seat> seats) {
        int id = showIdGen.getAndIncrement();
        Show show = new Show(id, movie, theater, startTime, seats);
        shows.put(id, show);
        return show;
    }

    public Optional<Show> updateShow(int id, Movie movie, Theater theater, LocalDateTime startTime, List<Seat> seats) {
        return Optional.ofNullable(shows.computeIfPresent(id, (k, v) -> new Show(id, movie, theater, startTime, seats)));
    }

    public void removeShow(int id) {
        shows.remove(id);
    }

    public List<Show> listShows() {
        return new ArrayList<>(shows.values());
    }
}
