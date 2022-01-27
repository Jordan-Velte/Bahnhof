//JORDAN
package controller;
//IMPORTS
//Import für den Zugriff auf Model-Klassen --> MVC Struktur: Controller = Schnittstelle von Model und View
import model.*;
//Import für ArrayList
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
//Import für Scanner
import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
//Import view für Zugriff auf Output-Klasse (Ausgabe-Methode) --> MVC Struktur: Controller = Schnittstelle von Model und View
import view.*;

public class BuchungController {
    //VARIABLENDEKLARATION
    MainController mc;
    ArrayList<Buchung> buchung = new ArrayList<Buchung>();
    DateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN);
    //Output-Instanz --> Zugriff auf printData-Methodik über Punktnotation
    Output o = new Output();
    //Notwendig für Interaktion mit dem Terminal (siehe create-Methode)
    Scanner scanner; 

    //CONSTRUCTOR
    //Übergabe des MainControllers --> Über Punktnotation somit Zugriff auf andere Klassen!
    public BuchungController(MainController mc){
        setBuchung(buchung);
        setMc(mc);
        //Setter für den Scanner, notwendig für Eingabe übers Terminal
        this.setScanner(new Scanner(System.in));
    }

    //DEMODATEN
    public void createDemoDaten() throws ParseException{
        //Initialisierung von Buchungs-Instanzen --> Punktnotation per MainController-Getter (siehe MVC-Struktur)
        Buchung b1 = new Buchung(1, getMc().getZlc().getZuglinie().get(0), getMc().getPc().getPassagiere().get(0), 68.9, format.parse("1.1.2022"));
        Buchung b2 = new Buchung(2, getMc().getZlc().getZuglinie().get(1), getMc().getPc().getPassagiere().get(1), 100.9, format.parse("8.1.2022"));
        //Hinzufügen der Buchungs-Instanzen in eine ArrayList
        buchung.add(b1);
        buchung.add(b2);
    }

    //DATENAUSGABE BUCHUNG
    public void printOutBuchung(){
        for(Buchung buchung : buchung){
            if(buchung!=null){
                o.printData("Buchungsnummer: " + buchung.getBuchungsnummer() + "; Abfahrt: " + buchung.getZuglinie().getBahnhof().get(0).getName() + "; Ankunft: " + buchung.getZuglinie().getBahnhof().get(buchung.getZuglinie().getBahnhof().size()-1).getName() + "; Passagier: " + buchung.getPassagier().getVorname() + " " + buchung.getPassagier().getNachname() + "; Preis: " + buchung.getPreis() +"EUR; Buchungsdatum: " + buchung.getBuchungsdatum());
            }
        }
    }

    //DATENEINGABE BUCHUNG (Vorgehen bereits in anderen Controller-Klassen aufgeführt)
    public void createBuchung() throws ParseException{
        o.printData("Buchung erstellen");
        o.printData("Buchungsnummer: ");
        String buchungsnummer_string = getScanner().nextLine();
        int buchungsnummer = Integer.valueOf(buchungsnummer_string);
        o.printData("Zuglinie: ");
        int i1=0;
        for(Zuglinie zuglinie : getMc().getZlc().getZuglinie()){
            if(zuglinie!=null){
                o.printData(i1 + " - " + zuglinie.getZugliniennummer() + ": " + zuglinie.getBahnhof().get(0).getName() + "-" + zuglinie.getBahnhof().get(zuglinie.getBahnhof().size()-1).getName());
                i1++;
            }
        }
        String zugliniechoice = getScanner().nextLine();
        int zuglinie_index = Integer.valueOf(zugliniechoice);
        Zuglinie buchungzuglinie = getMc().getZlc().getZuglinie().get(zuglinie_index);
        o.printData("Passagier: ");
        int i2 = 0;
        for(Passagier passagier : getMc().getPc().getPassagiere()){
            if(passagier!=null){
                o.printData(i2 + " - " + passagier.getVorname() + " " + passagier.getNachname());
                i2++;
            }
        }
        String passagierchoice_string = getScanner().nextLine();
        int passagierchoice = Integer.valueOf(passagierchoice_string);
        Passagier buchungpassagier = getMc().getPc().getPassagiere().get(passagierchoice);
        o.printData("Preis: ");
        String buchungpreis_string = getScanner().nextLine();
        double buchungspreis = Double.valueOf(buchungpreis_string);
        o.printData("Buchungsdatum: ");
        String buchungsdatum_string = getScanner().nextLine();
        Date buchungsdatum = format.parse(buchungsdatum_string);
        Buchung newbuchung = new Buchung(buchungsnummer, buchungzuglinie, buchungpassagier, buchungspreis, buchungsdatum);
        buchung.add(newbuchung);
        o.printData("Buchung erstellt!");

    }

    //ÜBERPRÜFUNGS-METHODE: Kategorisierung des Buchungspreises 
    public void checkBuchungPreis(){
        //For-Each-Schleife iteriert durch alle Elemente der Buchung-ArrayList
        for(Buchung buchung : buchung){
            //Sofern das Element Buchung ungleich null und dessen Preis kleiner gleich 50 --> Preiskategorie GÜNSTIG50TARIF
            if(buchung!=null && buchung.getPreis()<=50){
                o.printData("Die Buchung der Buchungsnummer " + buchung.getBuchungsnummer() + " des Passagiers " + buchung.getPassagier().getVorname() + " " + buchung.getPassagier().getNachname() + " ist der Preiskategorie GÜNSTIG50TARIF zuzordnen.");
            }
            //Sofern das Element Buchung ungleich null und dessen Preis größer 50 und kleiner gleich 150 --> Preiskategorie sTANDARDTARIF
            else if(buchung!=null && buchung.getPreis()>50 && buchung.getPreis()<=150){
                o.printData("Die Buchung der Buchungsnummer " + buchung.getBuchungsnummer() + " des Passagiers " + buchung.getPassagier().getVorname() + " " + buchung.getPassagier().getNachname() + " ist der Preiskategorie STANDARDTARIF zuzordnen.");
            }
            //Sofern das Element Buchung ungleich null und dessen Preis größer 150 --> Preiskategorie FULLFLEXTARIF
            else if(buchung!=null && buchung.getPreis()>150){
                o.printData("Die Buchung der Buchungsnummer " + buchung.getBuchungsnummer() + " des Passagiers " + buchung.getPassagier().getVorname() + " " + buchung.getPassagier().getNachname() + " ist der Preiskategorie FULLFLEXTARIF zuzordnen.");
            }
        }
    }

    
    //Setter & Getter
    public void setBuchung(ArrayList<Buchung> buchung) {
        this.buchung = buchung;
    }
    public void setFormat(DateFormat format) {
        this.format = format;
    }
    public void setMc(MainController mc) {
        this.mc = mc;
    }
    public ArrayList<Buchung> getBuchung() {
        return buchung;
    }
    public DateFormat getFormat() {
        return format;
    }
    public MainController getMc() {
        return mc;
    }
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
    public Output getO() {
        return o;
    }
    public Scanner getScanner() {
        return scanner;
    }
    public void setO(Output o) {
        this.o = o;
    }


}

//CODE GRAVEYARD
/*
        for(Passagier passagier : getMc().getPc().getPassagiere()){
            if(passagier!=null){
                o.printData(i2 + " - " + passagier.getVorname() + " " + passagier.getNachname());
                i2++;
            }
        }
        String passagierchoice_string = getScanner().nextLine();
        int passagierchoice = Integer.valueOf(passagierchoice_string);
        ArrayList<Passagier> passagiereal = new ArrayList<Passagier>();
        passagiereal.add(getMc().getPc().getPassagiere().get(i2));
        while(passagierchoice_string!="abbruch"){
            int i = 0;
            for(Passagier passagier : getMc().getPc().getPassagiere()){
                if(passagier!=null){
                    o.printData(i2 + " - " + passagier.getVorname() + " " + passagier.getNachname());
                }
                i2++;
            }
            String passagierchoice_string_al = getScanner().nextLine();
            int passagierindex_al = Integer.valueOf(passagierchoice_string_al);
            passagiereal.add(getMc().getPc().getPassagiere().get(i2));
        }
        */

        //Weitere Daten kommen noch!

        /*
        int i1 = 0;
        for(Bahnhof bahnhof : getMc().getBc().getBahnhoefe()){
            if(bahnhof!=null){
                //Hoffentlich klappt das
                o.printData(i1 + " - " + getMc().getBc().getBahnhoefe().get(i1).getName() + " " + getMc().getBc().getBahnhoefe().get(i1).getStandort());
                i1++;
            }
        }
        String bahnhofabfahrt_choice = getScanner().nextLine();
        int bahnhofabfahrt_index = Integer.valueOf(bahnhofabfahrt_choice);
        
        o.printData("Abfahrt: ");
        int i2 = 0;
        for(Bahnhof bahnhof : getMc().getBc().getBahnhoefe()){
            if(bahnhof!=null){
                //Hoffentlich klappt das
                o.printData(i2 + " - " + getMc().getBc().getBahnhoefe().get(i2).getName() + " " + getMc().getBc().getBahnhoefe().get(i2).getStandort());
                i2++;
            }
        }
        String bahnhofankunft_choice = getScanner().nextLine();
        int bahnhofankunft_index = Integer.valueOf(bahnhofankunft_choice);
        */
