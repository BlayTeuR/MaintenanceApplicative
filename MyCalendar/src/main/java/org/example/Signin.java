package org.example;

import java.util.Scanner;

public class Signin {
    private Utilisateur[] utilisateurs;
    private String[] motsDePasse;
    private int nbUtilisateurs;

    public Signin(Utilisateur[] utilisateurs, String[] motsDePasse, int nbUtilisateurs) {
        this.utilisateurs = utilisateurs;
        this.motsDePasse = motsDePasse;
        this.nbUtilisateurs = nbUtilisateurs;
    }

    public void action(Scanner scanner, CalendarManager calendar, Utilisateur utilisateur) {
        System.out.print("Nom d'utilisateur: ");
        String userName = scanner.nextLine();
        System.out.print("Mot de passe: ");
        String motDePasse = scanner.nextLine();
        System.out.print("Répéter mot de passe: ");

        if (scanner.nextLine().equals(motDePasse)) {
            utilisateurs[nbUtilisateurs] = new Utilisateur(userName);
            motsDePasse[nbUtilisateurs] = motDePasse;
            nbUtilisateurs++;
            System.out.println("Compte créé avec succès !");
        } else {
            System.out.println("Les mots de passe ne correspondent pas.");
        }
    }
}
