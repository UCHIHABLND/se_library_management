import java.util.Scanner;
import java.time.LocalDate;

/**
 * CRC Card:
 * Class: Main
 * Responsibilities:
 *   - Terminal interface for librarian
 * Collaborators:
 *   - Library
 *   - AUISMember
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        // Sample data
        library.addItem(new Book("B001", "Java Basics", "Intro to Java"));
        library.addItem(new Video("V001", "Java Video", "Video tutorial"));
        library.addItem(new Journal("J001", "AI Journal", "AI research paper"));
        library.addItem(new TechnicalPaper("T001", "SE Paper", "Software Eng paper"));

        AUISMember member = new AUISMember("AUIS123");

        while (true) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Lend Item");
            System.out.println("2. Return Item");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 1) {
                System.out.print("Enter Library ID: ");
                String libId = sc.nextLine();
                library.lendItem(member, libId, LocalDate.now());
            } else if (choice == 2) {
                System.out.print("Enter Library ID: ");
                String libId = sc.nextLine();
                library.returnItem(member, libId, LocalDate.now());
            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            }
        }
        sc.close();
    }
}