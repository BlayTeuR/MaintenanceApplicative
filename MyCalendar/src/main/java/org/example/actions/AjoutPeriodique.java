package org.example.actions;

import org.example.CalendarManager;
import org.example.DureeEvenement;
import org.example.TitreEvenement;
import org.example.Utilisateur;
import org.example.event.Event;
import org.example.event.Periodique;

import java.time.LocalDateTime;

public class AjoutPeriodique implements Action {

    @Override
    public void action(String input, CalendarManager calendarManager, Utilisateur utilisateur) {
        // Exemple de modification : on suppose que l'input est un string séparé par des espaces ou d'autres séparateurs
        String[] inputs = input.split(";");

        // Traitement des données d'entrée
        String titre3 = inputs[0]; // Titre de l'événement
        TitreEvenement titreEvenement2 = new TitreEvenement(titre3);

        int annee3 = Integer.parseInt(inputs[1]);
        int moisRdv3 = Integer.parseInt(inputs[2]);
        int jourRdv3 = Integer.parseInt(inputs[3]);
        int heure3 = Integer.parseInt(inputs[4]);
        int minute3 = Integer.parseInt(inputs[5]);

        int frequence = Integer.parseInt(inputs[6]);

        if (frequence <= 0) {
            System.out.println("La fréquence doit être supérieure à 0.");
            return;
        }

        int dureeMinutes = frequence * 1440;

        DureeEvenement dureeEvenement = new DureeEvenement(dureeMinutes);
        Periodique ePeriodique = new Periodique(titreEvenement2, utilisateur, LocalDateTime.of(annee3, moisRdv3, jourRdv3, heure3, minute3), dureeEvenement, frequence);

        boolean conflitTrouve = false;
        for (Event e : calendarManager.getEvents()) {
            if (calendarManager.conflit(ePeriodique, e)) {
                conflitTrouve = true;
                break;
            }
        }

        if (conflitTrouve) {
            System.out.println("Erreur : Il y a un conflit avec un autre événement.");
        } else {
            calendarManager.ajouterEvent(ePeriodique);
            System.out.println("Événement ajouté.");
        }
    }
}
