package com.example.novigrad;

public class user {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String id;
    private String role;

    public user() { }

    public user (String firstName, String lastName, String email, String role){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public void setId(String id ) {
        this.id = id;
    }
    public String getfirstName() {
        return firstName;
    }
    public void setFirstName(String name) {
        this.firstName = name;
    }
    public String getlastName() {
        return lastName;
    }
    public void setlastName(String name) {
        this.lastName = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getrolee() {
        return role;
    }
    public void setrole(String role) {
        this.role = role;
    }


}

