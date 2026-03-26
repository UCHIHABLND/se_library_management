/**
 * CRC Card:
 * Class: Journal
 * Responsibilities:
 *   - Represent a journal item
 *   - Calculate fine: $3/day
 * Collaborators:
 *   - LibraryItem
 */

public class Journal extends LibraryItem {

    public Journal(String libraryId, String title, String description) {
        super(libraryId, title, description);
    }

    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 3.0;
    }
}