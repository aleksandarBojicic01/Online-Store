package com.aco.Entities;

public class DefaultUser implements User {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private int id;
    private boolean isAdmin;

    private static int idCounter;

    public DefaultUser(String firstName, String lastName, String password, String email) {
        idCounter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.isAdmin = false;
        this.id = idCounter + 100;
    }

    @Override
    public void setAdminStatus(boolean status) {
        this.isAdmin = status;
    }

    @Override
    public boolean isAdmin() {
        return this.isAdmin;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " - " + email;
    }
}
