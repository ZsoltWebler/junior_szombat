package java_collections;

import java.util.Objects;

public class Book {

    private final String title;
    private final String isbn;
    private final Author author;
    private final Genre genre;


    public Book(String title, String isbn, Author author, Genre genre) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public Author getAuthor() {
        return author;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(isbn, book.isbn) && Objects.equals(author, book.author) && genre == book.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, isbn, author, genre);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", author=" + author +
                ", genre=" + genre +
                '}';
    }
}
