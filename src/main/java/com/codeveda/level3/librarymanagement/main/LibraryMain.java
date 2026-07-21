package com.codeveda.level3.librarymanagement.main;

import com.codeveda.level3.librarymanagement.dao.BookDAO;
import com.codeveda.level3.librarymanagement.dao.UserDAO;
import com.codeveda.level3.librarymanagement.dao.TransactionDAO;
import com.codeveda.level3.librarymanagement.table.Books;
import com.codeveda.level3.librarymanagement.table.Transaction;
import com.codeveda.level3.librarymanagement.table.Users;

import java.util.List;
import java.util.Scanner;

public class LibraryMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BookDAO bookDAO = new BookDAO();

        UserDAO userDAO = new UserDAO();
        TransactionDAO transactionDAO = new TransactionDAO();

        while (true) {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Add User");
            System.out.println("4. View Users");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. View Transactions");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();


            switch (choice) {

                case 1:

                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");

                    String author = sc.nextLine();
                    System.out.print("Enter Category: ");

                    String category = sc.nextLine();

                    Books book = new Books(0, title, author, category, true);

                    bookDAO.addBook(book);

                    System.out.println("Book added successfully.");

                    break;

                case 2:
                    List<Books> books = bookDAO.getAllBooks();
                    System.out.println("\n###Books ###");

                    for(Books b : books){
                        System.out.println(b);

                    }
                    break;

                case 3:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");

                    String email = sc.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();
                    Users user = new Users(0,name,email,phone);

                    userDAO.addUser(user);
                    break;
                case 4:
                    List<Users> users = userDAO.getAllUsers();

                    System.out.println("\n--Users --");
                    for(Users u : users){

                        System.out.println(u);

                    }
                    break;
                    case 5:

                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();

                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();

                    transactionDAO.borrowBook(bookId,userId);
                    break;

                case 6:
                    System.out.print("Enter Transaction ID: ");
                    int transactionId = sc.nextInt();

                    transactionDAO.returnBook(transactionId);
                    break;

                case 7:
                    List<Transaction> transactions =
                            transactionDAO.getAllTransactions();

                    System.out.println("\n ==Transactions==");


                    for(Transaction t : transactions){

                        System.out.println(t);

                    }
                    break;

                case 8:

                    System.out.println("Thank you for using Library System.");

                    sc.close();

                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");

            }
        }
    }
}