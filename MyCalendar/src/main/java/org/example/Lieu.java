package org.example;

public record Lieu(String nomLieu) {
    public Lieu {
        if(nomLieu.isEmpty() || nomLieu.equals(" "))
            throw new Error("Le nom du lieu ne doit pas être null");
    }
    @Override
    public String toString(){
        return nomLieu;
    }
}
