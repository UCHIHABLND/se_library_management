/**
 * CRC Card:
 * Class: AUISMember
 * Responsibilities:
 *   - Represent a student, staff, or faculty
 *   - Manage borrowed items
 * Collaborators:
 *   - LendRecord
 *   - LibraryItem
 */

public class AUISMember {
    private String auisId;
    private LibraryItem[] borrowedItems;
    private int borrowedCount;

    public AUISMember(String auisId) {
        this.auisId = auisId;
        borrowedItems = new LibraryItem[5];
        borrowedCount = 0;
    }

    public String getAuistId() {
        return auisId;
    }

    public boolean borrowItem(LibraryItem item) {
        if (borrowedCount >= 5) {
            System.out.println("Borrow limit reached!");
            return false;
        }
        borrowedItems[borrowedCount] = item;
        borrowedCount++;
        return true;
    }

    public boolean returnItem(LibraryItem item) {
        for (int i = 0; i < borrowedCount; i++) {
            if (borrowedItems[i].getLibraryId().equals(item.getLibraryId())) {
                borrowedItems[i] = borrowedItems[borrowedCount - 1]; // shift last item
                borrowedItems[borrowedCount - 1] = null;
                borrowedCount--;
                return true;
            }
        }
        return false;
    }

    public int getBorrowedCount() {
        return borrowedCount;
    }
}