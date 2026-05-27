import java.util.List;
import java.util.Map;

import com.vedant.library.exception.BookAlreadyExists;
import com.vedant.library.model.Book;
import com.vedant.library.model.User;

public class LibraryManager {
    private Map<Integer, Book> books = new HashMap<>();
    private Map<Integer, User> users = new HashMap<>();
    private Map<Integer, Integer> borrowedBooks = new HashMap<>();
    private Map<Integer, List<Integer>> reservationQueue = new HashMap<>();

    public void addBook(Book book) throws BookAlreadyExists {
        if (books.containsKey(book.getId()))
            throw new BookAlreadyExists("This book already exists in the database.");
        books.put(book.getId(), book);
    }

    public void registerUser(User user) {
    }

    public void borrowBook(int userId, int bookId) {
    }

    public void returnBook(int bookId) {
    }

    public List<Book> getBooksByUser(int userId) {
    }

    public void printSystemState() {
    }
}