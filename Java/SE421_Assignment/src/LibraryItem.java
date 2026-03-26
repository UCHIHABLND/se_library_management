/**
 * CRC Card:
 * Class: LibraryItem
 * Responsibilities: 
 *   - Store common info for all library items
 *   - Provide abstract fine calculation
 * Collaborators:
 *   - Subclasses (Book, Video, Journal, TechnicalPaper)
 */

public abstract class LibraryItem {
    protected String libraryId;
    protected String title;
    protected String description;

    public LibraryItem(String libraryId, String title, String description) {
        this.libraryId = libraryId;
        this.title = title;
        this.description = description;
    }

    public String getLibraryId() {
        return libraryId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public abstract double calculateFine(int overdueDays);

    public void displayInfo() {
        System.out.println("ID: " + libraryId + " | Title: " + title + " | Description: " + description);
    }
}