package org.example.event;

import org.example.DureeEvenement;
import org.example.Utilisateur;
import org.example.TitreEvenement;
import org.example.Utilisateur;

import java.time.LocalDateTime;

public abstract class Event {
    private final TitreEvenement title;
    private final Utilisateur proprietaire;
    public LocalDateTime dateDebut;
    private final DureeEvenement dureeEvenement;

    public Event(TitreEvenement titreEvenement, Utilisateur proprietaire, LocalDateTime dateDebut, DureeEvenement dureeEvenement) {
        this.title = titreEvenement;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
        this.dureeEvenement = dureeEvenement;
    }

    public abstract String description();

    public abstract boolean conflit(Event event);

    public DureeEvenement getDureeEvenement() {
        return dureeEvenement;
    }

    public TitreEvenement getTitle() {
        return title;
    }

    public Utilisateur getProprietaire() {
        return proprietaire;
    }
}
