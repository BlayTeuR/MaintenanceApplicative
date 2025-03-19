package org.example.event;

import org.example.DureeEvenement;
import org.example.TitreEvenement;

import java.time.LocalDateTime;

public class RdvPersonnel extends Event {
    public RdvPersonnel(TitreEvenement titreEvenement, String proprietaire, LocalDateTime dateDebut, DureeEvenement dureeEvenement) {
        super(titreEvenement, proprietaire, dateDebut, dureeEvenement);
    }

    @Override
    public String description() {
        return "RDV : " + getTitle() + " à " + dateDebut;
    }
}

