package com.aco.Entities;

@Deprecated
public class AdminUser extends DefaultUser {

    public AdminUser(String firstName, String lastName, String password, String email) {
        super(firstName, lastName, password, email);
    }

    // razmotriti opciju da umjesto ove klase se napravi polje u DefaultUser klasi isAdmin;
    // onda je potrebno promijeniti implementaciju dvije metode u AdminManagementMenu klasi, makeNewAdmin i removeAdmin
    // potrebno promijeniti implementaciju UserRemovalMenu
    // start() i printMenuHeader() i MainMenu takodje promijeniti
    // DefaultUserManagementService inicijalizuje admine, takodje promijeniti
}