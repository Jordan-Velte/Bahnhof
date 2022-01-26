package controller;

import model.*;
import view.Output;

import java.util.ArrayList;
import java.util.Locale;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Scanner;
import java.util.Date;
//Lennard

public class PersonenController {
    
    MainController mc;
    ArrayList<Person> personen;
    ArrayList<Lokfuehrer> lokfuehrer;
    ArrayList<Passagier> passagiere;
    ArrayList<Personal> personal;
    Scanner scanner;
    Output o = new Output();

    DateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN);

    public PersonenController(MainController mc){
        setMc(mc);
        personen = new ArrayList<Person>();
        lokfuehrer = new ArrayList<Lokfuehrer>();
        passagiere = new ArrayList<Passagier>();
        personal = new ArrayList<Personal>();
        this.setScanner(new Scanner(System.in));
    }


    public void createDemoDaten() throws ParseException{

        Passagier pa1 = new Passagier("Bernd", "Barbar", 01);
        Passagier pa2 = new Passagier("Peter", "Klaus", 02); 
        Passagier pa3 = new Passagier("Klaus", "Kleber", 03);
        passagiere.add(pa1);
        passagiere.add(pa2);
        passagiere.add(pa3);
        Personal pe1 = new Personal("Karl", "Kernig", 255);
        Personal pe2 = new Personal("Paul", "Pringle", 256);
        Personal pe3 = new Personal("Lola", "Lachs", 257);
        personal.add(pe1);
        personal.add(pe2);
        personal.add(pe3);

        //Lokführer Qualifikation
        //Optionen: reinelektrisch, standardperson, hochgeschwindigkeit, transport
        ArrayList<String> lokfuehrerqualifikation1 = new ArrayList<String>();
        lokfuehrerqualifikation1.add("reinelektrisch");
        lokfuehrerqualifikation1.add("standardperson");
        lokfuehrerqualifikation1.add("hochgeschwindigkeit");
        Lokfuehrer lf1 = new Lokfuehrer("Til", "Tetris", 201, lokfuehrerqualifikation1, format.parse("31.10.1990"));
        ArrayList<String> lokfuehrerqualifikation2 = new ArrayList<String>();
        lokfuehrerqualifikation2.add("standardperson");
        Lokfuehrer lf2 = new Lokfuehrer("Fred", "Fischbein", 202, lokfuehrerqualifikation2, format.parse("29.05.1965"));
        ArrayList<String> lokfuehrerqualifikation3 = new ArrayList<String>();
        lokfuehrerqualifikation3.add("standardperson");
        lokfuehrerqualifikation3.add("hochgeschwindigkeit");
        Lokfuehrer lf3 = new Lokfuehrer("Manuel", "Meckern", 203, lokfuehrerqualifikation3, format.parse("28.03.1972"));
        
        lokfuehrer.add(lf1);
        lokfuehrer.add(lf2);
        lokfuehrer.add(lf3);

        personen.add(pa1);
        personen.add(pa2);
        personen.add(pa3);
        personen.add(pe1);
        personen.add(pe2);
        personen.add(pe3);
        personen.add(lf1);
        personen.add(lf2);
        personen.add(lf3);

    }

    //Jordan
    //Personen printOut
    public void printOutPersonen(){
        for(Person person : personen){
            if(person!=null){
                o.printData(person.getVorname() + " " + person.getNachname());
            }
        }
    }
    
    public void printOutLokfuehrer(){
        for(Lokfuehrer lokfuehrer : lokfuehrer){
            if(lokfuehrer!=null){
                o.printData(lokfuehrer.getVorname() + " " + lokfuehrer.getNachname());
            }
        }
    }
    
    public void printOutPassagiere(){
        for(Passagier passagier : passagiere){
            if(passagier!=null){
                o.printData(passagier.getVorname() + " " + passagier.getNachname());
            }
        }
    }

    public void printOutPersonal(){
        for(Personal personal : personal){
            if(personal!=null){
                o.printData(personal.getVorname() + " " + personal.getNachname());
            }
        }
    }

    //CREATE-METHODEN
    //createPersonen
    public void createLokfuehrer(){
        o.printData("Lokführer erstellen");
        o.printData("Vorname: ");
        String lokfuehrervorname = getScanner().nextLine();
        o.printData("Nachname: ");
        String lokfuehrernachname = getScanner().nextLine();
        o.printData("Lokfuehrernummer: ");
        String lokfuehrernummer_string = getScanner().nextLine();
        int lokfuehrernummer = Integer.parseInt(lokfuehrernummer_string);
        //o.printData("Qualifikation: ");

        o.printData("Zulassung (Datum): ");
        String lokfuehrerzulassung_string = getScanner().nextLine();
        Date lokfuehrerzulassung = format.parse(lokfuehrerzulassung_string);

        // 1. EIngabe für die Qualifikation

        String q = "reinelektrisch hochgeschwindigkeit";

        // SPLIT an der Leertaste -> String Array "reinelektrisch", "hochgeschwindigkeit"

        ArrayList<String> quali = new ArrayList<>();
        quali.add(q);
        lokfuehrer.add(new Lokfuehrer(lokfuehrervorname, lokfuehrernachname, lokfuehrernummer, quali, lokfuehrerzulassung));


        

        
    }

    // Setter und Getter
    public MainController getMc() {
        return mc;
    }

    public void setMc(MainController mc) {
        this.mc = mc;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
    public Scanner getScanner() {
        return scanner;
    }


    public ArrayList<Person> getPersonen() {
        return personen;
    }

    public void setPersonen(ArrayList<Person> personen) {
        this.personen = personen;
    }

    public ArrayList<Lokfuehrer> getLokfuehrer() {
        return lokfuehrer;
    }
    
    public void setLokfuehrer(ArrayList<Lokfuehrer> lokfuehrer) {
        this.lokfuehrer = lokfuehrer;
    }

    public ArrayList<Passagier> getPassagiere() {
        return passagiere;
    }

    public void setPassagiere(ArrayList<Passagier> passagiere) {
        this.passagiere = passagiere;
    }

    public ArrayList<Personal> getPersonal() {
        return personal;
    }

    public void setPersonal(ArrayList<Personal> personal) {
        this.personal = personal;
    }

}


/*
//DATUM CODE
package controller;
//Import model --> Für Zugriff auf Model-Klassen
import model.*;
//Import view --> Für Ausgabe
import view.*;
//Import für ArrayList
import java.util.ArrayList;
//Mehrere Imports für Datum/Standort!
import java.util.Locale;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class KlassenfahrtController {
    //Erstellung einer Instanz der Klasse Output, um an jenem per Punktnotation die Ausgabemethode (printData) aufrufen zu können
    Output o = new Output();
    //Instanz mc der Klasse MainController
    MainController mc;
    //ArrayList für mehrere Instanzen der Klasse Klassenfahrt
    ArrayList<Klassenfahrt> klassenfahrt = new ArrayList<Klassenfahrt>();
    //Formatfestlegung für die Datumsvariablen. Das Datum orientiert sich an dem deutschen Standard --> Per Punktnotation an jener Instanz können nun über die parse-Methode Strings übergeben werden, welche sich an diesem definierten Datumsformat orientieren.
    DateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN);

    //Constructor --> Übergabe der MainController-Instanz!
    public KlassenfahrtController(MainController mc){
        setKlassenfahrt(klassenfahrt);
        setMc(mc);
    }

    //Methode für die Erstellung der entsprechenden Lehrer-Arrays und Klassenfahrten
    public void createKlassenfahrtData() throws ParseException{
        //Zunächst werden ArrayLists erstellt, die unterschiedliche Kombination von Lehrern abbilden (siehe lehrer1, lehrer2, etc.). Folglich werden in diese Arrays die respektiven Lehrer Instanzen aus der Lehrer-ArrayLists (siehe Lehrer-Controller) jeweils hinzugefügt über einen Parameterübergabe bezogen auf die add-Methode. Hierbei ist zu beachten, dass per Punktnotation an dem MainController zunächst der Lehrer-Controller aufgerufen wird, der dann auf die einzelnen Lehrer-Instanzen zugreifen kann.
        //Herr Odens und Herr Trampe
        ArrayList<Lehrer> lehrer1 = new ArrayList<Lehrer>();
        lehrer1.add(getMc().getLec().getLehrer().get(0));
        lehrer1.add(getMc().getLec().getLehrer().get(1));

        //Herr Odens und Herr Simsky
        ArrayList<Lehrer> lehrer2 = new ArrayList<Lehrer>();
        lehrer2.add(getMc().getLec().getLehrer().get(0));
        lehrer2.add(getMc().getLec().getLehrer().get(2));

        //Herr Trampe und Herr Simsky
        ArrayList<Lehrer> lehrer3 = new ArrayList<Lehrer>();
        lehrer3.add(getMc().getLec().getLehrer().get(1));
        lehrer3.add(getMc().getLec().getLehrer().get(2));

        //Nur Herr Trampe
        ArrayList<Lehrer> lehrer4 = new ArrayList<Lehrer>();
        lehrer4.add(getMc().getLec().getLehrer().get(0));

        //Erstellung der Klassenfahrt-Instanzen --> Hier wird erneut über die Punktnotation vorgegangen (siehe MainController und jeweils die Controller der benötigten Klassen)! Es sind alle Möglichkeiten an den jeweiligen Instanzen gegeben.
        //Nur ein Lehrer --> fail
        Klassenfahrt kl1 = new Klassenfahrt(getMc().getRec().getReiseziel().get(0), lehrer4,getMc().getKlc().getKlasse().get(0), format.parse("17.01.2022"), format.parse("21.01.2022"));
        //Nicht beide Lehrer haben Erlaubnis --> fail
        Klassenfahrt kl2 = new Klassenfahrt(getMc().getRec().getReiseziel().get(1), lehrer2,getMc().getKlc().getKlasse().get(1), format.parse("06.06.2022"), format.parse("10.06.2022"));
        //Zu Teuer für die Schüler --> fail 
        Klassenfahrt kl3 = new Klassenfahrt(getMc().getRec().getReiseziel().get(2), lehrer2,getMc().getKlc().getKlasse().get(2), format.parse("07.02.2022"), format.parse("11.02.2022"));
        //Schüler erfüllen nicht Mindestalter --> fail
        Klassenfahrt kl4 = new Klassenfahrt(getMc().getRec().getReiseziel().get(3), lehrer1,getMc().getKlc().getKlasse().get(3), format.parse("20.12.2021"), format.parse("24.12.2021"));
        //Alle Bedingungen sind erfüllt --> Klassenfahrt genehmigt!
        Klassenfahrt kl5 = new Klassenfahrt(getMc().getRec().getReiseziel().get(4), lehrer1,getMc().getKlc().getKlasse().get(4), format.parse("27.12.2021"), format.parse("31.12.2021"));

        //Hinzufügen der Instanzen zu einer entsprechenden ArrayList über Punktnotation (siehe add-Methode)
        klassenfahrt.add(kl1);
        klassenfahrt.add(kl2);
        klassenfahrt.add(kl3);
        klassenfahrt.add(kl4);
        klassenfahrt.add(kl5);
    }

*/