package org.example.actions;

import org.example.*;
import org.example.event.Event;
import org.example.event.Reunion;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class AjoutReunion implements Action {
    @Override
    public void action(String input, CalendarManager calendarManager, Utilisateur utilisateur) {
        // Traitement de l'entrée sous forme de chaîne (input)
        String[] inputs = input.split(";");

        String titre = inputs[0]; // Titre de l'événement
        TitreEvenement titreEvenement = new TitreEvenement(titre);

        int annee = Integer.parseInt(inputs[1]);
        int moisRdv = Integer.parseInt(inputs[2]);
        int jourRdv = Integer.parseInt(inputs[3]);
        int heure = Integer.parseInt(inputs[4]);
        int minute = Integer.parseInt(inputs[5]);
        int duree = Integer.parseInt(inputs[6]);

        DureeEvenement dureeEvenement = new DureeEvenement(duree);
        String nomLieu = inputs[7]; // Lieu de la réunion
        Lieu lieu = new Lieu(nomLieu);

        ArrayList<Participant> participants = new ArrayList<>();

        Reunion eReunion = new Reunion(titreEvenement, utilisateur, LocalDateTime.of(annee, moisRdv, jourRdv, heure, minute), dureeEvenement, lieu, participants);
        eReunion.ajouterParticipant(eReunion.getProprietaire());

        // Traitement des participants
        for (int i = 8; i < inputs.length; i++) {
            String participantNom = inputs[i];
            Participant participant = new Participant(participantNom);
            eReunion.ajouterParticipant(participant);
        }

        boolean conflitTrouve = false;
        for (Event e : calendarManager.getEvents()) {
            if (calendarManager.conflit(eReunion, e)) {
                conflitTrouve = true;
                break;
            }
        }

        if (conflitTrouve) {
            System.out.println("Erreur : Il y a un conflit avec un autre événement.");
        } else {
            calendarManager.ajouterEvent(eReunion);
            System.out.println("Événement ajouté.");
        }
    }
}
