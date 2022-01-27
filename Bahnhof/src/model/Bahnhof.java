//LENNARD
package model;
//IMPORTS
import java.util.ArrayList;

public class Bahnhof {

    //VARIABLENDEKLARATION
    String name;
    String standort;
    //Da es mehrere Gleiskombination gibt: ArrayList für Gleis-Instanzen eines Bahnhofs!
    ArrayList<Gleis> gleiskombination = new ArrayList<Gleis>();
    
    //CONSTRUCTOR
    public Bahnhof(String name, String standort, ArrayList<Gleis> gleiskombination){
        setName(name);
        setStandort(standort);
        setGleiskombination(gleiskombination);
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
