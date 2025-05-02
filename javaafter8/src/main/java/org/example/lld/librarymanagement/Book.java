package org.example.lld.librarymanagement;


public record Book(
        String title,
        String author,
        String isbn,
        int publicationYear,
        AvailabilityStatus availabilityStatus
) {
    public Book withAvailabilityStatus(AvailabilityStatus status) {
        return new Book(title, author, isbn, publicationYear, status);
    }
}
