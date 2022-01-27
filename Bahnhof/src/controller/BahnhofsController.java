//LENNARD
package controller;
//IMPORTS
import model.*;
import java.util.ArrayList;
import view.*;
import java.util.Scanner;

public class BahnhofsController {
    //VARIABLENDEKLARATION
    MainController mc;
    ArrayList<Bahnhof> bahnhoefe;
    GleisController gc;
    //Output-Instanz --> Zugriff auf printData-Methodik über Punktnotation
    Output o = new Output();
    //Notwendig für Interaktion mit dem Terminal (siehe create-Methode)
    Scanner scanner; 

    //CONSTRUCTOR
    //Übergabe des MainControllers --> Über Punktnotation somit Zugriff auf andere Klassen!
    public BahnhofsController(MainController mc){
        setMc(mc);
        bahnhoefe = new ArrayList<Bahnhof>();
        //Setter für den Scanner, notwendig für Eingabe übers Terminal
        this.setScanner(new Scanner(System.in));
    }

    //DEMODATEN
    public void createDemoDaten(){
        // Demodaten für verschiedene Gleismengen in Bahnhöfen
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
        gleis_1_2_3_4.add(getMc().getGc().getGleise().get(3));

        // Demodaten für Bahnhöfe
        //Initialisierung der Bahnhof-Instanzen durch Strings und entsprechende obig aufgeführte Gleis-ArrayLists
        Bahnhof b1 = new Bahnhof("Hamburg Hauptbahnhof", "Hamburg", gleis_1_2_3);
        Bahnhof b2 = new Bahnhof("Berlin Hauptbahnhof", "Berlin", gleis_1_2_3_4);
        Bahnhof b3 = new Bahnhof("Hannover Hauptbahnhof", "Hannover", gleis_1_2);
        Bahnhof b4 = new Bahnhof("Frankfurt Hauptbahnhof", "Frankfurt", gleis_1_2);
        // Hinzufügen in Bahnhof-ArrayList
        bahnhoefe.add(b1);
        bahnhoefe.add(b2);
        bahnhoefe.add(b3);
        bahnhoefe.add(b4);
    }

    //DATENEINGABE BAHNHOF
    public void printOutBahnhof(){
        //Iteration aller Elemente der Bahnhof-ArrayList bahnhoefe
        for(Bahnhof bahnhof : bahnhoefe){
            //Wenn Bahnhof-Instanz nicht null und die Anzahl der Elemente der Gleis-ArrayList gleich 1 --> Ausgabe von nur einem Gleis per Punktnotation (siehe .get)
            if(bahnhof != null && bahnhof.getGleiskombination().size() == 1){
                o.printData(bahnhof.getName() + " - Standort: " + bahnhof.getStandort() + "; Gleise: " + bahnhof.getGleiskombination().get(0).getName());
            }
            //Wenn Bahnhof-Instanz nicht null und die Anzahl der Elemente der Gleis-ArrayList gleich 2 --> Ausgabe von zwei Gleisen per Punktnotation (siehe .get)
            else if((bahnhof != null) && bahnhof.getGleiskombination().size() == 2){
                o.printData(bahnhof.getName() + " - Standort: " + bahnhof.getStandort() + "; Gleise: " + bahnhof.getGleiskombination().get(0).getName() + ", " + bahnhof.getGleiskombination().get(1).getName());
            }
            //Wenn Bahnhof-Instanz nicht null und die Anzahl der Elemente der Gleis-ArrayList gleich 3 --> Ausgabe von drei Gleisen per Punktnotation (siehe .get)
            else if((bahnhof != null) && bahnhof.getGleiskombination().size() == 3){
                o.printData(bahnhof.getName() + " - Standort: " + bahnhof.getStandort() + "; Gleise: " + bahnhof.getGleiskombination().get(0).getName() + ", " + bahnhof.getGleiskombination().get(0).getName() + ", " + bahnhof.getGleiskombination().get(2).getName());
            }
            //Wenn Bahnhof-Instanz nicht null und die Anzahl der Elemente der Gleis-ArrayList gleich 2 --> Ausgabe von vier Gleisen per Punktnotation (siehe .get)
            else if((bahnhof != null) && bahnhof.getGleiskombination().size() == 4){
                o.printData(bahnhof.getName() + " - Standort: " + bahnhof.getStandort() + "; Gleise: " + bahnhof.getGleiskombination().get(0).getName() + ", " + bahnhof.getGleiskombination().get(0).getName() + ", " + bahnhof.getGleiskombination().get(2).getName() + ", " + bahnhof.getGleiskombination().get(3).getName());
            }
            // Insgesamt also der Ringschluss: maximal 4 Gleise pro Bahnhof in unserem Modell!
        }
    }

    //DATENAUSGABE BAHNHOF (teilweise schon erklärt in anderer Controller-Klasse!)
    public void createBahnhof(){
        o.printData("Bahnhof erstellen");
        o.printData("Name: ");
        String bahnhofname = getScanner().nextLine();
        o.printData("Standort: ");
        String bahnhofstandort = getScanner().nextLine();
        o.printData("Gleise: ");
        int i = 0;
        o.printData("Anzahl an Gleise (transitiv): ");
        //Ausgabe der Elemente der möglichen Gleis-ArrayLists (Anzahl an möglichen Gleisen!) über Iteration in For-Each-Schleife
        for(Gleis gleis : getMc().getGc().getGleise()){
            if(gleis!=null){
                o.printData(i + " - " + gleis.getName());
                i++;
            }
        }
        String gleis_choice = getScanner().nextLine();
        //Wenn über den Scanner aufgerufene Wert für den String gleis_choice gleich 0 --> nur ein Gleis-Element wird über ArrrayList hinzugefügt!
        if(gleis_choice.equals("0")){
            //Erstellung einer Gleis-ArrayList
            ArrayList<Gleis> gleis1 = new ArrayList<Gleis>();
            //Hinzufügen eines (!) Gleises (siehe gleis_choice = 0)
            gleis1.add(getMc().getGc().getGleise().get(0));
            //Instanzerstellung mittels jener durch Terminal-Eingabe ermittelter Parameter 
            Bahnhof newbahnhof1 = new Bahnhof(bahnhofname, bahnhofstandort, gleis1);
            //Hinzufügend der neuen Banhof-Instanz (Fall: Anzahl der Gleise = 1) in die Bahnhof-ArrayList
            bahnhoefe.add(newbahnhof1);
            //String-Ausgabe: Bahnhof wurde erstellt!
            o.printData("Bahnhof wurde erstellt!");
        }
        //Gleiches Verfahren wie bereits aufgeführt, jedoch: n+1 Gleise!
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

    //ÜBERPRÜFUNGS-METHODE: Segmentierung der Bahnhofsgroesse 
    public void checkBahnhofgroesse(){
        //Iteration über einzelne Elemente der Bahnhof-ArrayList in For-Each-Schleife
        for(Bahnhof bahnhof : bahnhoefe){
            //Wenn jeweilige Bahnhof-Instanz und Anzahl an Gleisen gleich 1 --> kleiner Bahnhof (geringes Verkehrsaufkommen)
            if(bahnhof!=null & bahnhof.getGleiskombination().size() ==1){
                o.printData(bahnhof.getName() + " ist ein kleiner Bahnhof (geringes Verkehrsaufkommen)");
            }
            //Wenn jeweilige Bahnhof-Instanz und Anzahl an Gleisen größer 1 oder kleiner 4 (d.h. 2 oder 3) --> mittelgrosser Bahnhof (mittleres Verkehrsaufkommen)
            else if(bahnhof!=null & bahnhof.getGleiskombination().size() > 1 && bahnhof.getGleiskombination().size() <4) {
                o.printData(bahnhof.getName() + " ist ein mittelgrosser Bahnhof (mittleres Verkehrsaufkommen)");
            }
            //Wenn jeweilige Bahnhof-Instanz und Anzahl an Gleisen gleich 4 --> grosser Bahnhof (hohes Verkehrsaufkommen)
            else if(bahnhof!=null & bahnhof.getGleiskombination().size()>=4){
                o.printData(bahnhof.getName() + " ist ein grosser Bahnhof (hohes Verkehrsaufkommen)");
            }

        }
    }

    //Setter und Getter
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
