package com.aco.Entities;

public interface User {
    String getFirstName();
    String getLastName();
    String getPassword();
    String getEmail();
    boolean isAdmin();
    int getId();
    void setPassword(String password);
    void setEmail(String email);
    void setAdminStatus(boolean status);
}
