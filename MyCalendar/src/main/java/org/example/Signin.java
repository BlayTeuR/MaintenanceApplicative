package org.example;

import java.util.Scanner;

public class Signin {
    private UserManager userManager;

    public Signin(UserManager userManager) {
        this.userManager = userManager;
    }

    public void action(Scanner scanner) {
        System.out.print("Nom d'utilisateur: ");
        String username = scanner.nextLine();
        System.out.print("Mot de passe: ");
        String password = scanner.nextLine();
        System.out.print("Répéter mot de passe: ");
        String passwordConfirm = scanner.nextLine();

        if (!password.equals(passwordConfirm)) {
            System.out.println("Les mots de passe ne correspondent pas.");
            return;
        }

        userManager.inscrire(username, password);
    }
}
