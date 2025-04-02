package org.example.actions;

import org.example.CalendarManager;
import org.example.DureeEvenement;
import org.example.TitreEvenement;
import org.example.Utilisateur;
import org.example.event.Event;
import org.example.event.RdvPersonnel;

import java.time.LocalDateTime;

public class AjoutRdvPeso implements Action {
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
        Event eRdv = new RdvPersonnel(titreEvenement, utilisateur,
                LocalDateTime.of(annee, moisRdv, jourRdv, heure, minute), dureeEvenement);

        boolean conflitTrouve = false;
        for (Event e : calendarManager.getEvents()) {
            if (calendarManager.conflit(eRdv, e)) {
                conflitTrouve = true;
                break;
            }
        }

        if (conflitTrouve) {
            System.out.println("Erreur : Il y a un conflit avec un autre événement.");
        } else {
            calendarManager.ajouterEvent(eRdv);
            System.out.println("Événement ajouté.");
        }
    }
}
