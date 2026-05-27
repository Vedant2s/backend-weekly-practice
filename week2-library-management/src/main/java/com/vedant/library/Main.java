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
                        4. Print the system state
                        0. Exit
                    """);
            System.out.println("Enter your choice: \t");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    try {
                        System.out.println("Enter book id: \t");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter book title: \t");
                        String title = sc.nextLine();
                        manager.addBook(new Book(id, title));
                    } catch (BookAlreadyExists e) {
                        System.out.println("Exception occured : " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Exception occured : " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        manager.registerUser(new User(1, "Vedant"));
                    } catch (Exception e) {
                        System.out.println("Exception occured : " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        manager.borrowBook(1, 1);
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