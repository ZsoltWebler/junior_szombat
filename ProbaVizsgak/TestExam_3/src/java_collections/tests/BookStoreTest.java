package java_collections.tests;

import java_collections.*;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class BookStoreTest {

    private final List<Book> bookDataset = new BookDatabase().getBooks();
    private final BookStore bookStore = new BookStore(bookDataset);

    @Test
    public void getBookByNameTest() {

        Book expectedBook = new Book("Broken Glass", "978-3-4570-6124-4", new Author("Helen", "Stevenson"), Genre.SCI_FI);

        Book actualBook = bookStore.getBookByTitle("Broken Glass");

        assertEquals(expectedBook, actualBook);

    }

    @Test
    public void getAllBook() {
        List<Book> expected = bookDataset;
        List<Book> actual = bookStore.getAllBook();

        assertEquals(expected, actual);
    }

    @Test
    public void getAllBookByAuthorTest() {

        Author author = new Author("JK", "Rowling");

        List<Book> actual = bookStore.getAllBookByAuthor(author);

        assertEquals(4, actual.size());

        for (Book book : actual) {
            assertEquals(author, book.getAuthor());
        }

    }

    @Test
    public void getBooksGroupedByAuthorTest() {
        Map<Author, List<Book>> booksGroupedByAuthor = bookStore.getBooksGroupedByAuthor();

        assertEquals(13, booksGroupedByAuthor.keySet().size());
        assertEquals(21, booksGroupedByAuthor.values().stream().flatMap(Collection::stream).toList().size());

        booksGroupedByAuthor.forEach(((author, books) -> {
            for (Book book : books) {
                assertEquals(author, book.getAuthor());
            }
        }));


    }

    @Test
    public void getBooksGroupedByGenreTest() {
        fail();
    }

    @Test
    public void getBookByISBNTest() {
        fail();
    }


}
