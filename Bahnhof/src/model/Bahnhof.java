package model;

// Lennard
public class Bahnhof {

    String name;
    String standort;
    Gleis gleis;

    public Bahnhof(String name, String standort, Gleis gleis){
        setName(name);
        setStandort(standort);
    }

    // Setter und Getter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStandort() {
        return standort;
    }

    public void setStandort(String standort) {
        this.standort = standort;
    }

    public Gleis getGleis() {
        return gleis;
    }

    public void setGleis(Gleis gleis) {
        this.gleis = gleis;
    }

}
