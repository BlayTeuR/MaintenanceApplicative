package org.example.actions;

import org.example.CalendarManager;
import org.example.Utilisateur;

import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Scanner;

public class AfficherEvenementSemaine implements Action{

    @Override
    public void action(Scanner scanner, CalendarManager calendar, Utilisateur utilisateur) {
        System.out.print("Entrez l'année (AAAA) : ");
        int anneeSemaine = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le numéro de semaine (1-52) : ");
        int semaine = Integer.parseInt(scanner.nextLine());

        LocalDateTime debutSemaine = LocalDateTime.now()
                .withYear(anneeSemaine)
                .with(WeekFields.of(Locale.FRANCE).weekOfYear(), semaine)
                .with(WeekFields.of(Locale.FRANCE).dayOfWeek(), 1)
                .withHour(0).withMinute(0);
        LocalDateTime finSemaine = debutSemaine.plusDays(7).minusSeconds(1);

        Action.afficherListe(calendar.eventsDansPeriode(debutSemaine, finSemaine));
    }
}
