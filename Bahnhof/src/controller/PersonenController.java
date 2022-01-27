//LENNARD
package controller;
//IMPORTS
import model.*;
import view.Output;
import java.util.ArrayList;
// Import für Datum
import java.util.Locale;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Scanner;
import java.util.Date;
import java.util.List;
import java.util.Arrays;

public class PersonenController {
    //VARIABLENDEKLARATION
    MainController mc;
    ArrayList<Person> personen;
    ArrayList<Lokfuehrer> lokfuehrer;
    ArrayList<Passagier> passagiere;
    ArrayList<Personal> personal;
    //Notwendig für Interaktion mit dem Terminal (siehe create-Methode)
    Scanner scanner;
    //Output-Instanz --> Zugriff auf printData-Methodik über Punktnotation
    Output o = new Output();

    DateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN);

    //CONSTRUCTOR
    //Übergabe des MainControllers --> Über Punktnotation somit Zugriff auf andere Klassen!
    public PersonenController(MainController mc){
        setMc(mc);
        personen = new ArrayList<Person>();
        lokfuehrer = new ArrayList<Lokfuehrer>();
        passagiere = new ArrayList<Passagier>();
        personal = new ArrayList<Personal>();
        //Setter für den Scanner, notwendig für Eingabe übers Terminal
        this.setScanner(new Scanner(System.in));
    }
    //DEMODATEN
    public void createDemoDaten() throws ParseException{
        //Initialisierung der Instanzen der Subklassen, sowie Hinzufügen in Subklassen-ArrayList über Punktnotation
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
        //ArrayList für unterschiedliche Lokführerqualifikation-Strings
        ArrayList<String> lokfuehrerqualifikation1 = new ArrayList<String>();
        //Übergabe einzelner Strings in ArrayList
        lokfuehrerqualifikation1.add("reinelektrisch");
        lokfuehrerqualifikation1.add("standardperson");
        lokfuehrerqualifikation1.add("hochgeschwindigkeit");
        //Initialisierung der Instanz durch Parameterübergabe --> siehe zudem Übergabe der initialisierten ArrayList in Hinblick auf die Lokführer-Qualifikation
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

        //Hinzufügen der Instanzen der Subklassen in Oberklassen-ArrayList
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

    //DATENAUSGABE PERSONEN
    public void printOutPersonen(){
        for(Person person : personen){
            if(person!=null){
                o.printData(person.getVorname() + " " + person.getNachname());
            }
        }
    }
    
    //DATENAUSGABE LOKFÜHRER
    public void printOutLokfuehrer(){
        for(Lokfuehrer lokfuehrer : lokfuehrer){
            if(lokfuehrer!=null){
                o.printData(lokfuehrer.getVorname() + " " + lokfuehrer.getNachname());
            }
        }
    }
    
    //DATENAUSGABE PASSAGIERE
    public void printOutPassagiere(){
        for(Passagier passagier : passagiere){
            if(passagier!=null){
                o.printData(passagier.getVorname() + " " + passagier.getNachname());
            }
        }
    }

    //DATENAUSGABE PERSONAL
    public void printOutPersonal(){
        for(Personal personal : personal){
            if(personal!=null){
                o.printData(personal.getVorname() + " " + personal.getNachname());

            }
        }
    }

    //CREATE-METHODEN --> Abstrakte Oberklasse kann keine Instanzen erstellen!
    //DATENEINGABE PASSAGIER (Vorgehen bereits erklärt)
    public void createPassagier(){
        o.printData("Passagier erstellen");
        o.printData("Vorname: ");
        String passagiervorname = getScanner().nextLine();
        o.printData("Nachname: ");
        String passagiernachname = getScanner().nextLine();
        o.printData("Kundenummer: ");
        String passagierkundennummer_string = getScanner().nextLine();
        int passagierkundennummer = Integer.valueOf(passagierkundennummer_string);
        Passagier newpassagier = new Passagier(passagiervorname, passagiernachname, passagierkundennummer);
        passagiere.add(newpassagier);
        personen.add(newpassagier);
        o.printData("Passagier wurde erstellt!");

    }

    //DATENEINGABE PERSONAL
    public void createPersonal(){
        o.printData("Personal erstellen");
        o.printData("Vorname: ");
        String personalvorname = getScanner().nextLine();
        o.printData("Nachname: ");
        String personalnachname = getScanner().nextLine();
        o.printData("Personalnummer: ");
        String personalnummer_string = getScanner().nextLine();
        int personalnummer = Integer.valueOf(personalnummer_string);
        Personal newpersonal = new Personal(personalvorname, personalnachname, personalnummer);
        personal.add(newpersonal);
        personen.add(newpersonal);
        o.printData("Personal wurde erstellt!");
    }

    //DATENEINGABE LOKFÜHRER
    public void createLokfuehrer() throws ParseException{
        o.printData("Lokführer erstellen");
        o.printData("Vorname: ");
        String lokfuehrervorname = getScanner().nextLine();
        o.printData("Nachname: ");
        String lokfuehrernachname = getScanner().nextLine();
        o.printData("Lokfuehrernummer: ");
        String lokfuehrernummer_string = getScanner().nextLine();
        int lokfuehrernummer = Integer.parseInt(lokfuehrernummer_string);
        //Durch Kommata werden die einzelnen Qualifikationen-Strings getrennt und in einer ArrayList zusammengefasst: 
        o.printData("Qualifikation (zur Auswahl stehen: reinelektrisch, standardperson, hochgeschwindigkeit und transport; wenn Anzahl>1: Kommata!): ");
        String lokfuehrerqualifikationstring = getScanner().nextLine();
        //Umwandlung von Strings, die durch Kommata separiert sind, zu einem Array von Strings
        String[] loksplit = lokfuehrerqualifikationstring.split(",");
        //Umwandlung des String Arrays zu einer Liste!
        List<String> fixedqualilist = Arrays.asList(loksplit);
        //Neue String-ArrayList für die Qualifikation eines Lokführers --> Parameterübergabe: Liste!
        ArrayList<String> lokfuehrerqualifikation = new ArrayList<String>(fixedqualilist);
        o.printData("Zulassung (Datum): ");
        String lokfuehrerzulassung_string = getScanner().nextLine();
        Date lokfuehrerzulassung = format.parse(lokfuehrerzulassung_string);
        Lokfuehrer newlokfuehrer = new Lokfuehrer(lokfuehrervorname, lokfuehrernachname, lokfuehrernummer, lokfuehrerqualifikation, lokfuehrerzulassung);
        lokfuehrer.add(newlokfuehrer);
        personen.add(newlokfuehrer);
        o.printData("Lokführer wurde erstellt!");

        lokfuehrer.add(new Lokfuehrer(lokfuehrervorname, lokfuehrernachname, lokfuehrernummer, lokfuehrerqualifikation, lokfuehrerzulassung));
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

//CODE GRAVEYARD
        /*
        // 1. EIngabe für die Qualifikation

        String q = "reinelektrisch hochgeschwindigkeit";

        // SPLIT an der Leertaste -> String Array "reinelektrisch", "hochgeschwindigkeit"

        ArrayList<String> quali = new ArrayList<>();
        quali.add(q);*/
    /*
    public void createPassagiere(){
        o.printData("Passagier erstellen");
        o.printData("Vorname: ");
        String passagiervorname = getScanner().nextLine();
        o.printData("Nachname: ");
        String passagiernachname = getScanner().nextLine();
        o.printData("Kundennummer: ");
        String passagierkundennummer_string = getScanner().nextLine();
        int passagierkundennummer = Integer.parseInt(passagierkundennummer_string);
        
        passagiere.add(new Passagier(passagiervorname, passagiernachname, passagierkundennummer));
        personen.add(new Passagier(passagiervorname, passagiernachname, passagierkundennummer));
    }

    public void createPersonal(){
        o.printData("Personal erstellen");
        o.printData("Vorname: ");
        String personalvorname = getScanner().nextLine();
        o.printData("Nachname: ");
        String personalnachname = getScanner().nextLine();
        o.printData("Personalnummer: ");
        String personalnummer_string = getScanner().nextLine();
        int personalnummer = Integer.parseInt(personalnummer_string);

        personal.add(new Personal(personalvorname, personalnachname, personalnummer));
        personen.add(new Personal(personalvorname, personalnachname, personalnummer));
    }
    */

    /*
    public void printOutDemoDatenPersonen(){
        for(Person personen : personen){
            if(personen != null){
                o.printData("Nachname: " + personen.getNachname() + "; Vorname: " + personen.getVorname());
            }
        }
    }

    public void printOutDemoDatenLokfuehrer(){
        for(Lokfuehrer lokfuehrer: lokfuehrer){
            if(lokfuehrer != null){
                o.printData("Nachname: " + lokfuehrer.getNachname() + "; Vorname: " + lokfuehrer.getVorname() + "; Lokführernummer: " + lokfuehrer.getLokfuehrernummer());
            }
        }
    }

    public void printOutDemoDatenPassagiere(){
        for(Passagier passagiere : passagiere){
            if(passagiere != null){
                o.printData("Nachname: " + passagiere.getNachname() + "; Vorname: " + passagiere.getVorname() + "; Kundennummer: " + passagiere.getKundennummer());
            }
        }
    }

    public void printOutDemoDatenPersonal(){
        for(Personal personal : personal){
            if(personal != null){
                o.printData("Nachname: " + personal.getNachname() + "; Vorname: " + personal.getVorname() + "; Personalnummer: " + personal.getPersonalnummer());
            }
        }
    }
    */