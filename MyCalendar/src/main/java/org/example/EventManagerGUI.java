package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import org.example.actions.*;
import org.example.actions.Action;

public class EventManagerGUI {
    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private CalendarManager calendar;
    private UserManager userManager;
    private Utilisateur utilisateur;

    public EventManagerGUI() {
        calendar = new CalendarManager();
        userManager = new UserManager();
        frame = new JFrame("Gestionnaire d'Événements");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(loginPanel(), "Login");
        mainPanel.add(mainMenuPanel(), "MainMenu");

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private JPanel loginPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));  // 4 lignes pour le formulaire

        JLabel userLabel = new JLabel("Nom d'utilisateur:");
        JTextField userField = new JTextField();

        JLabel passwordLabel = new JLabel("Mot de passe:");
        JPasswordField passwordField = new JPasswordField();

        JLabel passwordConfirmLabel = new JLabel("Confirmer le mot de passe:");  // Champ de confirmation
        JPasswordField passwordConfirmField = new JPasswordField();

        JButton loginButton = new JButton("Se connecter");
        JButton signupButton = new JButton("Créer un compte");

        panel.add(userLabel);
        panel.add(userField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(passwordConfirmLabel);  // Ajout du champ de confirmation
        panel.add(passwordConfirmField);  // Ajout du champ de confirmation
        panel.add(loginButton);
        panel.add(signupButton);

        // Action pour se connecter
        loginButton.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passwordField.getPassword());

            // Vérification des champs vides
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Veuillez entrer un nom d'utilisateur et un mot de passe.");
                return;
            }

            utilisateur = userManager.seConnecter(username, password);

            if (utilisateur != null) {
                JOptionPane.showMessageDialog(frame, "Connexion réussie");
                cardLayout.show(mainPanel, "MainMenu");
            } else {
                JOptionPane.showMessageDialog(frame, "Identifiants incorrects");
            }
        });

        // Action pour créer un compte
        signupButton.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passwordField.getPassword());
            String passwordConfirm = new String(passwordConfirmField.getPassword());

            // Vérification des champs vides
            if (username.isEmpty() || password.isEmpty() || passwordConfirm.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Veuillez remplir tous les champs.");
                return;
            }

            if (!password.equals(passwordConfirm)) {
                JOptionPane.showMessageDialog(frame, "Les mots de passe ne correspondent pas.");
                return;
            }

            boolean success = userManager.inscrire(username, password); // Essayer de créer un compte

            if (success) {
                JOptionPane.showMessageDialog(frame, "Compte créé avec succès");
            } else {
                JOptionPane.showMessageDialog(frame, "Ce nom d'utilisateur est déjà pris");
            }
        });

        return panel;
    }

    private JPanel mainMenuPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));

        JButton viewEventsButton = new JButton("Voir les événements");
        JButton addPersonalMeetingButton = new JButton("Ajouter un rendez-vous perso");
        JButton addMeetingButton = new JButton("Ajouter une réunion");
        JButton addPeriodicEventButton = new JButton("Ajouter un événement périodique");
        JButton logoutButton = new JButton("Se déconnecter");

        panel.add(viewEventsButton);
        panel.add(addPersonalMeetingButton);
        panel.add(addMeetingButton);
        panel.add(addPeriodicEventButton);
        panel.add(logoutButton);

        Map<String, Action> actions = new HashMap<>();
        actions.put("2", new AjoutRdvPeso());
        actions.put("3", new AjoutReunion());
        actions.put("4", new AjoutPeriodique());

        viewEventsButton.addActionListener(e -> showEventsMenu());

        // Action pour ajouter un rendez-vous personnel
        addPersonalMeetingButton.addActionListener(e -> showPersonalMeetingDialog(actions.get("2")));

        // Action pour ajouter une réunion
        addMeetingButton.addActionListener(e -> showMeetingDialog(actions.get("3")));

        // Action pour ajouter un événement périodique
        addPeriodicEventButton.addActionListener(e -> showPeriodicEventDialog(actions.get("4")));

        logoutButton.addActionListener(e -> {
            utilisateur = null;
            cardLayout.show(mainPanel, "Login");
        });

        return panel;
    }


    private void showPersonalMeetingDialog(Action action) {
        JPanel panel = new JPanel(new GridLayout(7, 2));

        // Champs de saisie pour un rendez-vous personnel
        panel.add(new JLabel("Titre de l'événement :"));
        JTextField titleField = new JTextField();
        panel.add(titleField);

        panel.add(new JLabel("Année :"));
        JTextField yearField = new JTextField();
        panel.add(yearField);

        panel.add(new JLabel("Mois :"));
        JTextField monthField = new JTextField();
        panel.add(monthField);

        panel.add(new JLabel("Jour :"));
        JTextField dayField = new JTextField();
        panel.add(dayField);

        panel.add(new JLabel("Heure :"));
        JTextField hourField = new JTextField();
        panel.add(hourField);

        panel.add(new JLabel("Minute :"));
        JTextField minuteField = new JTextField();
        panel.add(minuteField);

        panel.add(new JLabel("Durée (en minutes) :"));
        JTextField durationField = new JTextField();
        panel.add(durationField);

        int option = JOptionPane.showConfirmDialog(frame, panel, "Ajouter un rendez-vous personnel", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            // Récupérer les informations saisies et appeler l'action AjoutRdvPeso
            String input = String.join(";", titleField.getText(),
                    yearField.getText(), monthField.getText(), dayField.getText(),
                    hourField.getText(), minuteField.getText(), durationField.getText());
            executeAction(action, input);
        }
    }

    private void showPeriodicEventDialog(Action action) {
        JPanel panel = new JPanel(new GridLayout(8, 2));

        // Champs de saisie pour un événement périodique
        panel.add(new JLabel("Titre de l'événement :"));
        JTextField titleField = new JTextField();
        panel.add(titleField);

        panel.add(new JLabel("Type de répétition (ex: quotidien, hebdomadaire) :"));
        JTextField repeatTypeField = new JTextField();
        panel.add(repeatTypeField);

        panel.add(new JLabel("Année :"));
        JTextField yearField = new JTextField();
        panel.add(yearField);

        panel.add(new JLabel("Mois :"));
        JTextField monthField = new JTextField();
        panel.add(monthField);

        panel.add(new JLabel("Jour :"));
        JTextField dayField = new JTextField();
        panel.add(dayField);

        panel.add(new JLabel("Heure :"));
        JTextField hourField = new JTextField();
        panel.add(hourField);

        panel.add(new JLabel("Minute :"));
        JTextField minuteField = new JTextField();
        panel.add(minuteField);

        int option = JOptionPane.showConfirmDialog(frame, panel, "Ajouter un événement périodique", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            // Récupérer les informations saisies et appeler l'action AjoutPeriodique
            String input = String.join(";", titleField.getText(), repeatTypeField.getText(),
                    yearField.getText(), monthField.getText(), dayField.getText(),
                    hourField.getText(), minuteField.getText());
            executeAction(action, input);
        }
    }

    private void showMeetingDialog(Action action) {
        JPanel panel = new JPanel(new GridLayout(7, 2));

        // Champs de saisie pour une réunion
        panel.add(new JLabel("Titre de la réunion :"));
        JTextField titleField = new JTextField();
        panel.add(titleField);

        panel.add(new JLabel("Lieu :"));
        JTextField locationField = new JTextField();
        panel.add(locationField);

        panel.add(new JLabel("Année :"));
        JTextField yearField = new JTextField();
        panel.add(yearField);

        panel.add(new JLabel("Mois :"));
        JTextField monthField = new JTextField();
        panel.add(monthField);

        panel.add(new JLabel("Jour :"));
        JTextField dayField = new JTextField();
        panel.add(dayField);

        panel.add(new JLabel("Heure :"));
        JTextField hourField = new JTextField();
        panel.add(hourField);

        panel.add(new JLabel("Minute :"));
        JTextField minuteField = new JTextField();
        panel.add(minuteField);

        int option = JOptionPane.showConfirmDialog(frame, panel, "Ajouter une réunion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            // Récupérer les informations saisies et appeler l'action AjoutReunion
            String input = String.join(";", titleField.getText(),
                    locationField.getText(), yearField.getText(), monthField.getText(),
                    dayField.getText(), hourField.getText(), minuteField.getText());
            executeAction(action, input);
        }
    }


    private void showEventsMenu() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JButton allEventsButton = new JButton("Afficher TOUS les événements");
        JButton monthEventsButton = new JButton("Afficher les événements du mois");
        JButton weekEventsButton = new JButton("Afficher les événements de la semaine");
        JButton dayEventsButton = new JButton("Afficher les événements du jour");
        JButton backButton = new JButton("Retour");

        panel.add(allEventsButton);
        panel.add(monthEventsButton);
        panel.add(weekEventsButton);
        panel.add(dayEventsButton);
        panel.add(backButton);

        Map<String, Action> eventActions = new HashMap<>();
        eventActions.put("1", new ActionAfficherEvenements());
        eventActions.put("2", new AfficherEvenementMois());
        eventActions.put("3", new AfficherEvenementSemaine());
        eventActions.put("4", new AfficherEvenementJours());

        allEventsButton.addActionListener(e -> promptForInputAndExecuteAction(eventActions.get("1")));
        monthEventsButton.addActionListener(e -> promptForInputAndExecuteAction(eventActions.get("2")));
        weekEventsButton.addActionListener(e -> promptForInputAndExecuteAction(eventActions.get("3")));
        dayEventsButton.addActionListener(e -> promptForInputAndExecuteAction(eventActions.get("4")));

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu"));

        mainPanel.add(panel, "EventMenu");
        cardLayout.show(mainPanel, "EventMenu");
    }

    private void promptForInputAndExecuteAction(Action action) {
        String input = JOptionPane.showInputDialog(frame, "Entrez des informations :");

        if (input != null && !input.trim().isEmpty()) {
            executeAction(action, input);
        } else {
            JOptionPane.showMessageDialog(frame, "Entrée invalide.");
        }
    }

    private void executeAction(Action action, String input) {
        if (action != null && utilisateur != null) {
            action.action(input, calendar, utilisateur);
            JOptionPane.showMessageDialog(frame, "Action effectuée");
        } else {
            JOptionPane.showMessageDialog(frame, "Erreur: Aucun utilisateur connecté");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EventManagerGUI::new);
    }
}
