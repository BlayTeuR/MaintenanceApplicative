package org.example.actions;

import org.example.CalendarManager;
import org.example.Utilisateur;
import org.example.event.Event;

import java.util.List;

public interface Action {

    // Modification ici pour utiliser String au lieu de Scanner
    void action(String input, CalendarManager calendarManager, Utilisateur utilisateur);

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
