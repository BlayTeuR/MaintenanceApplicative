package org.example.actions;

import org.example.CalendarManager;
import org.example.Utilisateur;

import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Scanner;

public class AfficherEvenementJours implements Action{

    @Override
    public void action(Scanner scanner, CalendarManager calendar, Utilisateur utilisateur) {
        System.out.print("Entrez l'année (AAAA) : ");
        int anneeJour = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le mois (1-12) : ");
        int moisJour = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le jour (1-31) : ");
        int jour = Integer.parseInt(scanner.nextLine());

        LocalDateTime debutJour = LocalDateTime.of(anneeJour, moisJour, jour, 0, 0);
        LocalDateTime finJour = debutJour.plusDays(1).minusSeconds(1);

        Action.afficherListe(calendar.eventsDansPeriode(debutJour, finJour));
    }
}
