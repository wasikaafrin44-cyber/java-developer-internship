package com.codeveda.level3.librarymanagement.dao;

import com.codeveda.level3.librarymanagement.connection.DBConnection;
import com.codeveda.level3.librarymanagement.table.Transaction;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {

    public void borrowBook(int bookId, int userId) {

        Connection con = null;

        try {

            con = DBConnection.getConnection();

            con.setAutoCommit(false);

            String checkBook = "select available froom books where book_id=?";

            PreparedStatement check = con.prepareStatement(checkBook);
            check.setInt(1, bookId);

            ResultSet rs = check.executeQuery();

            if (rs.next()) {

                boolean available = rs.getBoolean("available");

                if (!available) {
                    System.out.println("Book is not available.");
                    con.rollback();
                    return;
                }

                // Update book availability
                String updateQuery =
                        "update books set available=false where book_id=?";

                PreparedStatement pr = con.prepareStatement(updateQuery);

                pr.setInt(1, bookId);

                pr.executeUpdate();

                String query = "insert into transactions(book_id,user_id,borrow_date,status) values(?,?,?,?)";

                PreparedStatement insert = con.prepareStatement(query);

                insert.setInt(1, bookId);
                insert.setInt(2, userId);
                insert.setDate(3, Date.valueOf(LocalDate.now()));
                insert.setString(4, "BORROWED");

                insert.executeUpdate();

                con.commit();

                System.out.println("Book borrowed successfully.");

            } else {

                System.out.println("Book not found.");
                con.rollback();
            }

        } catch (Exception e) {

            try {

                if (con != null) {
                    con.rollback();
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            e.printStackTrace();

        } finally {

            try {

                if (con != null) {
                    con.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void returnBook(int transactionId) {

        Connection con = null;

        try {

            con = DBConnection.getConnection();

            con.setAutoCommit(false);

            String findBook = "select book_id from transactions where transaction_id=? and status='BORROWED'";

            PreparedStatement find = con.prepareStatement(findBook);
            find.setInt(1, transactionId);

            ResultSet rs = find.executeQuery();

            if (rs.next()) {

                int bookId = rs.getInt("book_id");

                String updateTransaction = "update transactions set return_date=?, status=? WHERE transaction_id=?";

                PreparedStatement transactionStmt = con.prepareStatement(updateTransaction);

                transactionStmt.setDate(1, Date.valueOf(LocalDate.now()));
                transactionStmt.setString(2, "RETURNED");
                transactionStmt.setInt(3, transactionId);

                transactionStmt.executeUpdate();

                // Update books table
                String updateBook = "update books set available=true where book_id=?";

                PreparedStatement bookStmt = con.prepareStatement(updateBook);

                bookStmt.setInt(1, bookId);

                bookStmt.executeUpdate();

                con.commit();

                System.out.println("Book returned successfully.");

            } else {

                System.out.println("Transaction not found.");
                con.rollback();
            }

        } catch (Exception e) {

            try {

                if (con != null) {
                    con.rollback();
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            e.printStackTrace();

        } finally {

            try {

                if (con != null) {
                    con.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



    public List<Transaction> getAllTransactions() {

        List<Transaction> transactionList = new ArrayList<>();

        String sql = "select  * from transactions";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Transaction transaction = new Transaction(
                        rs.getInt("transaction_id"),
                        rs.getInt("book_id"),
                        rs.getInt("user_id"),
                        rs.getDate("borrow_date").toLocalDate(),
                        rs.getDate("return_date") != null
                                ? rs.getDate("return_date").toLocalDate()
                                : null,
                        rs.getString("status")
                );

                transactionList.add(transaction);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transactionList;
    }
}