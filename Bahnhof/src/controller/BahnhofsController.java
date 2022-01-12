package controller;

import model.*;
import java.util.ArrayList;

// Lennard
public class BahnhofsController {
    
    MainController mc;
    ArrayList<Bahnhof> bahnhoefe;

    public BahnhofsController(){
        setMc(mc);
        bahnhoefe = new ArrayList<Bahnhof>();
    }

    public void createDemoDaten(){

        Bahnhof b1 = new Bahnhof("Hamburg Hauptbahnhof", "Hamburg", getMc().getGc().getGleise().get);
        Bahnhof b2 = new Bahnhof("Berlin Hauptbahnhof", "Berlin", );
        Bahnhof b3 = new Bahnhof("Hannover Hauptbahnhof", "Hannover", );
        Bahnhof b4 = new Bahnhof("Frankfurt Hauptbahnhof", "Frankfurt", );
        

    }

    // Setter und Getter
    public ArrayList<Bahnhof> getBahnhoefe() {
        return bahnhoefe;
    }

    public void setBahnhoefe(ArrayList<Bahnhof> bahnhoefe) {
        this.bahnhoefe = bahnhoefe;
    }

    public MainController getMc() {
        return mc;
    }

    public void setMc(MainController mc) {
        this.mc = mc;
    }

}
