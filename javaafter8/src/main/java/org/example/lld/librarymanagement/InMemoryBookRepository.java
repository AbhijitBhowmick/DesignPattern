package org.example.lld.librarymanagement;

// --- Singleton Repository Implementations ---

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Predicate;

public final class InMemoryBookRepository implements BookRepository {
    private final ConcurrentMap<String, Book> books = new ConcurrentHashMap<>();
    private static final InMemoryBookRepository INSTANCE = new InMemoryBookRepository();
    private InMemoryBookRepository() {}
    public static InMemoryBookRepository getInstance() { return INSTANCE; }

    @Override
    public void addOrUpdateBook(Book book) { books.put(book.isbn(), book); }

    @Override
    public void removeBook(String isbn) { books.remove(isbn); }

    @Override
    public Optional<Book> findByIsbn(String isbn) { return Optional.ofNullable(books.get(isbn)); }

    @Override
    public List<Book> search(Predicate<Book> predicate) {
        return books.values().stream().filter(predicate).toList();
    }

    @Override
    public List<Book> findAll() { return List.copyOf(books.values()); }
}
