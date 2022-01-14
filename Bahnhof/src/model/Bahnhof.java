package model;
import java.util.ArrayList;

// Lennard
public class Bahnhof {

    String name;
    String standort;
    ArrayList<Gleis> gleiskombination = new ArrayList<Gleis>();
    

    public Bahnhof(String name, String standort, ArrayList<Gleis> gleiskombination){
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

    public void setGleiskombination(ArrayList<Gleis> gleiskombination) {
        this.gleiskombination = gleiskombination;
    }
    public ArrayList<Gleis> getGleiskombination() {
        return gleiskombination;
    }
    

}
