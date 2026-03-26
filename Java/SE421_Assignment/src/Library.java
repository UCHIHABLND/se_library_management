import java.time.LocalDate;

/**
 * CRC Card:
 * Class: Library
 * Responsibilities:
 *   - Manage items and lend records
 *   - Search, lend, return items
 * Collaborators:
 *   - LibraryItem
 *   - AUISMember
 *   - LendRecord
 */

public class Library {
    private LibraryItem[] items;
    private LendRecord[] records;
    private int itemCount;
    private int recordCount;

    public Library() {
        items = new LibraryItem[100];
        records = new LendRecord[100];
        itemCount = 0;
        recordCount = 0;
    }

    public void addItem(LibraryItem item) {
        items[itemCount] = item;
        itemCount++;
    }

    public LibraryItem searchItem(String libraryId) {
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getLibraryId().equals(libraryId)) {
                return items[i];
            }
        }
        return null;
    }

    public void lendItem(AUISMember member, String libraryId, LocalDate today) {
        LibraryItem item = searchItem(libraryId);
        if (item == null) {
            System.out.println("Item not found!");
            return;
        }
        if (!member.borrowItem(item)) {
            return; // borrow limit reached
        }
        records[recordCount] = new LendRecord(item, member, today);
        recordCount++;
        System.out.println("Item lent successfully.");
        printTable(today);
    }

    public void returnItem(AUISMember member, String libraryId, LocalDate returnDate) {
        for (int i = 0; i < recordCount; i++) {
            LendRecord record = records[i];
            if (record.getItem().getLibraryId().equals(libraryId)
                && record.getBorrower().getAuistId().equals(member.getAuistId())) {
                double fine = record.calculateFine(returnDate);
                member.returnItem(record.getItem());
                System.out.println("Item returned. Fine: $" + fine);
                // remove record
                records[i] = records[recordCount - 1];
                records[recordCount - 1] = null;
                recordCount--;
                printTable(returnDate);
                return;
            }
        }
        System.out.println("Lend record not found!");
    }

    public void printTable(LocalDate today) {
        System.out.println("=== Lend Records ===");
        for (int i = 0; i < recordCount; i++) {
            records[i].printRecord(today);
        }
        System.out.println("====================");
    }
}