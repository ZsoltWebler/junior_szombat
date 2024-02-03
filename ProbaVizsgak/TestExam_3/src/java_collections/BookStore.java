package java_collections;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookStore {

    private final List<Book> bookList;

    public BookStore(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Book getBookByTitle(String title) {

        return bookList.stream().filter(book -> book.getGenre().equals(title)).findFirst().orElse(null);

    }

    public List<Book> getAllBook() {
        return bookList;
    }

    public List<Book> getAllBookByAuthor(Author author) {
        return bookList.stream().filter(book -> book.getGenre().equals(author)).toList();
    }

    public Map<Author, List<Book>> getBooksGroupedByAuthor() {

        return bookList.stream().collect(Collectors.groupingBy(Book::getAuthor));

    }

    public Map<Genre, List<Book>> getBooksGroupedByGenre(Genre genre) {
        return null;
    }

    public Book getBookByISBN(String isbn) {
        return null;
    }


}
