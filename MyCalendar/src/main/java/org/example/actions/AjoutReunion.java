package org.example.actions;

import org.example.*;
import org.example.event.Event;
import org.example.event.Reunion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AjoutReunion implements Action{
    @Override
    public void action(Scanner scanner, CalendarManager calendarManager, Utilisateur utilisateur) {
        System.out.print("Titre de l'événement : ");
        String titre2 = scanner.nextLine();
        TitreEvenement titreEvenement1 = new TitreEvenement(titre2);
        System.out.print("Année (AAAA) : ");
        int annee2 = Integer.parseInt(scanner.nextLine());
        System.out.print("Mois (1-12) : ");
        int moisRdv2 = Integer.parseInt(scanner.nextLine());
        System.out.print("Jour (1-31) : ");
        int jourRdv2 = Integer.parseInt(scanner.nextLine());
        System.out.print("Heure début (0-23) : ");
        int heure2 = Integer.parseInt(scanner.nextLine());
        System.out.print("Minute début (0-59) : ");
        int minute2 = Integer.parseInt(scanner.nextLine());
        System.out.print("Durée (en minutes) : ");
        int duree2 = Integer.parseInt(scanner.nextLine());
        DureeEvenement dureeEvenement1 = new DureeEvenement(duree2);
        System.out.println("Lieu :");
        String nomLieu = scanner.nextLine();
        Lieu lieu = new Lieu(nomLieu);

        ArrayList<Participant> participants = new ArrayList<>();

        Reunion eReunion = new Reunion(titreEvenement1, utilisateur, LocalDateTime.of(annee2, moisRdv2, jourRdv2, heure2, minute2), dureeEvenement1, lieu, participants);
        eReunion.ajouterParticipant(eReunion.getProprietaire());

        System.out.println("Ajouter un participant ? (oui / non)");

        // Corriger la boucle pour ajouter des participants

        while (scanner.nextLine().equals("oui")) {
            System.out.println("Saisir le nom du participant :");
            String nom = scanner.nextLine();
            Participant participant = new Participant(nom);
            eReunion.ajouterParticipant(participant);
        }

        boolean conflitTrouve = false;
        for (Event e : calendarManager.getEvents()) {
            if (calendarManager.conflit(eReunion, e)) {
                conflitTrouve = true;
                break;
            }
        }

        if (conflitTrouve) {
            System.out.println("Erreur : Il y a un conflit avec un autre événement.");
        } else {
            calendarManager.ajouterEvent(eReunion);
            System.out.println("Événement ajouté.");
        }
    }
}
