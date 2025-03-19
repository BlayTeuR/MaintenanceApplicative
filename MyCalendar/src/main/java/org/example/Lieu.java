package org.example;

public record Lieu(String nomLieu) {

    @Override
    public String toString(){
        return nomLieu;
    }
}
