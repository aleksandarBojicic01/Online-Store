package com.aco.Menu;

import com.aco.Aplication.App;
import com.aco.Services.DefaultUserManagementService;
import com.aco.Services.UserManagementService;

public class SignOutMenu implements Menu {
    private App app;
    private UserManagementService userManagementService;

    {
        app = App.getInstance();
        userManagementService = DefaultUserManagementService.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();

        app.setCurrentUser(null);
        app.getCurrentMenu().start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("*****Sign Out*****");
        System.out.println("Goodbye, looking forward to seeing you back!");
    }
}
