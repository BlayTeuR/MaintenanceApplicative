package org.example;

import java.util.Scanner;

public class Login {
    private Utilisateur[] utilisateurs;
    private String[] motsDePasse;
    private int nbUtilisateurs;

    public Login(Utilisateur[] utilisateurs, String[] motsDePasse, int nbUtilisateurs) {
        this.utilisateurs = utilisateurs;
        this.motsDePasse = motsDePasse;
        this.nbUtilisateurs = nbUtilisateurs;
    }

    public Utilisateur seConnecter(Scanner scanner, CalendarManager calendar, Utilisateur utilisateur) {
        System.out.print("Nom d'utilisateur: ");
        String userName = scanner.nextLine();
        System.out.print("Mot de passe: ");
        String motDePasse = scanner.nextLine();

        for (int i = 0; i < nbUtilisateurs; i++) {
            if (utilisateurs[i].getName().equals(userName) && motsDePasse[i].equals(motDePasse)) {
                utilisateur = utilisateurs[i];
                System.out.println("Connexion réussie !");
                return utilisateur;
            }
        }

        System.out.println("Échec de la connexion. Vérifiez vos identifiants.");
        return null;
    }
}
