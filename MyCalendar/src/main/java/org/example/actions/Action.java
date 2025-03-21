package org.example.actions;

import org.example.CalendarManager;
import org.example.Utilisateur;
import org.example.event.Event;

import java.util.List;
import java.util.Scanner;

public interface Action {

    void action(Scanner scanner, CalendarManager calendarManager, Utilisateur utilisateur);

    static void afficherListe(List<Event> evenements) {
        if (evenements.isEmpty()) {
            System.out.println("Aucun événement trouvé pour cette période.");
        } else {
            System.out.println("Événements trouvés : ");
            for (Event e : evenements) {
                System.out.println("- " + e.description());
            }
        }
    }
}
