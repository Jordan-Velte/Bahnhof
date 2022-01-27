//Jordan
package controller;
import model.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import view.*;

public class BuchungController {
    MainController mc;
    ArrayList<Buchung> buchung = new ArrayList<Buchung>();
    DateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN);
    Output o = new Output();
    Scanner scanner; 

    public BuchungController(MainController mc){
        setBuchung(buchung);
        setMc(mc);
        this.setScanner(new Scanner(System.in));
    }
    public void createDemoDaten() throws ParseException{
        Buchung b1 = new Buchung(1, getMc().getZlc().getZuglinie().get(0), getMc().getPc().getPassagiere().get(0), 68.9, format.parse("1.1.2022"));
        Buchung b2 = new Buchung(2, getMc().getZlc().getZuglinie().get(1), getMc().getPc().getPassagiere().get(1), 100.9, format.parse("8.1.2022"));
        buchung.add(b1);
        buchung.add(b2);
    }

    //Jordan
    public void printOutBuchung(){
        for(Buchung buchung : buchung){
            if(buchung!=null){
                o.printData("Buchungsnummer: " + buchung.getBuchungsnummer() + "; Abfahrt: " + buchung.getZuglinie().getBahnhof().get(0).getName() + "; Ankunft: " + buchung.getZuglinie().getBahnhof().get(buchung.getZuglinie().getBahnhof().size()-1).getName() + "; Passagier: " + buchung.getPassagier().getVorname() + " " + buchung.getPassagier().getNachname() + "; Preis: " + buchung.getPreis() +"EUR; Buchungsdatum: " + buchung.getBuchungsdatum());
            }
        }
    }

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

    }

    public void checkBuchungPreis(){
        for(Buchung buchung : buchung){
            if(buchung!=null && buchung.getPreis()<=50){
                o.printData("Die Buchung der Buchungsnummer " + buchung.getBuchungsnummer() + " des Passagiers " + buchung.getPassagier().getVorname() + " " + buchung.getPassagier().getNachname() + " ist der Preiskategorie GÜNSTIG50TARIF zuzordnen.");
            }
            else if(buchung!=null && buchung.getPreis()>50 && buchung.getPreis()<=150){
                o.printData("Die Buchung der Buchungsnummer " + buchung.getBuchungsnummer() + " des Passagiers " + buchung.getPassagier().getVorname() + " " + buchung.getPassagier().getNachname() + " ist der Preiskategorie STANDARDTARIF zuzordnen.");
            }
            else if(buchung!=null && buchung.getPreis()<150){
                o.printData("Die Buchung der Buchungsnummer " + buchung.getBuchungsnummer() + " des Passagiers " + buchung.getPassagier().getVorname() + " " + buchung.getPassagier().getNachname() + " ist der Preiskategorie FULLFLEXTARIF zuzordnen.");
            }
        }
    }

    

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
