package model;

// Lennard
public class Gleis {
    
    String name;
    boolean besetzung;

    public Gleis(String name, boolean besetzung){
        setBesetzung(besetzung);
        setName(name);
    }


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
