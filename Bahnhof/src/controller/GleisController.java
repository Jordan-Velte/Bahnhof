//LENNARD
package controller;
//IMPORTS
import model.*;
import java.util.ArrayList;

public class GleisController {
    //VARIABLENDEKLARATION
    MainController mc;
    ArrayList<Gleis> gleise;
    
    //CONSTRUCTOR
    //Übergabe des MainControllers --> Über Punktnotation somit Zugriff auf andere Klassen!
    public GleisController(MainController mc){
        setMc(mc);
        gleise = new ArrayList<Gleis>();
    }

    //DEMODATEN
    public void createDemoDaten(){
        //Initialisierung von Gleis-Instanzen
        Gleis g1 = new Gleis("Gleis 1", true);
        Gleis g2 = new Gleis("Gleis 2", true);
        Gleis g3 = new Gleis("Gleis 3", true);
        Gleis g4 = new Gleis("Gleis 4", true);
        //Hinzufügen der Gleis-Instanzen in eine ArrayList
        gleise.add(g1);
        gleise.add(g2);
        gleise.add(g3);
        gleise.add(g4);

    }


    // Setter und Getter
    public ArrayList<Gleis> getGleise() {
        return gleise;
    }
    public void setGleise(ArrayList<Gleis> gleise) {
        this.gleise = gleise;
    }
    public MainController getMc() {
        return mc;
    }
    public void setMc(MainController mc) {
        this.mc = mc;
    }
}

//CODE GRAVEYARD
/*
        //Verschiedene Anzahl an Gleisen! --> In unserem Modell kann ein Bahnhof maximal vier Gleise besitzen
        //Erstellung einer entsprechenden zusätzlichen Gleis-ArrayList
        ArrayList<Gleis> gleis_1 = new ArrayList<Gleis>();
        //Hinzufügen eines Gleises aus vorheriger ArrayList per Punktnotation über den MainController (add-Methode)
        gleis_1.add(getMc().getGc().getGleise().get(0));
        
        //Jeweils ein Gleis mehr, usw. --> siehe Name der ArrayList!
        ArrayList<Gleis> gleis_1_2 = new ArrayList<Gleis>();
        gleis_1_2.add(getMc().getGc().getGleise().get(0));
        gleis_1_2.add(getMc().getGc().getGleise().get(1));

        ArrayList<Gleis> gleis_1_2_3 = new ArrayList<Gleis>();
        gleis_1_2_3.add(getMc().getGc().getGleise().get(0));
        gleis_1_2_3.add(getMc().getGc().getGleise().get(1));
        gleis_1_2_3.add(getMc().getGc().getGleise().get(2));
        
        ArrayList<Gleis> gleis_1_2_3_4 = new ArrayList<Gleis>();
        gleis_1_2_3_4.add(getMc().getGc().getGleise().get(0));
        gleis_1_2_3_4.add(getMc().getGc().getGleise().get(1));
        gleis_1_2_3_4.add(getMc().getGc().getGleise().get(2));
        gleis_1_2_3_4.add(getMc().getGc().getGleise().get(3));*/
