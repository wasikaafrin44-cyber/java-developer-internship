package com.codeveda.level3.librarymanagement.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String url = "jdbc:postgresql://localhost:5432/internshipDB";
    private static final String user = "postgres";

    private static final String password = "admin";

    public static Connection getConnection(){
        Connection connection=null;

            try {
                connection= DriverManager.getConnection(url,user,password);

                System.out.println("Connection  successful");
            }
                catch (SQLException e) {
                    System.out.println("Connection Failed!");
                    e.printStackTrace();
                }
        return connection;

    }
    }

