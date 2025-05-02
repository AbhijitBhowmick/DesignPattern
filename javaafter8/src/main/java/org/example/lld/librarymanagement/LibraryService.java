package org.example.lld.librarymanagement;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public final class LibraryService {
    private final BookRepository bookRepo;
    private final MemberRepository memberRepo;
    private BorrowingRule borrowingRule;

    public LibraryService(BookRepository bookRepo, MemberRepository memberRepo, BorrowingRule rule) {
        this.bookRepo = bookRepo;
        this.memberRepo = memberRepo;
        this.borrowingRule = rule;
    }

    public synchronized void borrowBook(String memberId, String isbn) {
        var memberOpt = memberRepo.findById(memberId);
        var bookOpt = bookRepo.findByIsbn(isbn);

        if (memberOpt.isEmpty() || bookOpt.isEmpty()) {
            System.out.println("Member or Book not found.");
            return;
        }

        var member = memberOpt.get();
        var book = bookOpt.get();

        if (book.availabilityStatus() != AvailabilityStatus.AVAILABLE) {
            System.out.println("Book is not available.");
            return;
        }

        if (!borrowingRule.canBorrow(member)) {
            System.out.println("Borrowing limit reached.");
            return;
        }

        var updatedBook = book.withAvailabilityStatus(AvailabilityStatus.BORROWED);
        bookRepo.addOrUpdateBook(updatedBook);

        var borrowDate = LocalDate.now();
        var dueDate = borrowDate.plusDays(borrowingRule.getLoanDurationDays());
        var record = new BorrowRecord(isbn, borrowDate, dueDate);

        var updatedBorrowedBooks = new HashMap<>(member.borrowedBooks());
        updatedBorrowedBooks.put(isbn, record);
        var updatedMember = member.withBorrowedBooks(updatedBorrowedBooks);
        memberRepo.addOrUpdateMember(updatedMember);

        System.out.println("Book borrowed successfully.");
    }

    public synchronized boolean returnBook(String memberId, String isbn) {
        var memberOpt = memberRepo.findById(memberId);
        var bookOpt = bookRepo.findByIsbn(isbn);

        if (memberOpt.isEmpty() || bookOpt.isEmpty()) {
            System.out.println("Member or Book not found.");
            return false;
        }

        var member = memberOpt.get();
        var book = bookOpt.get();

        if (!member.borrowedBooks().containsKey(isbn)) {
            System.out.println("Book not borrowed by member.");
            return false;
        }

        var updatedBook = book.withAvailabilityStatus(AvailabilityStatus.AVAILABLE);
        bookRepo.addOrUpdateBook(updatedBook);

        var updatedBorrowedBooks = new HashMap<>(member.borrowedBooks());
        updatedBorrowedBooks.remove(isbn);
        var updatedMember = member.withBorrowedBooks(updatedBorrowedBooks);
        memberRepo.addOrUpdateMember(updatedMember);

        System.out.println("Book returned successfully.");
        return true;
    }

    public List<Book> searchBooks(String query) {
        var lowerQuery = query.toLowerCase();
        return bookRepo.search(book ->
                book.title().toLowerCase().contains(lowerQuery) ||
                        book.author().toLowerCase().contains(lowerQuery));
    }

    public List<Member> listMembers() {
        return memberRepo.findAll();
    }

    public void setBorrowingRule(BorrowingRule rule) {
        this.borrowingRule = rule;
    }
}
