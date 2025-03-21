package org.example;

import org.example.actions.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        CalendarManager calendar = new CalendarManager();
        Scanner scanner = new Scanner(System.in);
        Utilisateur utilisateur = null;
        boolean continuer = true;

        Utilisateur utilisateurs[] = new Utilisateur[99];
        String motsDePasses[] = new String[99];
        int nbUtilisateurs = 0;

        Map<String, Action> eventActions = new HashMap<>();
        eventActions.put("1", new ActionAfficherEvenements());
        eventActions.put("2", new AfficherEvenementMois());
        eventActions.put("3", new AfficherEvenementSemaine());
        eventActions.put("4", new AfficherEvenementJours());

        Map<String, Action> actions = new HashMap<>();
        actions.put("2", new AjoutRdvPeso());
        actions.put("3", new AjoutReunion());
        actions.put("4", new AjoutPeriodique());



        while (true) {

            if (utilisateur == null) {
                System.out.println("  _____         _                   _                __  __");
                System.out.println(" / ____|       | |                 | |              |  \\/  |");
                System.out.println(
                        "| |       __ _ | |  ___  _ __    __| |  __ _  _ __  | \\  / |  __ _  _ __    __ _   __ _   ___  _ __");
                System.out.println(
                        "| |      / _` || | / _ \\| '_ \\  / _` | / _` || '__| | |\\/| | / _` || '_ \\  / _` | / _` | / _ \\| '__|");
                System.out.println(
                        "| |____ | (_| || ||  __/| | | || (_| || (_| || |    | |  | || (_| || | | || (_| || (_| ||  __/| |");
                System.out.println(
                        " \\_____| \\__,_||_| \\___||_| |_| \\__,_| \\__,_||_|    |_|  |_| \\__,_||_| |_| \\__,_| \\__, | \\___||_|");
                System.out.println(
                        "                                                                                   __/ |");
                System.out.println(

                        "                                                                                  |___/");
                    System.out.println("1 - Se connecter");
                    System.out.println("2 - Créer un compte");
                    System.out.print("Choix : ");
                    String choix = scanner.nextLine();

                    if (choix.equals("1")) {
                        utilisateur = new Login(utilisateurs, motsDePasses, nbUtilisateurs).seConnecter(scanner, calendar, utilisateur);
                    } else if (choix.equals("2")) {
                        new Signin(utilisateurs, motsDePasses, nbUtilisateurs).action(scanner, calendar, utilisateur);
                    }
                }

            while (continuer && utilisateur != null) {
                System.out.println("\nBonjour, " + utilisateur.getName());
                System.out.println("=== Menu Gestionnaire d'Événements ===");
                System.out.println("1 - Voir les événements");
                System.out.println("2 - Ajouter un rendez-vous perso");
                System.out.println("3 - Ajouter une réunion");
                System.out.println("4 - Ajouter un évènement périodique");
                System.out.println("5 - Se déconnecter");
                System.out.print("Votre choix : ");

                String choix = scanner.nextLine();

                switch (choix) {
                    case "1":
                        System.out.println("\n=== Menu de visualisation d'Événements ===");
                        System.out.println("1 - Afficher TOUS les événements");
                        System.out.println("2 - Afficher les événements d'un MOIS précis");
                        System.out.println("3 - Afficher les événements d'une SEMAINE précise");
                        System.out.println("4 - Afficher les événements d'un JOUR précis");
                        System.out.println("5 - Retour");
                        System.out.print("Votre choix : ");

                        choix = scanner.nextLine();

                        Action action = eventActions.get(choix);
                        if (action != null) {
                            action.action(scanner, calendar, utilisateur);
                        } else {
                            System.out.println("Choix invalide, veuillez réessayer.");
                        }

                    case "2":
                        // Ajout simplifié d'un RDV personnel

                        choix = scanner.nextLine();

                        Action actionBis = actions.get(choix);
                        if (actionBis != null) {
                            actionBis.action(scanner, calendar, utilisateur);
                        } else {
                            System.out.println("Choix invalide, veuillez réessayer.");
                        }

                    default:
                        System.out.println("Déconnexion ! Voulez-vous continuer ? (O/N)");
                        continuer = scanner.nextLine().trim().equalsIgnoreCase("oui");

                        utilisateur = null;
                }
            }
        }
    }
}
