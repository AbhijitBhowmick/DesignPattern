package org.example.lld.librarymanagement;

import java.time.LocalDate;

public record BorrowRecord(
        String isbn,
        LocalDate borrowDate,
        LocalDate dueDate
) {}
