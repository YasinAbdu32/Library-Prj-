import java.util.Scanner;
public class LibraryBookTracker {
    private static final int MAX_BOOKS = 10;
    private static String[] bookCatalog = new String[MAX_BOOKS];
    private static int numberOfBooks = 0;

    public static void main(String[] args) {
        initializeBookCatalog();
        displayMenu();
//this is the intial menu when the code is first starting up
    }

    private static void initializeBookCatalog() {
        bookCatalog[0] = "The Alchemist";
        bookCatalog[1] = "The Great Gatsby";
        bookCatalog[2] = "To Kill a Mockingbird";
        bookCatalog[3] = "The Catcher in the Rye";
        bookCatalog[4] = "The Hitchhiker's Guide to the Galaxy";
        bookCatalog[5] = "Dreaming in Code";
        bookCatalog[6] = "Diary of Wimpy Kid Roderick Rules";
        bookCatalog[7] = "Rich Dad Poor Dad";
        bookCatalog[8] = "48 Laws of Power";
        bookCatalog[9] = "The Art of War";
        numberOfBooks = 10;
    }

    private static void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nWelcome to Library Book Tracker!");
            System.out.println("1. View Catalog");
            System.out.println("2. Search Book");
            System.out.println("3. Add Book");
            System.out.println("4. Remove Book");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
// the options shown when the code is started up
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayBookCatalog();
                    break;
                case 2:
                    searchBook();
                    break;
                case 3:
                    addBook(scanner);
                    break;
                case 4:
                    removeBook(scanner);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void displayBookCatalog() {
        System.out.println("\nBook Catalog:");
        for (int i = 0; i < numberOfBooks; i++) {
            System.out.println((i + 1) + ". " + bookCatalog[i]);
        }
    }

    private static void searchBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book title to search: ");
        String searchTitle = scanner.nextLine();
// the code behind searching the title of a book
        int position = findBook(searchTitle);
        if (position != -1) {
            System.out.println("Book found at position " + (position + 1) + "!");
// this line tells the user what line the book is found
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void addBook(Scanner scanner) {
        if (numberOfBooks < MAX_BOOKS) {
            System.out.print("Enter the new book title: ");
            String newBookTitle = scanner.nextLine();
            bookCatalog[numberOfBooks] = newBookTitle;
            numberOfBooks++;
            System.out.println("Book added successfully!");
        } else {
            System.out.println("Library is at full capacity. Cannot add more books.");
        }
    }
    public static void removeBook(Scanner scanner) {
        System.out.print("Enter the title of the book to remove: ");
        String titleToRemove = scanner.nextLine();
        int position = findBook(titleToRemove);
        if (position != -1) {
            //shift remaining books upwards upon removal
            for(int i = position; i < numberOfBooks - 1; i++){
                bookCatalog[i] = bookCatalog[i + 1];
            }
            bookCatalog[numberOfBooks - 1] = null;
            numberOfBooks--;
            System.out.println("Book \"" + titleToRemove + "\" removed from the catalog.");
        } else {
            System.out.println("Book not found.");
        }
    }
    public static int findBook(String title) {
        for (int i = 0; i < bookCatalog.length; i++) {
            if (bookCatalog[i] != null && bookCatalog[i].equalsIgnoreCase(title)) {
                return i;
            }
        }
        return -1;
    }
// needs to now have the function to remove a title, add the error messages if it doesnt work, show the prompt if book is successfully removed. also the books would need to be shifted upwards if a book is removed.
}
