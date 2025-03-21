package org.example.actions;

import org.example.CalendarManager;
import org.example.DureeEvenement;
import org.example.TitreEvenement;
import org.example.Utilisateur;
import org.example.event.Event;
import org.example.event.Periodique;

import java.time.LocalDateTime;
import java.util.Scanner;

public class AjoutPeriodique implements Action {
    @Override
    public void action(Scanner scanner, CalendarManager calendarManager, Utilisateur utilisateur) {
        // Demander les informations à l'utilisateur
        System.out.print("Titre de l'événement : ");
        String titre3 = scanner.nextLine();
        TitreEvenement titreEvenement2 = new TitreEvenement(titre3);

        System.out.print("Année (AAAA) : ");
        int annee3 = Integer.parseInt(scanner.nextLine());
        System.out.print("Mois (1-12) : ");
        int moisRdv3 = Integer.parseInt(scanner.nextLine());
        System.out.print("Jour (1-31) : ");
        int jourRdv3 = Integer.parseInt(scanner.nextLine());
        System.out.print("Heure début (0-23) : ");
        int heure3 = Integer.parseInt(scanner.nextLine());
        System.out.print("Minute début (0-59) : ");
        int minute3 = Integer.parseInt(scanner.nextLine());

        // Demander la fréquence en jours
        System.out.print("Fréquence (en jours) : ");
        int frequence = Integer.parseInt(scanner.nextLine());

        // Vérifier que la fréquence est valide (supérieure à 0)
        if (frequence <= 0) {
            System.out.println("La fréquence doit être supérieure à 0.");
            return;
        }

        int dureeMinutes = frequence * 1440;

        DureeEvenement dureeEvenement = new DureeEvenement(dureeMinutes);
        Periodique ePeriodique = new Periodique(titreEvenement2, utilisateur, LocalDateTime.of(annee3, moisRdv3, jourRdv3, heure3, minute3), dureeEvenement, frequence);

        boolean conflitTrouve = false;
        for (Event e : calendarManager.getEvents()) {
            if (calendarManager.conflit(ePeriodique, e)) {
                conflitTrouve = true;
                break;
            }
        }

        if (conflitTrouve) {
            System.out.println("Erreur : Il y a un conflit avec un autre événement.");
        } else {
            calendarManager.ajouterEvent(ePeriodique);
            System.out.println("Événement ajouté.");
        }
    }
}
