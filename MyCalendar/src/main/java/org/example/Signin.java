package org.example;

public class Signin {
    private UserManager userManager;

    public Signin(UserManager userManager) {
        this.userManager = userManager;
    }

    public String action(String username, String password, String passwordConfirm) {
        if (!password.equals(passwordConfirm)) {
            return "Les mots de passe ne correspondent pas.";
        }

        userManager.inscrire(username, password);
        return "Inscription réussie.";
    }
}
