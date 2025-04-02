package org.example;

public class Login {
    private UserManager userManager;

    public Login(UserManager userManager) {
        this.userManager = userManager;
    }

    public Utilisateur seConnecter(String username, String password) {
        return userManager.seConnecter(username, password);
    }
}
