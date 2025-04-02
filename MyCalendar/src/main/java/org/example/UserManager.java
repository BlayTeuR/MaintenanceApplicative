package org.example;

import org.example.Utilisateur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserManager {
    private List<Utilisateur> utilisateurs;
    private Map<String, String> motsDePasse;

    public UserManager() {
        this.utilisateurs = new ArrayList<>();
        this.motsDePasse = new HashMap<>();
    }

    // Inscription d'un nouvel utilisateur
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

    // Connexion d'un utilisateur existant
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
