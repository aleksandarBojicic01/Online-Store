package com.aco.Aplication;

import com.aco.Entities.Cart;
import com.aco.Entities.DefaultCart;
import com.aco.Entities.User;
import com.aco.Menu.Menu;

public class App {
    private static App app;

    private User currentUser;
    private Cart currentUserCart;
    private Menu currentMenu;

    public static App getInstance() {
        if (app == null) {
            app = new App();
        }
        return app;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        if (currentUserCart != null) {
            currentUserCart.clear();
        }
        this.currentUser = currentUser;
    }

    public Cart getCurrentUserCart() {
        if (currentUserCart == null) {
            currentUserCart = new DefaultCart();
        }
        return currentUserCart;
    }

    public Menu getCurrentMenu() {
        return currentMenu;
    }

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }
}
