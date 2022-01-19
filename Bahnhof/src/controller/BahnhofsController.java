package controller;

import model.*;
import java.util.ArrayList;

// Lennard
public class BahnhofsController {
    
    MainController mc;
    ArrayList<Bahnhof> bahnhoefe;
    GleisController gc;

    public BahnhofsController(MainController mc){
        setMc(mc);
        bahnhoefe = new ArrayList<Bahnhof>();
    }

    public void createDemoDaten(){
        // Demodaten für verschiedene Gleismengen in Bahnhöfen
        ArrayList<Gleis> gleis_1 = new ArrayList<Gleis>();
        gleis_1.add(getMc().getGc().getGleise().get(0));
            
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
        gleis_1_2_3_4.add(getMc().getGc().getGleise().get(3));

        Bahnhof b1 = new Bahnhof("Hamburg Hauptbahnhof", "Hamburg", gleis_1_2_3);
        Bahnhof b2 = new Bahnhof("Berlin Hauptbahnhof", "Berlin", gleis_1_2_3_4);
        Bahnhof b3 = new Bahnhof("Hannover Hauptbahnhof", "Hannover", gleis_1_2);
        Bahnhof b4 = new Bahnhof("Frankfurt Hauptbahnhof", "Frankfurt", gleis_1_2);

        bahnhoefe.add(b1);
        bahnhoefe.add(b2);
        bahnhoefe.add(b3);
        bahnhoefe.add(b4);
    }

    // Setter und Getter
    public ArrayList<Bahnhof> getBahnhoefe() {
        return bahnhoefe;
    }

    public void setBahnhoefe(ArrayList<Bahnhof> bahnhoefe) {
        this.bahnhoefe = bahnhoefe;
    }
    public GleisController getGc() {
        return gc;
    }
    public void setGc(GleisController gc) {
        this.gc = gc;
    }

    public MainController getMc() {
        return mc;
    }

    public void setMc(MainController mc) {
        this.mc = mc;
    }

}
