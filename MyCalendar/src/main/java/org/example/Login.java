package org.example;

import java.util.Scanner;

public class Login {
    private UserManager userManager;

    public Login(UserManager userManager) {
        this.userManager = userManager;
    }

    public Utilisateur seConnecter(Scanner scanner) {
        System.out.print("Nom d'utilisateur: ");
        String username = scanner.nextLine();
        System.out.print("Mot de passe: ");
        String password = scanner.nextLine();

        return userManager.seConnecter(username, password);
    }
}
