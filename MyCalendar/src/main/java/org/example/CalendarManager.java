package org.example;

import org.example.event.Event;
import org.example.event.Periodique;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CalendarManager {
    private List<Event> events;

    public CalendarManager() {
        this.events = new ArrayList<>();
    }

    public void ajouterEvent(Event e){
        events.add(e);
    }

    public List<Event> eventsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        List<Event> result = new ArrayList<>();
        for (Event e : events) {
            if (e.getClass() == Periodique.class) {
                LocalDateTime temp = e.dateDebut;
                while (temp.isBefore(fin)) {
                    if (!temp.isBefore(debut)) {
                        result.add(e);
                        break;
                    }
                    temp = temp.plusDays(((Periodique) e).getFrequenceJours());
                }
            } else if (!e.dateDebut.isBefore(debut) && !e.dateDebut.isAfter(fin)) {
                result.add(e);
            }
        }
        return result;
    }

    public boolean conflit(Event e1, Event e2) {
        LocalDateTime fin1 = e1.dateDebut.plusMinutes(e1.getDureeEvenement().dureeMinutes());
        LocalDateTime fin2 = e2.dateDebut.plusMinutes(e2.getDureeEvenement().dureeMinutes());

        if (e1.getClass() == Periodique.class || e2.getClass() == Periodique.class) {
            return false; // Simplification abusive
        }

        if (e1.dateDebut.isBefore(fin2) && fin1.isAfter(e2.dateDebut)) {
            return true;
        }
        return false;
    }

    public void afficherEvenements() {
        for (Event e : events) {
            System.out.println(e.description());
        }
    }

    public List<Event> getEvents() {
        return events;
    }
}