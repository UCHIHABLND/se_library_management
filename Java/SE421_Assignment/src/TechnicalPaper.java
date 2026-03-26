/**
 * CRC Card:
 * Class: TechnicalPaper
 * Responsibilities:
 *   - Represent a technical paper
 *   - Calculate fine: $2/day
 * Collaborators:
 *   - LibraryItem
 */

public class TechnicalPaper extends LibraryItem {

    public TechnicalPaper(String libraryId, String title, String description) {
        super(libraryId, title, description);
    }

    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 2.0;
    }
}