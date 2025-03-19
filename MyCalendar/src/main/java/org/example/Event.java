package org.example;

import java.time.LocalDateTime;

public class Event {
    private final EventType type;
    private final TitreEvenement title;
    public String proprietaire;
    public LocalDateTime dateDebut;
    public int dureeMinutes;
    public String lieu; // utilisé seulement pour REUNION
    public String participants; // séparés par virgules (pour REUNION uniquement)
    public int frequenceJours; // uniquement pour PERIODIQUE

    public Event(EventType type, TitreEvenement title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes,
                 String lieu, String participants, int frequenceJours) {
        this.type = type;
        this.title = title;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
        this.dureeMinutes = dureeMinutes;
        this.lieu = lieu;
        this.participants = participants;
        this.frequenceJours = frequenceJours;
    }

    public String description() {
        String desc = "";
        if (type == EventType.RDV_PERSONNEL) {
            desc = "RDV : " + title + " à " + dateDebut.toString();
        } else if (type == EventType.REUNION) {
            desc = "Réunion : " + title + " à " + lieu + " avec " + participants;
        } else if (type == EventType.PERIODIQUE) {
            desc = "Événement périodique : " + title + " tous les " + frequenceJours + " jours";
        }
        return desc;
    }

    public EventType getType() {
        return type;
    }
}