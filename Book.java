public class Book {
    // Declairing private variables...
    private String bookID;
    private String title;
    private String author;
    private String genre;
    private boolean availabilityStatus;

    public Book(String bookID, String title, String author, String genre,
                boolean availabilityStatus) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availabilityStatus = availabilityStatus;

    }

    // Using Getter and Setters...
    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isAvailable() {
        return this.availabilityStatus;
    }

    public void setAvailability(boolean availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }


}
