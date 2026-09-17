import java.util.Scanner;

public class LibraryManagement {

    static Scanner sc = new Scanner(System.in);

    // Book details using arrays
    static int[] bookId = {
        101, 102, 103, 104, 105, 106, 107, 108
    };

    static String[] bookName = {
        "CALCULAS",
        "COMP_CHEMISTRY",
        "EEE",
        "EFFECTIVE COMMUNICATION",
        "THE_DOWNTOWN_CITY",
        "THE GREAT BRITAN",
        "THE LION KING",
        "THE TALE OF GALLET"
    };

    static String[] authorName = {
        "B.S. GREWEL",
        "ALEXANDAR",
        "BATTACHARYA",
        "G.V.PRAKASH",
        "GERONIMO",
        "RAMCHARAN",
        "HIT MAN",
        "VK DAS"
    };

    static String[] status = {
        "Available",
        "Available",
        "Available",
        "Available",
        "Available",
        "Available",
        "Available",
        "Available"
    };

    static int totalBooks = 8;
    static int nextBookId = 109;


    // ================= CREATE ACCOUNT =================

    static void createAccount() {

        System.out.println("\n===== CREATE ACCOUNT =====");

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your User ID: ");
        String userId = sc.nextLine();

        System.out.println("\nACCOUNT CREATED SUCCESSFULLY!");

        System.out.println("Name    : " + name);
        System.out.println("User ID : " + userId);
    }


    // ================= SHOW BOOKS =================

    static void showBooks() {

        System.out.println("\n===== AVAILABLE BOOKS =====");

        System.out.println(
            "ID\tBook Name\t\tAuthor\t\tStatus"
        );

        System.out.println(
            "---------------------------------------------------------------"
        );

        for (int i = 0; i < totalBooks; i++) {

            if (status[i].equals("Available")) {

                System.out.println(
                    bookId[i] + "\t" +
                    bookName[i] + "\t\t" +
                    authorName[i] + "\t\t" +
                    status[i]
                );
            }
        }
    }


    // ================= ADD BOOK =================

    static void addBook() {

        System.out.println("\n===== ADD NEW BOOK =====");

        System.out.print("Enter Book Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        // Create new arrays
        int[] newBookId = new int[totalBooks + 1];
        String[] newBookName = new String[totalBooks + 1];
        String[] newAuthorName = new String[totalBooks + 1];
        String[] newStatus = new String[totalBooks + 1];

        // Copy old data
        for (int i = 0; i < totalBooks; i++) {

            newBookId[i] = bookId[i];
            newBookName[i] = bookName[i];
            newAuthorName[i] = authorName[i];
            newStatus[i] = status[i];
        }

        // Add new book
        newBookId[totalBooks] = nextBookId;
        newBookName[totalBooks] = name;
        newAuthorName[totalBooks] = author;
        newStatus[totalBooks] = "Available";

        // Replace old arrays
        bookId = newBookId;
        bookName = newBookName;
        authorName = newAuthorName;
        status = newStatus;

        totalBooks++;
        nextBookId++;

        System.out.println("\nBOOK ADDED SUCCESSFULLY!");
    }


    // ================= REMOVE BOOK =================

    static void removeBook() {

        System.out.println("\n===== REMOVE BOOK =====");

        System.out.print("Enter Book Name: ");
        String name = sc.nextLine();

        boolean found = false;

        for (int i = 0; i < totalBooks; i++) {

            if (bookName[i].equalsIgnoreCase(name)) {

                if (status[i].equals("Borrowed")) {

                    System.out.println(
                        "Book is currently borrowed."
                    );

                    return;
                }

                // Move all next books one position backward
                for (int j = i; j < totalBooks - 1; j++) {

                    bookId[j] = bookId[j + 1];
                    bookName[j] = bookName[j + 1];
                    authorName[j] = authorName[j + 1];
                    status[j] = status[j + 1];
                }

                totalBooks--;

                found = true;

                System.out.println(
                    "\nBOOK REMOVED SUCCESSFULLY!"
                );

                break;
            }
        }

        if (!found) {

            System.out.println(
                "\nBOOK NOT FOUND!"
            );
        }
    }


    // ================= BORROW BOOK =================

    static void borrowBook() {

        System.out.println("\n===== BORROW BOOK =====");

        System.out.print("Enter Book Name: ");
        String name = sc.nextLine();

        boolean found = false;

        for (int i = 0; i < totalBooks; i++) {

            if (bookName[i].equalsIgnoreCase(name)) {

                found = true;

                if (status[i].equals("Available")) {

                    status[i] = "Borrowed";

                    System.out.println(
                        "\nYOU BORROWED THE BOOK SUCCESSFULLY!"
                    );

                    System.out.println(
                        "Book: " + bookName[i]
                    );

                } else {

                    System.out.println(
                        "\nBOOK IS CURRENTLY NOT AVAILABLE!"
                    );
                }

                break;
            }
        }

        if (!found) {

            System.out.println(
                "\nBOOK NOT FOUND!"
            );
        }
    }


    // ================= RETURN BOOK =================

    static void returnBook() {

        System.out.println("\n===== RETURN BOOK =====");

        System.out.print("Enter Book Name: ");
        String name = sc.nextLine();

        boolean found = false;

        for (int i = 0; i < totalBooks; i++) {

            if (bookName[i].equalsIgnoreCase(name)) {

                found = true;

                if (status[i].equals("Borrowed")) {

                    status[i] = "Available";

                    System.out.println(
                        "\nBOOK RETURNED SUCCESSFULLY!"
                    );

                } else {

                    System.out.println(
                        "\nTHIS BOOK WAS NOT BORROWED!"
                    );
                }

                break;
            }
        }

        if (!found) {

            System.out.println(
                "\nBOOK NOT FOUND!"
            );
        }
    }


    // ================= MAIN MENU =================

    static void menu() {

        int choice;

        while (true) {

            System.out.println(
                "\n===== VIT-BHOPAL LIBRARY MANAGEMENT ====="
            );

            System.out.println("1. Add Book");
            System.out.println("2. Show Available Books");
            System.out.println("3. Remove Book");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");

            System.out.print("\nEnter Your Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addBook();
                    break;

                case 2:
                    showBooks();
                    break;

                case 3:
                    removeBook();
                    break;

                case 4:
                    borrowBook();
                    break;

                case 5:
                    returnBook();
                    break;

                case 6:

                    System.out.println(
                        "\nThank you for using " +
                        "VIT-Bhopal Library Management System!"
                    );

                    return;

                default:

                    System.out.println(
                        "\nINVALID CHOICE!"
                    );
            }
        }
    }


    // ================= MAIN METHOD =================

    public static void main(String[] args) {

        System.out.println(
            "===== WELCOME TO VIT-BHOPAL LIBRARY MANAGEMENT ====="
        );

        createAccount();

        menu();

        sc.close();
    }
}