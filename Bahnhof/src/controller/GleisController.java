package controller;

import model.*;
import java.util.ArrayList;

// Lennard
public class GleisController {
    
    MainController mc;
    ArrayList<Gleis> gleise;
    

    public GleisController(MainController mc){
        setMc(mc);
        gleise = new ArrayList<Gleis>();
    }

    public void createDemoDaten(){
        // Demodaten für die verschiedenen Gleise
        Gleis g1 = new Gleis("Gleis 1", true);
        Gleis g2 = new Gleis("Gleis 2", true);
        Gleis g3 = new Gleis("Gleis 3", true);
        Gleis g4 = new Gleis("Gleis 4", true);
        gleise.add(g1);
        gleise.add(g2);
        gleise.add(g3);
        gleise.add(g4);

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

    }

    public void createDemoDatenGleise(){

        for(Gleis gleis : gleise){
            o.printData();
        }

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
