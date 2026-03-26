/**
 * CRC Card:
 * Class: Video
 * Responsibilities:
 *   - Represent a video item
 *   - Calculate fine: $1/day
 * Collaborators:
 *   - LibraryItem
 */

public class Video extends LibraryItem {

    public Video(String libraryId, String title, String description) {
        super(libraryId, title, description);
    }

    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 1.0;
    }
}