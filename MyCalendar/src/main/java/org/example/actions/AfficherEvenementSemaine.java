package org.example.actions;

import org.example.CalendarManager;
import org.example.Utilisateur;
import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class AfficherEvenementSemaine implements Action {
    @Override
    public void action(String input, CalendarManager calendar, Utilisateur utilisateur) {
        try {
            // L'input doit être sous le format 'AAAA-WW' où 'AAAA' est l'année et 'WW' le numéro de la semaine
            String[] inputParts = input.split("-");
            int year = Integer.parseInt(inputParts[0]);
            int week = Integer.parseInt(inputParts[1]);

            // Détermination de la date de début de la semaine
            LocalDateTime debutSemaine = LocalDateTime.now()
                    .withYear(year)
                    .with(WeekFields.of(Locale.FRANCE).weekOfYear(), week)
                    .with(WeekFields.of(Locale.FRANCE).dayOfWeek(), 1)
                    .withHour(0).withMinute(0);

            // Fin de la semaine (7 jours plus tard)
            LocalDateTime finSemaine = debutSemaine.plusDays(7).minusSeconds(1);

            // Affichage des événements dans cette période
            Action.afficherListe(calendar.eventsDansPeriode(debutSemaine, finSemaine));
        } catch (Exception e) {
            System.out.println("Format de semaine invalide. Utilisez le format 'AAAA-WW' (ex : 2025-01 pour la première semaine de 2025).");
        }
    }
}
