package org.example;

public record TitreEvenement(String titre) {
    public TitreEvenement {
        if (titre.isEmpty() || titre.equals(" "))
            throw new Error("Le titre de l'événement ne doit pas être null");
    }

    @Override
    public String toString() {
        return titre;
    }
}
