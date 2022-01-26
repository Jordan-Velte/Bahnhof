//Jordan
package controller;
import model.*;
import java.util.ArrayList;
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

    public void createBuchung(){
        o.printData("Buchung erstellen");
        o.printData("Buchungsnummer: ");
        String buchungsnummer_string = getScanner().nextLine();
        int buchungsnummer = Integer.valueOf(buchungsnummer_string);
        

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
