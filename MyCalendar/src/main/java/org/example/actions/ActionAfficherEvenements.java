package org.example.actions;

import org.example.CalendarManager;
import org.example.Utilisateur;

import java.util.Scanner;

public class ActionAfficherEvenements implements Action {
    @Override
    public void action(Scanner scanner, CalendarManager calendar, Utilisateur utilisateur) {
        calendar.afficherEvenements();
    }
}
