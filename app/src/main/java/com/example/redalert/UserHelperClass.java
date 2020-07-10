package com.example.redalert;

public class UserHelperClass {

    String name, username, email, phone, password;

    public UserHelperClass() {

    }

    public UserHelperClass(String name, String username, String email, String phone, String password) {

        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phone;
    }

    public void setPhoneNo(String phoneNo) {
        this.phone = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
