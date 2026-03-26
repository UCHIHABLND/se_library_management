import java.time.LocalDate;

/**
 * CRC Card:
 * Class: LendRecord
 * Responsibilities:
 *   - Track lending info
 *   - Calculate overdue fine
 * Collaborators:
 *   - AUISMember
 *   - LibraryItem
 */

public class LendRecord {
    private LibraryItem item;
    private AUISMember borrower;
    private LocalDate lendDate;
    private LocalDate dueDate;

    public LendRecord(LibraryItem item, AUISMember borrower, LocalDate lendDate) {
        this.item = item;
        this.borrower = borrower;
        this.lendDate = lendDate;
        this.dueDate = lendDate.plusWeeks(2);
    }

    public LibraryItem getItem() {
        return item;
    }

    public AUISMember getBorrower() {
        return borrower;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public double calculateFine(LocalDate returnDate) {
        int overdueDays = 0;
        if (returnDate.isAfter(dueDate)) {
            overdueDays = (int) (returnDate.toEpochDay() - dueDate.toEpochDay());
        }
        return item.calculateFine(overdueDays);
    }

    public void printRecord(LocalDate returnDate) {
        System.out.println(
            "Item: " + item.getTitle() +
            " | Borrower: " + borrower.getAuistId() +
            " | Due: " + dueDate +
            " | Fine: $" + calculateFine(returnDate)
        );
    }
}