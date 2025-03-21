package org.example.actions;

import org.example.CalendarManager;
import org.example.DureeEvenement;
import org.example.TitreEvenement;
import org.example.Utilisateur;
import org.example.event.Event;
import org.example.event.RdvPersonnel;

import java.time.LocalDateTime;
import java.util.Scanner;

public class AjoutRdvPeso implements Action {
    @Override
    public void action(Scanner scanner, CalendarManager calendarManager, Utilisateur utilisateur) {
        // Ajout simplifié d'un RDV personnel
        System.out.print("Titre de l'événement : ");
        String titre = scanner.nextLine();
        TitreEvenement titreEvenement = new TitreEvenement(titre);

        System.out.print("Année (AAAA) : ");
        int annee = Integer.parseInt(scanner.nextLine());
        System.out.print("Mois (1-12) : ");
        int moisRdv = Integer.parseInt(scanner.nextLine());
        System.out.print("Jour (1-31) : ");
        int jourRdv = Integer.parseInt(scanner.nextLine());
        System.out.print("Heure début (0-23) : ");
        int heure = Integer.parseInt(scanner.nextLine());
        System.out.print("Minute début (0-59) : ");
        int minute = Integer.parseInt(scanner.nextLine());
        System.out.print("Durée (en minutes) : ");
        int duree = Integer.parseInt(scanner.nextLine());

        DureeEvenement dureeEvenement = new DureeEvenement(duree);
        Event eRdv = new RdvPersonnel(titreEvenement, utilisateur,
                LocalDateTime.of(annee, moisRdv, jourRdv, heure, minute), dureeEvenement);

        boolean conflitTrouve = false;
        for (Event e : calendarManager.getEvents()) {
            if (calendarManager.conflit(eRdv, e)) {
                conflitTrouve = true;
                break;
            }
        }

        if (conflitTrouve) {
            System.out.println("Erreur : Il y a un conflit avec un autre événement.");
        } else {
            calendarManager.ajouterEvent(eRdv);
            System.out.println("Événement ajouté.");
        }
    }
}
