package com.codeveda.level3.librarymanagement.table;

public class Users {

    private int userId;
    private String name;
    private String email;
    private String phone;


    // Default constructor (JDBC ResultSet থেকে object বানানোর জন্য)
    public Users() {

    }


    // Parameterized constructor (Main class থেকে data নেওয়ার জন্য)
    public Users(int userId, String name, String email, String phone) {

        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phone = phone;

    }


    public int getUserId() {
        return userId;
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}