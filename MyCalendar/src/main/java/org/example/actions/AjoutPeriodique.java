package org.example.actions;

import org.example.CalendarManager;
import org.example.DureeEvenement;
import org.example.TitreEvenement;
import org.example.Utilisateur;
import org.example.event.Periodique;

import java.time.LocalDateTime;
import java.util.Scanner;

public class AjoutPeriodique implements Action{
    @Override
    public void action(Scanner scanner, CalendarManager calendarManager, Utilisateur utilisateur) {
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
        System.out.print("Frequence (en jours) : ");
        int frequence = Integer.parseInt(scanner.nextLine());

        Periodique ePeriodique = new Periodique(titreEvenement2, utilisateur, LocalDateTime.of(annee3, moisRdv3, jourRdv3, heure3, minute3), new DureeEvenement(0), frequence);

        calendarManager.ajouterEvent(ePeriodique);
        System.out.println("Événement ajouté.");
    }
}
