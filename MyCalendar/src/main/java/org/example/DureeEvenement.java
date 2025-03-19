package org.example;

public record DureeEvenement(int dureeMinutes) {
    public DureeEvenement {
        if (dureeMinutes <= 0) throw new Error("La durée doit être supérieur à 0");
    }

    @Override
    public String toString() {
        return dureeMinutes + " minutes";
    }
}
