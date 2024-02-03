package java_collections;

import java.util.ArrayList;
import java.util.List;

public class BookDatabase {

    private final List<Book> bookList;


    public BookDatabase() {
        this.bookList = new ArrayList<>();

        bookList.add(new Book("I Feel Bad About My Neck", "978-6-6818-5060-8", new Author("Nora", "Ephron"), Genre.HISTORY));
        bookList.add(new Book("Broken Glass", "978-3-4570-6124-4", new Author("Helen", "Stevenson"), Genre.SCI_FI));
        bookList.add(new Book("The Girl With the Dragon Tattoo", "978-3-9645-2670-0", new Author("Stieg", "Larsson"), Genre.ADVENTURE));
        bookList.add(new Book("Harry Potter and the Goblet of Fire", "978-0-7051-7513-5", new Author("JK", "Rowling"), Genre.YOUNG_ADULT));
        bookList.add(new Book("Harry Potter and the Chamber of Secrets", "978-3-5385-3108-6", new Author("JK", "Rowling"), Genre.YOUNG_ADULT));
        bookList.add(new Book("Harry Potter and the Order of the Phoenix", "978-8-1248-1251-8", new Author("JK", "Rowling"), Genre.YOUNG_ADULT));
        bookList.add(new Book("Harry Potter and the Deathly Hallows", "978-6-3106-1364-2", new Author("JK", "Rowling"), Genre.YOUNG_ADULT));
        bookList.add(new Book("Birth of a Killer", "978-3-0465-7433-9", new Author("Darren", "Shan"), Genre.HORROR));
        bookList.add(new Book("Ocean of Blood", "978-0-2737-3540-3", new Author("Darren", "Shan"), Genre.HORROR));
        bookList.add(new Book("Palace of the Damned", "978-8-4103-3169-3", new Author("Darren", "Shan"), Genre.HORROR));
        bookList.add(new Book("Brothers to the Death", "978-1-2581-0238-8", new Author("Darren", "Shan"), Genre.HORROR));
        bookList.add(new Book("The Lake of Souls", "978-7-5740-5141-6", new Author("Darren", "Shan"), Genre.HORROR));
        bookList.add(new Book("Lord of the Shadows", "978-4-3031-3605-5", new Author("Darren", "Shan"), Genre.HORROR));
        bookList.add(new Book("A Little Life", "978-1-1153-5912-2", new Author("Hanya", "Yanagihara"), Genre.HISTORY));
        bookList.add(new Book("Chronicles: Volume One", "978-0-6139-2797-0", new Author("Bob", "Dylan"), Genre.FANTASY));
        bookList.add(new Book("The Tipping Point", "978-5-2462-0938-7", new Author("Malcolm", "Gladwell"), Genre.ADVENTURE));
        bookList.add(new Book("Darkmans", "978-7-9371-7970-2", new Author("Nicola", "Barker"), Genre.CRIME));
        bookList.add(new Book("The Siege", "978-2-2835-2617-0", new Author("Helen", "Dunmore"), Genre.CRIME));
        bookList.add(new Book("Light", "978-3-8301-2062-9", new Author("M John", "Harrison"), Genre.HISTORY));
        bookList.add(new Book("Visitation", "978-1-7116-8998-2", new Author("Jenny", "Erpenbeck"), Genre.FANTASY));
        bookList.add(new Book("Bad Blood", "978-0-4003-7725-4", new Author("Lorna", "Sage"), Genre.SCI_FI));
    }

    public List<Book> getBooks() {
        return bookList;
    }
}
