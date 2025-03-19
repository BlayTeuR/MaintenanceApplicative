package myCalendar;

import org.example.CalendarManager;
import org.example.DureeEvenement;
import org.example.TitreEvenement;
import org.example.Utilisateur;
import org.example.event.Event;
import org.example.event.Periodique;
import org.example.event.RdvPersonnel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CalendarManagerTest {
    private CalendarManager calendarManager;
    private LocalDateTime now;

    @BeforeEach
    void setUp() {
        calendarManager = new CalendarManager();
        now = LocalDateTime.now();
    }

    @Test
    void testAjouterEvent() {
        Event event = new RdvPersonnel(new TitreEvenement("RDV Test"), new Utilisateur("Alice"), now, new DureeEvenement(60));
        calendarManager.ajouterEvent(event);
        assertEquals(1, calendarManager.getEvents().size());
    }

    @Test
    void testEventsDansPeriode() {
        Event event1 = new RdvPersonnel(new TitreEvenement("RDV1"), new Utilisateur("Alice"), now, new DureeEvenement(60));
        Event event2 = new Periodique(new TitreEvenement("Événement périodique"), new Utilisateur("Bob"), now.minusDays(5), new DureeEvenement(30), 2);

        calendarManager.ajouterEvent(event1);
        calendarManager.ajouterEvent(event2);

        List<Event> events = calendarManager.eventsDansPeriode(now.minusDays(1), now.plusDays(3));
        assertFalse(events.isEmpty());
        assertTrue(events.contains(event1));
        assertTrue(events.contains(event2));
    }

    @Test
    void testConflit() {
        Event event1 = new RdvPersonnel(new TitreEvenement("RDV Conflit 1"), new Utilisateur("Alice"), now, new DureeEvenement(60));
        Event event2 = new RdvPersonnel(new TitreEvenement("RDV Conflit 2"), new Utilisateur("Bob"), now.plusMinutes(30), new DureeEvenement(60));

        assertTrue(calendarManager.conflit(event1, event2));
    }

    @Test
    void testAucunConflit() {
        Event event1 = new RdvPersonnel(new TitreEvenement("RDV 1"), new Utilisateur("Alice"), now, new DureeEvenement(60));
        Event event2 = new RdvPersonnel(new TitreEvenement("RDV 2"), new Utilisateur("Bob"), now.plusMinutes(90), new DureeEvenement(60));

        assertFalse(calendarManager.conflit(event1, event2));
    }
}