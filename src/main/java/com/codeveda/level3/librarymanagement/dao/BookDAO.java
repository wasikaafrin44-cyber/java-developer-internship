package com.codeveda.level3.librarymanagement.dao;

import com.codeveda.level3.librarymanagement.connection.DBConnection;
import com.codeveda.level3.librarymanagement.table.Books;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    public void addBook(Books book) {
        String sql = "insert into books(title, author,category,available) values(?,?,?,?)";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement pr = con.prepareStatement(sql)) {

            pr.setString(1, book.getTitle());
            pr.setString(2, book.getAuthor());
            pr.setString(3, book.getCategory());
            pr.setBoolean(4, book.getAvailable());

            int row = pr.executeUpdate();

            if (row > 0) {
                System.out.println("Book added successfully!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //for view all books


    public List<Books> getAllBooks() {

        List<Books> books = new ArrayList<>();

        String query = "select  * from books";


        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery()) {


            while(rs.next()) {

                Books book = new Books();

                book.setBookId(rs.getInt("book_id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setCategory(rs.getString("category"));
                book.setAvailable(rs.getBoolean("available"));

                books.add(book);
            }


        } catch(SQLException e) {

            throw new RuntimeException(e);

        }


        return books;
    }

    public Books bookById(int bookId) {

        String sql = "select * from Books where book_id=?";


        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setInt(1, bookId);

            ResultSet rs = pr.executeQuery();

            if (rs.next()) {
                Books book = new Books();

                book.setBookId(rs.getInt("book_id"));
                book.setTitle(rs.getString("book_title"));
                book.setAuthor(rs.getString("book_author"));
                book.setCategory(rs.getString("book_category"));
                book.setAvailable(rs.getBoolean("book_available"));

                return book;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    //update book

    public void updateBook(Books book) {
        String query = "update books set title=?, author=?, category=?, available=? where book_id=?";


        try {

            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, book.getBookId());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());
            ps.setString(4, book.getCategory());
            ps.setBoolean(5, book.getAvailable());


            int row = ps.executeUpdate();

            if (row > 0) {
                System.out.println("Book updated successfully!!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public void deleteBook(int bookId) {
        String query = "delete from Books where book_id=? ";


        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement pr = con.prepareStatement(query)) {

            pr.setInt(1, bookId);

            int row = pr.executeUpdate();

            if (row > 0) {
                System.out.println("Book delete successfully");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void updateAvailabile(int bookId, String available) {

        String sql = "update books set available=? where book_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, available);
            ps.setInt(2, bookId);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
