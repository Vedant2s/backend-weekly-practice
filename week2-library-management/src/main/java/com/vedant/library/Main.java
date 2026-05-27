import java.util.Scanner;

import com.vedant.library.service.LibraryManager;

public class Main {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("""
                        1. Add Books
                        2. Register user
                        3. Borrow a Book
                        4. Return a Book
                        4. Print the system state
                        0. Exit
                    """);
            System.out.println("Enter your choice: \t");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    try {
                        System.out.println("Enter book title: \t");
                        String title = sc.nextLine();
                        manager.addBook(title);
                    } catch (BookAlreadyExists e) {
                        System.out.println("Exception occured : " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Exception occured : " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Enter user name: \t");
                        String name = sc.nextLine();
                        manager.registerUser(name);
                    } catch (UserAlreadyExists e) {
                        System.out.println("Exception occured : " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Exception occured : " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Enter user ID: \t");
                        int userId = sc.nextInt();
                        System.out.println("Enter book ID: \t");
                        int bookId = sc.nextInt();
                        manager.borrowBook(userId, bookId);
                    } catch (BookAlreadyBorrowedException e) {
                        System.out.println("Exception occured : " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Exception occured : " + e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        manager.printSystemState();
                    } catch (Exception e) {
                        System.out.println("Exception occured : " + e.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("Exited the system...");
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }
}