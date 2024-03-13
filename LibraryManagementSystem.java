import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Library library = new Library();

        System.out.println("This is library management system");
        System.out.println("1. Add Book");
        System.out.println("2. Add User");
        System.out.println("3. Display Books");
        System.out.println("4. Check Out Book");
        System.out.println("5. Return Book");
        System.out.println("6. Search Book by Title");
        System.out.println("7. Search Book by Author");

        System.out.println("0. Exit");

        System.out.print("Enter what you want to do:");
        int choice = input.nextInt();
        input.nextLine();
        switch (choice) {
            case 1:
                System.out.print("\nEnter the Book ID: ");
                String bookID = input.nextLine();
                System.out.print("Enter theTitle: ");
                String title = input.nextLine();
                System.out.print("Enter the name of Author: ");
                String author = input.nextLine();
                System.out.print("Enter Genre of book: ");
                String genre = input.nextLine();
                System.out.print("Enter Availability status (true or false): ");
                boolean availability = input.nextBoolean();
                library.addBook(new Book(bookID, title, author, genre, availability));
                break;
            case 2:
                System.out.print("Enter the User ID: ");
                String userID = input.nextLine();
                System.out.print("Enter the Name: ");
                String name = input.nextLine();
                System.out.print("Enter Contact Information: ");
                String contactInfo = input.nextLine();
                library.addUser(new User(userID, name, contactInfo));
                break;
            case 3:
                library.displayBooks();
                break;
            case 4:
                System.out.print("Enter the Book ID: ");
                String bookIDToBorrow = input.nextLine();
                System.out.print("Enter the User ID: ");
                String userIDToBorrow = input.nextLine();
                library.checkOutBook(bookIDToBorrow, userIDToBorrow);
                break;
            case 5:
                System.out.print("Enter the Book ID: ");
                String bookIDToReturn = input.nextLine();
                System.out.print("Enter the  User ID: ");
                String userIDToReturn = input.nextLine();
                library.returnBook(bookIDToReturn, userIDToReturn);
                break;
            case 6:
                System.out.print("Enter the Title: ");
                String searchTitle = input.nextLine();
                List<Book> booksByTitle = library.searchBookByTitle(searchTitle);
                if (booksByTitle.isEmpty()) {
                    System.out.println("No books found with the title: " + searchTitle);
                }
                else {
                    System.out.println("Books with the title '" + searchTitle + "':");
                    for (Book book : booksByTitle) {
                        System.out.println("Book ID: " + book.getBookID());
                        System.out.println("Title: " + book.getTitle());
                        System.out.println("Author: " + book.getAuthor());
                        System.out.println("Genre: " + book.getGenre());
                        System.out.println(
                                "Availability: " + (book.isAvailable() ? "Available" :
                                                    "Not Available"));
                        System.out.println();
                    }
                }
                break;

            case 7:
                System.out.print("Enter the Author: ");
                String searchAuthor = input.nextLine();
                List<Book> booksByAuthor = library.searchBookByAuthor(searchAuthor);

                if (booksByAuthor.isEmpty()) {
                    System.out.println("No books found for the author: " + searchAuthor);
                }
                else {
                    System.out.println("Books by author '" + searchAuthor + "':");
                    for (Book book : booksByAuthor) {
                        System.out.println("Book ID: " + book.getBookID());
                        System.out.println("Title: " + book.getTitle());
                        System.out.println("Author: " + book.getAuthor());
                        System.out.println("Genre: " + book.getGenre());
                        System.out.println(
                                "Availability: " + (book.isAvailable() ? "Available" :
                                                    "Not Available"));
                        System.out.println();
                    }
                }
                break;


            case 0:
                System.out.println("System is exiting...");
                System.exit(0);
            default:
                System.out.println("Invalid choice!");
        }

    }
}
