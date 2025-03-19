package org.example.event;

import org.example.DureeEvenement;
import org.example.Proprietaire;
import org.example.TitreEvenement;

import java.time.LocalDateTime;

public abstract class Event {
    private final TitreEvenement title;
    private final Proprietaire proprietaire;
    public LocalDateTime dateDebut;
    private final DureeEvenement dureeEvenement;

    public Event(TitreEvenement titreEvenement, String proprietaire, LocalDateTime dateDebut, DureeEvenement dureeEvenement) {
        this.title = titreEvenement;
        this.proprietaire = new Proprietaire(proprietaire);
        this.dateDebut = dateDebut;
        this.dureeEvenement = dureeEvenement;
    }

    public abstract String description();

    public DureeEvenement getDureeEvenement() {
        return dureeEvenement;
    }

    public TitreEvenement getTitle() {
        return title;
    }

    public Proprietaire getProprietaire() {
        return proprietaire;
    }
}
