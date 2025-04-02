package org.example.actions;

import org.example.CalendarManager;
import org.example.Utilisateur;
import java.time.LocalDateTime;

public class AfficherEvenementJours implements Action {
    @Override
    public void action(String input, CalendarManager calendar, Utilisateur utilisateur) {
        try {
            // Conversion de l'input en année, mois et jour
            String[] dateParts = input.split("-");
            int year = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);
            int day = Integer.parseInt(dateParts[2]);

            // Calcul des bornes du jour
            LocalDateTime debutJour = LocalDateTime.of(year, month, day, 0, 0);
            LocalDateTime finJour = debutJour.plusDays(1).minusSeconds(1);

            // Affichage des événements dans cette période
            Action.afficherListe(calendar.eventsDansPeriode(debutJour, finJour));
        } catch (Exception e) {
            System.out.println("Format de date invalide. Utilisez le format 'YYYY-MM-DD'.");
        }
    }
}
