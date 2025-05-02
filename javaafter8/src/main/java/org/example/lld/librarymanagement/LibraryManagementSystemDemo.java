package org.example.lld.librarymanagement;

import java.util.Map;

public class LibraryManagementSystemDemo {
    public static void main(String[] args) {
        var bookRepo = InMemoryBookRepository.getInstance();
        var memberRepo = InMemoryMemberRepository.getInstance();
        var rule = new DefaultBorrowingRule(3, 14);

        var libraryService = new LibraryService(bookRepo, memberRepo, rule);

        bookRepo.addOrUpdateBook(new Book("Effective Java", "Joshua Bloch", "9780134685991", 2018, AvailabilityStatus.AVAILABLE));
        bookRepo.addOrUpdateBook(new Book("Clean Code", "Robert C. Martin", "9780132350884", 2008, AvailabilityStatus.AVAILABLE));
        bookRepo.addOrUpdateBook(new Book("Clean Architechture", "Robert C. Martin", "9780132350883", 2009, AvailabilityStatus.AVAILABLE));

        memberRepo.addOrUpdateMember(new Member("Alice", "M001", "alice@example.com", Map.of()));

        libraryService.borrowBook("M001", "9780134685991");

        var foundBooks = libraryService.searchBooks("clean");
        foundBooks.forEach(System.out::println);

        libraryService.returnBook("M001", "9780134685991");
    }
}
