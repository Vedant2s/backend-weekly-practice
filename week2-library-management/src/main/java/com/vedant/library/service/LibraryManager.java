import java.util.List;
import java.util.Map;

import com.vedant.library.exception.BookAlreadyBorrowedException;
import com.vedant.library.exception.BookAlreadyExists;
import com.vedant.library.exception.UserAlreadyExists;
import com.vedant.library.model.Book;
import com.vedant.library.model.User;

public class LibraryManager {
    private Map<Integer, Book> books = new HashMap<>();
    private int bookIdCounter = 1;
    private Map<Integer, User> users = new HashMap<>();
    private int userIdCounter = 1;
    private Map<Integer, Integer> borrowedBooks = new HashMap<>();
    private Map<Integer, List<Integer>> reservationQueue = new HashMap<>();

    public void addBook(String title) throws BookAlreadyExists {
        Book book = new Book(bookIdCounter++, title);
        if (books.containsKey(book.getId()))
            throw new BookAlreadyExists("This book with ID " + book.getId() + " already exists in the database.");

        books.put(book.getId(), book);
    }

    public void registerUser(String userName) throws UserAlreadyExists {
        User user = new User(userIdCounter++, userName);
        if (users.containsKey(user.getId()))
            throw new UserAlreadyExists("This user with ID " + user.getId() + " already exists in the database.");
        users.put(user.getId(), user);
    }

    public void borrowBook(int userId, int bookId) throws BookAlreadyBorrowedException {
        if (borrowedBooks.containsKey(bookId) || !books.get(bookId).getAvailable()) {
            reservationQueue.putIfAbsent(bookId, new ArrayList<>());
            reservationQueue.get(bookId).add(userId);
            throw new BookAlreadyBorrowedException("Book with ID " + bookId + " is currently borrowed. User with ID "
                    + userId + " has been added to the reservation queue.");
        } else {
            borrowedBooks.put(bookId, userId);
            books.get(bookId).setAvailable(false);
        }

    }

    public void returnBook(int bookId) {
        if (borrowedBooks.containsKey(bookId)) {
            borrowedBooks.remove(bookId);
            books.get(bookId).setAvailable(true);
            if (reservationQueue.containsKey(bookId) && !reservationQueue.get(bookId).isEmpty()) {
                int nextUserId = reservationQueue.get(bookId).remove(0);
                try {
                    borrowBook(nextUserId, bookId);
                } catch (BookAlreadyBorrowedException e) {
                    // This should not happen as we just made the book available
                    System.out.println("Unexpected error: " + e.getMessage());
                }
            }
        }
    }

    public List<Book> getBooksByUser(int userId) {
        List<Book> borrowedBooksList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : borrowedBooks.entrySet()) {
            if (entry.getValue() == userId) {
                borrowedBooksList.add(books.get(entry.getKey()));
            }
        }
        return borrowedBooksList;
    }

    public void printSystemState() {
        System.out.println("Books in the library:");
        for (Book book : books.values()) {
            System.out
                    .println("ID: " + book.getId() + ", Title: " + book.getTitle() + ", Available: " + book.getAvailable());
        }
        System.out.println("\nUsers in the library:");
        for (User user : users.values()) {
            System.out.println("ID: " + user.getId() + ", Name: " + user.getName());
        }
        System.out.println("\nBorrowed Books:");
        for (Map.Entry<Integer, Integer> entry : borrowedBooks.entrySet()) {
            System.out.println("Book ID: " + entry.getKey() + ", Borrowed by User ID: " + entry.getValue());
        }
    }
}