package org.example.lld.librarymanagement;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface BookRepository {
    void addOrUpdateBook(Book book);
    void removeBook(String isbn);
    Optional<Book> findByIsbn(String isbn);
    List<Book> search(Predicate<Book> predicate);
    List<Book> findAll();
}
