package org.example.event;

import org.example.DureeEvenement;
import org.example.TitreEvenement;
import org.example.Utilisateur;

import java.time.LocalDateTime;

public class Periodique extends Event {
    private final int frequenceJours;

    public Periodique(TitreEvenement titreEvenement, Utilisateur proprietaire, LocalDateTime dateDebut, DureeEvenement dureeEvenement, int frequenceJours) {
        super(titreEvenement, proprietaire, dateDebut, dureeEvenement);
        this.frequenceJours = frequenceJours;
    }

    @Override
    public String description() {
        return "Événement périodique : " + getTitle() + " tous les " + frequenceJours + " jours";
    }

    @Override
    public boolean conflit(Event autreEvenement) {
        if (autreEvenement instanceof Periodique) {
            LocalDateTime temp = this.dateDebut;
            while (temp.isBefore(autreEvenement.dateDebut.plusMinutes(autreEvenement.getDureeEvenement().dureeMinutes()))) {
                if (temp.isEqual(autreEvenement.dateDebut)) {
                    return true;
                }
                temp = temp.plusDays(this.frequenceJours);
            }
        }
        return false;
    }

    public int getFrequenceJours() {
        return frequenceJours;
    }
}

