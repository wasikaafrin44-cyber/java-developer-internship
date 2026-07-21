package com.codeveda.level3.librarymanagement.dao;

import com.codeveda.level3.librarymanagement.connection.DBConnection;
import com.codeveda.level3.librarymanagement.table.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public void addUser(Users user) {

        String query = "insert into users(name,email,phone) values (?,?,?)";


        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {


            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPhone());


            int row = ps.executeUpdate();


            if(row > 0){
                System.out.println("User Added Successfully.");
            }

        } catch(SQLException e){
            e.printStackTrace();
        }
    }




    public List<Users> getAllUsers() {


        List<Users> usersList = new ArrayList<>();

        String query = "select * from users";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery()) {

            while(rs.next()) {

                Users user = new Users();

                user.setUserId(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                usersList.add(user);
            }

        }catch(SQLException e){

            e.printStackTrace();
        }

        return usersList;
    }
    public void updateUser(Users user) {

        String query = "update users set name=?, email=?, phone=? where user_id=?";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1,user.getName());
            ps.setString(2,user.getEmail());
            ps.setString(3,user.getPhone());
            ps.setInt(4,user.getUserId());


            int row = ps.executeUpdate();

            if(row > 0){
                System.out.println("User Updated Successfully.");
            }else{
                System.out.println("User not found.");
            }

        }catch(SQLException e){

            e.printStackTrace();

        }

    }

    public void deleteUser(int id){

        String query = "delete from users where user_id=?";


        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1,id);

            int row = ps.executeUpdate();

            if(row > 0){

                System.out.println("User deleted successfully.");

            }else{

                System.out.println("User not found.");
            }

        }catch(SQLException e){

            e.printStackTrace();
        }
    }

}