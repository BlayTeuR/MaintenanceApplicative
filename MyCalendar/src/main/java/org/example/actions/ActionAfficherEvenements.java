package org.example.actions;

import org.example.CalendarManager;
import org.example.Utilisateur;

public class ActionAfficherEvenements implements Action {
    @Override
    public void action(String input, CalendarManager calendar, Utilisateur utilisateur) {
        // Cette méthode ne nécessite pas d'input, elle affiche tous les événements
        calendar.afficherEvenements();
    }
}
