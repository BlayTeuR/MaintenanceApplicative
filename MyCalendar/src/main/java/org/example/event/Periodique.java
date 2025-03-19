package org.example.event;

import org.example.DureeEvenement;
import org.example.TitreEvenement;

import java.time.LocalDateTime;

public class Periodique extends Event {
    private final int frequenceJours;

    public Periodique(TitreEvenement titreEvenement, String proprietaire, LocalDateTime dateDebut, DureeEvenement dureeEvenement, int frequenceJours) {
        super(titreEvenement, proprietaire, dateDebut, dureeEvenement);
        this.frequenceJours = frequenceJours;
    }

    @Override
    public String description() {
        return "Événement périodique : " + getTitle() + " tous les " + frequenceJours + " jours";
    }

    public int getFrequenceJours() {
        return frequenceJours;
    }
}

