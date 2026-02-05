package java8Features;

/**
 * Book class for Problem 3: Book Recommendations.
 * Attributes: title, author, genre, rating.
 */
public class Book {
    private String title;
    private String author;
    private String genre;
    private double rating;

    public Book(String title, String author, String genre, double rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Book{title='" + title + "', genre='" + genre + "', rating=" + rating + "}";
    }
}
