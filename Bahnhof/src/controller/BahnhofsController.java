package controller;

import model.*;
import java.util.ArrayList;
import view.*;
import java.util.Scanner;

// Lennard
public class BahnhofsController {
    
    MainController mc;
    ArrayList<Bahnhof> bahnhoefe;
    GleisController gc;
    Output o = new Output();
    Scanner scanner; 

    public BahnhofsController(MainController mc){
        setMc(mc);
        bahnhoefe = new ArrayList<Bahnhof>();
        this.setScanner(new Scanner(System.in));
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

    //Jordan
    //Bahnhöfe Ausgabe:
    public void printOutBahnhof(){
        for(Bahnhof bahnhof : bahnhoefe){
            if(bahnhof != null && bahnhof.getGleiskombination().size() == 1){
                o.printData(bahnhof.getName() + " - Standort: " + bahnhof.getStandort() + "; Gleise: " + bahnhof.getGleiskombination().get(0).getName());
            }
            else if((bahnhof != null) && bahnhof.getGleiskombination().size() == 2){
                o.printData(bahnhof.getName() + " - Standort: " + bahnhof.getStandort() + "; Gleise: " + bahnhof.getGleiskombination().get(0).getName() + ", " + bahnhof.getGleiskombination().get(1).getName());
            }
            else if((bahnhof != null) && bahnhof.getGleiskombination().size() == 3){
                o.printData(bahnhof.getName() + " - Standort: " + bahnhof.getStandort() + "; Gleise: " + bahnhof.getGleiskombination().get(0).getName() + ", " + bahnhof.getGleiskombination().get(0).getName() + ", " + bahnhof.getGleiskombination().get(2).getName());
            }
            else if((bahnhof != null) && bahnhof.getGleiskombination().size() == 4){
                o.printData(bahnhof.getName() + " - Standort: " + bahnhof.getStandort() + "; Gleise: " + bahnhof.getGleiskombination().get(0).getName() + ", " + bahnhof.getGleiskombination().get(0).getName() + ", " + bahnhof.getGleiskombination().get(2).getName() + ", " + bahnhof.getGleiskombination().get(3).getName());
            }
        }
    }

    //createBahnhoefe:
    public void createBahnhof(){
        o.printData("Bahnhof erstellen");
        o.printData("Name: ");
        String bahnhofname = getScanner().nextLine();
        o.printData("Standort: ");
        String bahnhofstandort = getScanner().nextLine();
        o.printData("Gleise: ");
        int i = 0;
        o.printData("Anzahl an Gleise (transitiv): ");
        for(Gleis gleis : getMc().getGc().getGleise()){
            if(gleis!=null){
                o.printData(i + " - " + gleis.getName());
                i++;
            }
        }
        String gleis_choice = getScanner().nextLine();
        if(gleis_choice.equals("0")){
            ArrayList<Gleis> gleis1 = new ArrayList<Gleis>();
            gleis1.add(getMc().getGc().getGleise().get(0));
            Bahnhof newbahnhof1 = new Bahnhof(bahnhofname, bahnhofstandort, gleis1);
            bahnhoefe.add(newbahnhof1);
            o.printData("Bahnhof wurde erstellt!");
        }
        else if(gleis_choice.equals("1")){
            ArrayList<Gleis> gleis12 = new ArrayList<Gleis>();
            gleis12.add(getMc().getGc().getGleise().get(0));
            gleis12.add(getMc().getGc().getGleise().get(1));
            Bahnhof newbahnhof2 = new Bahnhof(bahnhofname, bahnhofstandort, gleis12);
            bahnhoefe.add(newbahnhof2);
            o.printData("Bahnhof wurde erstellt!");
        }
        else if(gleis_choice.equals("2")){
            ArrayList<Gleis> gleis123 = new ArrayList<Gleis>();
            gleis123.add(getMc().getGc().getGleise().get(0));
            gleis123.add(getMc().getGc().getGleise().get(1));
            gleis123.add(getMc().getGc().getGleise().get(2));
            Bahnhof newbahnhof3 = new Bahnhof(bahnhofname, bahnhofstandort, gleis123);
            bahnhoefe.add(newbahnhof3);
            o.printData("Bahnhof wurde erstellt!");
        }
        else if(gleis_choice.equals("3")){
            ArrayList<Gleis> gleis1234 = new ArrayList<Gleis>();
            gleis1234.add(getMc().getGc().getGleise().get(0));
            gleis1234.add(getMc().getGc().getGleise().get(1));
            gleis1234.add(getMc().getGc().getGleise().get(2));
            gleis1234.add(getMc().getGc().getGleise().get(3));
            Bahnhof newbahnhof4 = new Bahnhof(bahnhofname, bahnhofstandort, gleis1234);
            bahnhoefe.add(newbahnhof4);
            o.printData("Bahnhof wurde erstellt!");
        }
        
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
    public void setO(Output o) {
        this.o = o;
    }
    public Output getO() {
        return o;
    }
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
    public Scanner getScanner() {
        return scanner;
    }


}
