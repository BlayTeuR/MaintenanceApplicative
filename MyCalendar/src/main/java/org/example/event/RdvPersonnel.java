package org.example.event;

import org.example.DureeEvenement;
import org.example.TitreEvenement;
import org.example.Utilisateur;

import java.time.LocalDateTime;

public class RdvPersonnel extends Event {
    public RdvPersonnel(TitreEvenement titreEvenement, Utilisateur proprietaire, LocalDateTime dateDebut, DureeEvenement dureeEvenement) {
        super(titreEvenement, proprietaire, dateDebut, dureeEvenement);
    }

    @Override
    public String description() {
        return "RDV : " + getTitle() + " à " + dateDebut;
    }

    @Override
    public boolean conflit(Event autreEvenement) {
        if (autreEvenement instanceof RdvPersonnel) {
            LocalDateTime fin1 = this.dateDebut.plusMinutes(this.getDureeEvenement().dureeMinutes());
            LocalDateTime fin2 = autreEvenement.dateDebut.plusMinutes(autreEvenement.getDureeEvenement().dureeMinutes());

            return this.dateDebut.isBefore(fin2) && fin1.isAfter(autreEvenement.dateDebut);
        }
        return false;
    }
}

