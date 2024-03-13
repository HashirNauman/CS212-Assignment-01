import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;
    private static final String bookFile = "books.txt";
    private static final String userFile = "users.txt";

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        loadBooks();
        loadUsers();
    }

    public void addBook(Book book) {
        books.add(book);
        saveBooks();
    }

    public void addUser(User user) {
        users.add(user);
        saveUsers();

    }

    public void loadBooks() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(bookFile));
            for (String line : lines) {
                String[] parts = line.split(",");
                books.add(new Book(parts[0], parts[1], parts[2], parts[3],
                                   Boolean.parseBoolean(parts[4])));
            }

        }
        catch (IOException e) {
            System.out.println("Something went wrong in loading books...");
        }
    }

    public void saveBooks() {
        try {
            List<String> lines = new ArrayList<>();
            for (Book book : books) {
                lines.add(book.getBookID() + "," + book.getTitle() + "," + book.getAuthor() + ","
                                  + book.getGenre() + "," + book.isAvailable());

            }
            Files.write(Paths.get(bookFile), lines);
        }
        catch (IOException e) {
            System.out.println("Something went wrong while saving the book's info...");
        }
    }

    public void loadUsers() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(userFile));
            for (String line : lines) {
                String parts[] = line.split(",");
                users.add(new User(parts[0], parts[1], parts[2]));

            }
        }
        catch (IOException e) {
            System.out.println("Something went wrong while loading the users...");
        }
    }

    public void saveUsers() {
        try {
            List<String> lines = new ArrayList<>();
            for (User user : users) {
                lines.add(user.getUserID() + "," + user.getName() + "," + user.getContactInfo());

            }
            Files.write(Paths.get(userFile), lines);
        }
        catch (IOException e) {
            System.out.println("Something went wrong while saving the user's info ...");
        }
    }

    public List<Book> searchBookByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> searchBookByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public Book searchBookByID(String bookID) {
        for (Book book : books) {
            if (book.getBookID().equals(bookID)) {
                return book;
            }
        }
        return null;
    }

    public User searchUserByID(String userID) {
        for (User user : users) {
            if (user.getUserID().equals(userID)) {
                return user;
            }
        }
        return null;
    }

    public void checkOutBook(String bookID, String userID) {
        Book book = searchBookByID(bookID);
        User user = searchUserByID(userID);
        if (book == null) {
            System.out.println("Book not found...");
            return;
        }
        if (user == null) {
            System.out.println("User not found...");
            return;
        }
        if (!book.isAvailable()) {
            System.out.println("Book is not available...");
            return;
        }
        book.setAvailability(false);
        user.addBorrowedBook(book);
        saveBooks();
        saveUsers();
    }

    public void returnBook(String bookID, String userID) {
        Book book = searchBookByID(bookID);
        User user = searchUserByID(userID);
        if (book == null) {
            System.out.println("Book not found...");
            return;
        }
        if (user == null) {
            System.out.println("User not found...");
            return;
        }
        if (!user.hasBorrowedBooks(book)) {
            System.out.println("User does not have borrowed this book");
            return;
        }
        book.setAvailability(true);
        user.removeBorrowedBook(book);
        saveBooks();
        saveUsers();


    }

    public void displayBooks() {
        System.out.println("Books in the library:");
        for (Book book : books) {
            System.out.println(
                    "Book ID: " + book.getBookID() + ", Title: " + book.getTitle() + ", Author: "
                            + book.getAuthor() + ", Genre: " + book.getGenre() + ", Availability: "
                            + book.isAvailable());
        }
    }


}
