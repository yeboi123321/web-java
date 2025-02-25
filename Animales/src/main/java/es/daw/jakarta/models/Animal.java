package es.daw.jakarta.models;

public class Animal {
    private int id;
    private String especie;

    public Animal(int id, String especie) {
        this.id = id;
        this.especie = especie;
    }

    public int getId() {
        return id;
    }

    public String getEspecie() {
        return especie;
    }

}