package org.example;

import org.example.event.Event;
import org.example.event.Periodique;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CalendarManager {
    private List<Event> events;

    public CalendarManager() {
        this.events = new ArrayList<>();
    }

    public void ajouterEvent(Event e){
        events.add(e);
    }

    public List<Event> eventsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        return events.stream()
                .filter(e -> (e instanceof Periodique && ((Periodique) e).aOccurrenceDansPeriode(debut, fin)) ||
                        (!(e instanceof Periodique) && !e.dateDebut.isBefore(debut) && !e.dateDebut.isAfter(fin)))
                .collect(Collectors.toList());
    }


    public boolean conflit(Event e1, Event e2) {
        return e1.conflit(e2);
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