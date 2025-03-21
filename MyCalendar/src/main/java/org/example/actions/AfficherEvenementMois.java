package org.example.actions;

import org.example.CalendarManager;
import org.example.Utilisateur;

import java.time.LocalDateTime;
import java.util.Scanner;

public class AfficherEvenementMois implements Action{

    @Override
    public void action(Scanner scanner, CalendarManager calendar, Utilisateur utilisateur) {
        System.out.print("Entrez l'année (AAAA) : ");
        int anneeMois = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le mois (1-12) : ");
        int mois = Integer.parseInt(scanner.nextLine());

        LocalDateTime debutMois = LocalDateTime.of(anneeMois, mois, 1, 0, 0);
        LocalDateTime finMois = debutMois.plusMonths(1).minusSeconds(1);
        Action.afficherListe(calendar.eventsDansPeriode(debutMois, finMois));
    }
}
