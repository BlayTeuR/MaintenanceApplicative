package org.example;

public record TitreEvenement(String titre) {

    @Override
    public String toString() {
        return titre;
    }
}
