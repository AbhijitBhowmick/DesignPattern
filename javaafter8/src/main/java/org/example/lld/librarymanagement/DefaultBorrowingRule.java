package org.example.lld.librarymanagement;

public final class DefaultBorrowingRule implements BorrowingRule {
    private final int maxBooksAllowed;
    private final int loanDurationDays;

    public DefaultBorrowingRule(int maxBooksAllowed, int loanDurationDays) {
        this.maxBooksAllowed = maxBooksAllowed;
        this.loanDurationDays = loanDurationDays;
    }

    @Override
    public boolean canBorrow(Member member) {
        return member.borrowedBooks().size() < maxBooksAllowed;
    }

    @Override
    public int getLoanDurationDays() { return loanDurationDays; }
}
