package org.example;

import java.time.LocalDateTime;

public abstract class Event {
    private final EventType type;
    private final TitreEvenement title;
    public String proprietaire;
    public LocalDateTime dateDebut;
    private final DureeEvenement dureeEvenement;
    private final Lieu lieu; // utilisé seulement pour REUNION
    public String participants; // séparés par virgules (pour REUNION uniquement)
    public int frequenceJours; // uniquement pour PERIODIQUE

    public Event(EventType type, TitreEvenement title, String proprietaire, LocalDateTime dateDebut, DureeEvenement dureeEvenement,
                 Lieu lieu, String participants, int frequenceJours) {
        this.type = type;
        this.title = title;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
        this.dureeEvenement = dureeEvenement;
        this.lieu = lieu;
        this.participants = participants;
        this.frequenceJours = frequenceJours;
    }

    public abstract void description();

    public EventType getType() {
        return type;
    }

    public DureeEvenement getDureeEvenement() {
        return dureeEvenement;
    }
}