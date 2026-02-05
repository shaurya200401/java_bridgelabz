package java8Features;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem 3: Book Recommendations
 * Operations: Filter, Transform, Sort, Paginate.
 */
public class BookRecommendations {

    // DTO for recommendations
    static class BookRecommendation {
        String title;
        double rating;

        public BookRecommendation(String title, double rating) {
            this.title = title;
            this.rating = rating;
        }

        @Override
        public String toString() {
            return title + " (" + rating + ")";
        }
    }

    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Dune", "Frank Herbert", "Science Fiction", 4.8),
                new Book("Neuromancer", "William Gibson", "Science Fiction", 4.5),
                new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", 4.9),
                new Book("Foundation", "Isaac Asimov", "Science Fiction", 4.2),
                new Book("Ender's Game", "Orson Scott Card", "Science Fiction", 4.7),
                new Book("1984", "George Orwell", "Dystopian", 4.6),
                new Book("Snow Crash", "Neal Stephenson", "Science Fiction", 4.1),
                new Book("Solaris", "Stanislaw Lem", "Science Fiction", 3.9));

        System.out.println("--- 1. Filter: Sci-Fi & Rating > 4.0 ---");
        List<Book> filteredBooks = books.stream()
                .filter(b -> "Science Fiction".equals(b.getGenre()) && b.getRating() > 4.0)
                .collect(Collectors.toList());
        filteredBooks.forEach(System.out::println);

        System.out.println("\n--- 2. Transform: To BookRecommendation (Title, Rating) ---");
        List<BookRecommendation> recommendations = filteredBooks.stream()
                .map(b -> new BookRecommendation(b.getTitle(), b.getRating()))
                .collect(Collectors.toList());
        recommendations.forEach(System.out::println);

        System.out.println("\n--- 3. Sort: By Rating Descending ---");
        // Re-sorting the original filtered list or the recommendations
        recommendations.sort(Comparator.comparingDouble((BookRecommendation b) -> b.rating).reversed());
        recommendations.forEach(System.out::println);

        System.out.println("\n--- 4. Paginate: Page 1 (Items 1-5, though we have fewer) ---");
        int pageSize = 5;
        int page = 0; // 0-indexed page
        recommendations.stream()
                .skip(page * pageSize)
                .limit(pageSize)
                .forEach(System.out::println);
    }
}
