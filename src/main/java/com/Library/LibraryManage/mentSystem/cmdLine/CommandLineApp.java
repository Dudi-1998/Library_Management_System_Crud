package com.Library.LibraryManage.mentSystem.cmdLine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.Library.LibraryManage.mentSystem.dto.Book;
import com.Library.LibraryManage.mentSystem.dto.User;
import com.Library.LibraryManage.mentSystem.service.BookService;
import com.Library.LibraryManage.mentSystem.service.SerializationService;
import com.Library.LibraryManage.mentSystem.service.UserService;

import java.util.List;
import java.util.Scanner;

@Component
public class CommandLineApp implements CommandLineRunner {

 @Autowired
 private BookService bookService;

 @Autowired
 private UserService userService;
 
 @Autowired
 private SerializationService serializationService;

 private boolean adminLoggedIn = false;

 @Override
 public void run(String... args) {
     Scanner scanner = new Scanner(System.in);

     while (true) {
         System.out.println("1. Admin Login");
         System.out.println("2. Exit");
         System.out.print("Enter your choice: ");

         int choice = scanner.nextInt();

         switch (choice) {
             case 1:
                 adminLogin(scanner);
                 break;
             case 2:
                 System.out.println("Exiting the application.");
                 System.exit(0);
             default:
                 System.out.println("Invalid choice. Please try again.");
         }
     }
 }

 private void adminLogin(Scanner scanner) {
	 // For simplicity, let's have a hardcoded admin username and password.
     String adminUsername = "Rajesh";
     String adminPassword = "Rajesh@123";

     System.out.print("Enter admin username: ");
     String usernameInput = scanner.next();
     System.out.print("Enter admin password: ");
     String passwordInput = scanner.next();
     if (adminUsername.equals(usernameInput) && adminPassword.equals(passwordInput)) {
         System.out.println("Admin login successful!");
         adminLoggedIn = true;
         while (adminLoggedIn) {
             System.out.println("1. Add Book");
             System.out.println("2. View All Books");
             System.out.println("3. Issue Book to User");
             System.out.println("4. Search Book");
             System.out.println("5. Add User");
             System.out.println("6. Logout");
             System.out.print("Enter your choice: ");

             int choice = scanner.nextInt();

             switch (choice) {
                 case 1:
                     addBook(scanner);
                     break;
                 case 2:
                     viewAllBooks();
                     break;
                 case 3:
                     issueBook(scanner);
                     break;
                 case 4:
                     addUser(scanner);
                     break;
                 case 5:
                    searchBook(scanner);
                     break;
                 case 6:
                     adminLoggedIn = false;
                     System.out.println("Logged out.");
                     break;
                 default:
                     System.out.println("Invalid choice. Please try again.");
             }
         }
     }
     else
     {
    	 System.out.println("Invalid Credentials!");
     }

   
 }

 private void addBook(Scanner scanner) {
     // Implement logic to accept book details from the admin and save it
     System.out.print("Enter book title: ");
     String title = scanner.next();
     System.out.print("Enter book author: ");
     String author = scanner.next();

     Book book = new Book();
     book.setTitle(title);
     book.setAuthor(author);

     bookService.saveBook(book);

     System.out.println("Book added successfully.");
 }

 private void viewAllBooks() {
     // Implement logic to retrieve and display all books
     System.out.println("List of all books:");
     bookService.getAllBooks().forEach(System.out::println);
 }

 private void issueBook(Scanner scanner) {
     System.out.print("Enter username of the user to issue the book: ");
     String username = scanner.next();

     User user = userService.getUserByUsername(username);

     if (user == null) {
         System.out.println("User not found.");
         return;
     }

     System.out.print("Enter book title to issue: ");
     String bookTitle = scanner.next();

     Book book = (Book) bookService.searchBooks(bookTitle);

     if (book == null) {
         System.out.println("Book not found.");
         return;
     }

     System.out.println("Book issued successfully to user: " + user.getUsername());
 }
 private void addUser(Scanner scanner) {
     
     System.out.print("Enter Username ");
     String username = scanner.next();
     System.out.print("Enter Password ");
     String password = scanner.next();

    User user = new User();
    user.setUsername(username);
    user.setPassword(password);
    userService.saveUser(user);

     System.out.println("User added successfully.");
 }
 private List<Book> searchBook(Scanner Scanner)
 {
	 System.out.println("Enter Book Title Or Book Author Name");
	 String name= Scanner.next();
	 
	 return bookService.searchBooks(name);
 }
}

