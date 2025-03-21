package org.example;

import java.util.*;

public class UserManager {
    private List<Utilisateur> utilisateurs;
    private Map<String, String> motsDePasse;

    public UserManager() {
        this.utilisateurs = new ArrayList<>();
        this.motsDePasse = new HashMap<>();
    }

    public boolean inscrire(String username, String password) {
        if (motsDePasse.containsKey(username)) {
            System.out.println("Ce nom d'utilisateur est déjà pris.");
            return false;
        }
        utilisateurs.add(new Utilisateur(username));
        motsDePasse.put(username, password);
        System.out.println("Compte créé avec succès !");
        return true;
    }

    public Utilisateur seConnecter(String username, String password) {
        if (motsDePasse.containsKey(username) && motsDePasse.get(username).equals(password)) {
            System.out.println("Connexion réussie !");
            return utilisateurs.stream()
                    .filter(u -> u.getName().equals(username))
                    .findFirst()
                    .orElse(null);
        }
        System.out.println("Identifiants incorrects.");
        return null;
    }
}
