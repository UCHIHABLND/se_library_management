/**
 * CRC Card:
 * Class: Book
 * Responsibilities:
 *   - Represent a book item
 *   - Calculate fine: $3/day
 * Collaborators:
 *   - LibraryItem
 */

public class Book extends LibraryItem {

    public Book(String libraryId, String title, String description) {
        super(libraryId, title, description);
    }

    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 3.0;
    }
}