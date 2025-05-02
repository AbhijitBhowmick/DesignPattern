package org.example.lld.librarymanagement;


// --- Borrowing Rules (Strategy Pattern) ---
public interface BorrowingRule {
    boolean canBorrow(Member member);
    int getLoanDurationDays();
}
