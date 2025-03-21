package org.example.event;

import org.example.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Reunion extends Event {
    private final List<Participant> participants;
    private final Lieu lieu;

    public Reunion(TitreEvenement titreEvenement, Utilisateur proprietaire, LocalDateTime dateDebut, DureeEvenement dureeEvenement, Lieu lieu, ArrayList<Participant> participants) {
        super(titreEvenement, proprietaire, dateDebut, dureeEvenement);
        this.lieu = lieu;
        this.participants = participants;
    }

    @Override
    public String description() {
        return "Réunion : " + this.getTitle() + " à " + lieu + " avec " + participants;
    }

    @Override
    public boolean conflit(Event autreEvenement) {
        if (autreEvenement instanceof Reunion) {
            LocalDateTime fin1 = this.dateDebut.plusMinutes(this.getDureeEvenement().dureeMinutes());
            LocalDateTime fin2 = autreEvenement.dateDebut.plusMinutes(autreEvenement.getDureeEvenement().dureeMinutes());

            return this.dateDebut.isBefore(fin2) && fin1.isAfter(autreEvenement.dateDebut);
        }
        return false;
    }

    public void ajouterParticipant(Participant participant) {
        participants.add(participant);
    }
}

