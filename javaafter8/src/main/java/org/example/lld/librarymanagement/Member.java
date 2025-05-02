package org.example.lld.librarymanagement;

import java.util.Map;

public record Member(
        String name,
        String memberId,
        String contactInfo,
        Map<String, BorrowRecord> borrowedBooks
) {
    public Member {
        borrowedBooks = Map.copyOf(borrowedBooks); // defensive copy for immutability
    }

    public Member withBorrowedBooks(Map<String, BorrowRecord> newBorrowedBooks) {
        return new Member(name, memberId, contactInfo, newBorrowedBooks);
    }
}
