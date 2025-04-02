package org.example.actions;

import org.example.CalendarManager;
import org.example.Utilisateur;
import java.time.LocalDateTime;

public class AfficherEvenementMois implements Action {
    @Override
    public void action(String input, CalendarManager calendar, Utilisateur utilisateur) {
        try {
            // Conversion de l'input en année et mois
            String[] dateParts = input.split("-");
            int year = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);

            // Calcul des bornes de la période (mois)
            LocalDateTime debutMois = LocalDateTime.of(year, month, 1, 0, 0);
            LocalDateTime finMois = debutMois.plusMonths(1).minusSeconds(1);

            // Affichage des événements dans cette période
            Action.afficherListe(calendar.eventsDansPeriode(debutMois, finMois));
        } catch (Exception e) {
            System.out.println("Format de date invalide. Utilisez le format 'YYYY-MM'.");
        }
    }
}
