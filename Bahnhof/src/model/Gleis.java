//LENNARD
package model;

public class Gleis {
    
    //VARIABLENDEKLARATION
    String name;
    boolean besetzung;

    //CONSTRUCTOR
    public Gleis(String name, boolean besetzung){
        setBesetzung(besetzung);
        setName(name);
    }

    //Boolean für Besetzung der Gleise (siehe Variablendeklaration)
    public boolean gleisbesetzung(){
        boolean frei=true;
        if(frei){
            return besetzung=true;
        }
        else{
            return besetzung=false;
        }
    }

    

    public String getName() {
        return name;
    }

    public void setBesetzung(boolean besetzung) {
        this.besetzung = besetzung;
    }

    public void setName(String name) {
        this.name = name;
    }

}
