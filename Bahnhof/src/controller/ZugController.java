//Jordan
package controller;
import model.*;
import java.util.ArrayList;
import java.util.Date;
//Mehrere Imports für Datum/Standort!
import java.util.Locale;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import view.*;

public class ZugController {
    MainController mc;
    ArrayList<Zug> zug;
    ArrayList<HochgeschwindigkeitsZug> hochgeschwindigkeitszug;
    ArrayList<TransportZug> transportzug;
    ArrayList<ReinelektrischZug> reinelektrischzug;
    ArrayList<StandardPersonenZug> standardpersonenzug;
    Scanner scanner;
    //Formatfestlegung für die Datumsvariablen. Das Datum orientiert sich an dem deutschen Standard --> Per Punktnotation an jener Instanz können nun über die parse-Methode Strings übergeben werden, welche sich an diesem definierten Datumsformat orientieren.
    DateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN);
    Output o = new Output();

    public ZugController(MainController mc){
        zug = new ArrayList<Zug>();
        hochgeschwindigkeitszug = new ArrayList<HochgeschwindigkeitsZug>();
        transportzug = new ArrayList<TransportZug>();
        reinelektrischzug = new ArrayList<ReinelektrischZug>();
        standardpersonenzug = new ArrayList<StandardPersonenZug>();
        this.setScanner(new Scanner(System.in));
    }

    public void createDemoDaten() throws ParseException{
        HochgeschwindigkeitsZug hz1 = new HochgeschwindigkeitsZug("Shinkansen 300X", "Central Japan Railway Company", 350, 6, format.parse("01.02.1992"), 20000000);
        HochgeschwindigkeitsZug hz2 = new HochgeschwindigkeitsZug("ICE 3", "Deutsche Bahn", 300, 8, format.parse("09.07.1999"), 33000000);
        StandardPersonenZug spz1 = new StandardPersonenZug("Intercity 1", "Deutsche Bahn", 200, 8, format.parse("26.09.1971"), 703);
        StandardPersonenZug spz2 = new StandardPersonenZug("Alstom Coradia Continental", "Deutsche Bahn", 160, 4, format.parse("01.12.2008"), 450);
        TransportZug tz1 = new TransportZug("Bombardier Traxx F140 AC1", "Deutsche Bahn Cargo", 150, 30, format.parse("01.01.2000"), true, "normal", 84000);
        TransportZug tz2 = new TransportZug("Bombardier Traxx P160 DE ME", "Deutsche Bahn Cargo", 160, 30, format.parse("13.12.2013"), false, "normal", 81000);
        ReinelektrischZug rz1 = new ReinelektrischZug("Siemens ACS-64", "Amtrak", 200, 10, format.parse("07.02.2014"), "4 Drehstrom-Asynchronmotoren", 30);
        ReinelektrischZug rz2 = new ReinelektrischZug("Bombardier ALP-64", "New Jersey Transit", 200, 10, format.parse("01.12.1999"), "4 Drehstrom-Asynchronmotoren", 30);
        
        reinelektrischzug.add(rz1);
        reinelektrischzug.add(rz1);
        hochgeschwindigkeitszug.add(hz1);
        hochgeschwindigkeitszug.add(hz2);
        standardpersonenzug.add(spz1);
        standardpersonenzug.add(spz2);
        transportzug.add(tz1);
        transportzug.add(tz2);
        zug.add(rz1);
        zug.add(rz2);
        zug.add(hz1);
        zug.add(hz2);
        zug.add(spz1);
        zug.add(spz1);
        zug.add(tz1);
        zug.add(tz2);

       
    }

    //PrintOutZüge (alle)
    public void printOutZuege(){
        for(Zug zug : zug){
            if(zug!=null){
                o.printData("Betreiber: " + zug.getBetreiber() + "; Modell: " + zug.getModell() + "; Wagonzahl: " + zug.getWagonanzahl() + "; Durchschnittsgeschwindigkeit: " + zug.getDurchschnittsgeschwindigkeit() + "km/h; Zulassungsdatum: " + zug.getZulassungsdatum());
            }
        }
    }

    //Reinelektrisch
    public void printOutReinelektrischZuege(){
        for(ReinelektrischZug reinelektrischzug : reinelektrischzug){
            if(reinelektrischzug!=null){
                o.printData("Betreiber: " + reinelektrischzug.getBetreiber() + "; Modell: " + reinelektrischzug.getModell() + "; Wagonzahl: " + reinelektrischzug.getWagonanzahl() + "; Durchschnittsgeschwindigkeit: " + reinelektrischzug.getDurchschnittsgeschwindigkeit() + "km/h; Zulassungsdatum: " + reinelektrischzug.getZulassungsdatum() + "; Energieversorgung: " + reinelektrischzug.getEnergieversorgung() + "; Batterielebensdauer: " + reinelektrischzug.getBatterielebensdauerinjahren() + " Jahre");
            }
        }
    }

    //Hochgeschwindigkeit
    public void printOutHochgeschwindigkeitsZuege(){
        for(HochgeschwindigkeitsZug hochgeschwindigkeitszug : hochgeschwindigkeitszug){
            if(hochgeschwindigkeitszug!=null){
                o.printData("Betreiber: " + hochgeschwindigkeitszug.getBetreiber() + "; Modell: " + hochgeschwindigkeitszug.getModell() + "; Wagonzahl: " + hochgeschwindigkeitszug.getWagonanzahl() + "; Durchschnittsgeschwindigkeit: " + hochgeschwindigkeitszug.getDurchschnittsgeschwindigkeit() + "km/h; Zulassungsdatum: " + hochgeschwindigkeitszug.getZulassungsdatum() + "; Entwicklungskosten: " + hochgeschwindigkeitszug.getEntwicklungskosten()/1000000 + " Millionen Euro");
            }
        }
    }

    //Standardpersonenzug
    public void printOutStandardPersonenZuege(){
        for(StandardPersonenZug standardpersonenzug : standardpersonenzug){
            if(standardpersonenzug!=null){
                o.printData("Betreiber: " + standardpersonenzug.getBetreiber() + "; Modell: " + standardpersonenzug.getModell() + "; Wagonzahl: " + standardpersonenzug.getWagonanzahl() + "; Durchschnittsgeschwindigkeit: " + standardpersonenzug.getDurchschnittsgeschwindigkeit() + "km/h; Zulassungsdatum: " + standardpersonenzug.getZulassungsdatum() + "; Maximale Personenladung: " + standardpersonenzug.getMaxpersonenladung());
            }
        }
    }

    //Transportzug
    public void printOutTransportZuege(){
        for(TransportZug transportzug : transportzug){
            if(transportzug!=null){
                if(transportzug.getLangstreckenzulassung() == true){
                    o.printData("Betreiber: " + transportzug.getBetreiber() + "; Modell: " + transportzug.getModell() + "; Wagonzahl: " + transportzug.getWagonanzahl() + "; Durchschnittsgeschwindigkeit: " + transportzug.getDurchschnittsgeschwindigkeit() + "km/h; Zulassungsdatum: " + transportzug.getZulassungsdatum() + ", Umweltbelastung: " + transportzug.getUmweltbelastung() + "; Maximales Gesamtgewicht: " + transportzug.getMaxgesamtgewichtinkg()/1000 + " Tonnen; " + "Langstreckenzulassung: erteilt");  
                }
                else if(transportzug.getLangstreckenzulassung() != true){
                    o.printData("Betreiber: " + transportzug.getBetreiber() + "; Modell: " + transportzug.getModell() + "; Wagonzahl: " + transportzug.getWagonanzahl() + "; Durchschnittsgeschwindigkeit: " + transportzug.getDurchschnittsgeschwindigkeit() + "km/h; Zulassungsdatum: " + transportzug.getZulassungsdatum() + ", Umweltbelastung: " + transportzug.getUmweltbelastung() + "; Maximales Gesamtgewicht: " + transportzug.getMaxgesamtgewichtinkg()/1000 + " Tonnen; " + "Langstreckenzulassung: nicht erteilt");  
                }
            }
        }
    }

    //Create Zuege: 
    //create Reinelektrischzuege
    public void createReinelektrischZuege() throws ParseException{
        o.printData("Reinelektrischen Zug erstellen: ");
        o.printData("Modell: ");
        String reinelektrischmodell = getScanner().nextLine();
        o.printData("Betreiber: ");
        String reinelektrischbetreiber = getScanner().nextLine();
        o.printData("Durchschnittliche Kilometer in km/h: ");
        String reinelektrischdurchschnittsgeschwindigkeit_string = getScanner().nextLine();
        double reinelektrischdurchschnittsgeschwindigkeit = Double.parseDouble(reinelektrischdurchschnittsgeschwindigkeit_string);
        o.printData("Wagonzahl: ");
        String reinelektrischwagonzahl_string = getScanner().nextLine();
        int reinelektrischwagonzahl = Integer.parseInt(reinelektrischwagonzahl_string);
        o.printData("Zulassungsdatum: ");
        String reinelektrischzulassungsdatum_string = getScanner().nextLine();
        Date reinelektrischzulassungdatum = format.parse(reinelektrischzulassungsdatum_string);
        o.printData("Energieversorgung: ");
        String reinelektrischenergieversorgung = getScanner().nextLine();
        o.printData("Lebensdauer der Batterie (in Jahren(): ");
        String reinelektrischbatterielebensdauer_string = getScanner().nextLine();
        double reinelektrischbatterielebensdauer = Double.parseDouble(reinelektrischbatterielebensdauer_string);
        ReinelektrischZug newreinelektrischzug = new ReinelektrischZug(reinelektrischmodell, reinelektrischbetreiber, reinelektrischdurchschnittsgeschwindigkeit, reinelektrischwagonzahl, reinelektrischzulassungdatum, reinelektrischenergieversorgung, reinelektrischbatterielebensdauer);
        reinelektrischzug.add(newreinelektrischzug);
        zug.add(newreinelektrischzug);
        o.printData("Reinelektrischer Zug wurde erstellt!");
    }

    public void createHochgeschwindigkeitsZuege() throws ParseException{
        o.printData("Hochgeschwindigkeitszug erstellen: ");
        o.printData("Modell: ");
        String hochgeschwindigkeitmodell = getScanner().nextLine();
        o.printData("Betreiber: ");
        String hochgeschwindigkeitbetreiber = getScanner().nextLine();
        o.printData("Durchschnittliche Kilometer in km/h: ");
        String hochgeschwindigkeitdurchschnittsgeschwindigkeit_string = getScanner().nextLine();
        double hochgeschwindigkeithdurchschnittsgeschwindigkeit = Double.parseDouble(hochgeschwindigkeitdurchschnittsgeschwindigkeit_string);
        o.printData("Wagonzahl: ");
        String hochgeschwindigkeitwagonzahl_string = getScanner().nextLine();
        int hochgeschwindigkeitwagonzahl = Integer.parseInt(hochgeschwindigkeitwagonzahl_string);
        o.printData("Zulassungsdatum: ");
        String hochgeschwindigkeitzulassungsdatum_string = getScanner().nextLine();
        Date hochgeschwindigkeitzulassungdatum = format.parse(hochgeschwindigkeitzulassungsdatum_string);
        o.printData("Entwicklungskosten in EUR: ");
        String hochgeschwindigkeitentwicklungskosten_string = getScanner().nextLine();
        double hochgeschwindigkeitentwicklungskosten = Double.parseDouble(hochgeschwindigkeitentwicklungskosten_string);
        HochgeschwindigkeitsZug newhochgeschwindigkeitzug = new HochgeschwindigkeitsZug(hochgeschwindigkeitmodell, hochgeschwindigkeitbetreiber, hochgeschwindigkeithdurchschnittsgeschwindigkeit, hochgeschwindigkeitwagonzahl, hochgeschwindigkeitzulassungdatum, hochgeschwindigkeitentwicklungskosten);
        hochgeschwindigkeitszug.add(newhochgeschwindigkeitzug);
        zug.add(newhochgeschwindigkeitzug);
        o.printData("Hochgeschwindigkeitszug wurde erstellt!");
    }

    public void createStandardpersonenZuege() throws ParseException{
        o.printData("Standardpersonenzug erstellen: ");
        o.printData("Modell: ");
        String standardpersonmodell = getScanner().nextLine();
        o.printData("Betreiber: ");
        String standardpersonbetreiber = getScanner().nextLine();
        o.printData("Durchschnittliche Kilometer in km/h: ");
        String standardpersondurchschnittsgeschwindigkeit_string = getScanner().nextLine();
        double standardpersondurchschnittsgeschwindigkeit = Double.parseDouble(standardpersondurchschnittsgeschwindigkeit_string);
        o.printData("Wagonzahl: ");
        String standardpersonwagonzahl_string = getScanner().nextLine();
        int standardpersonwagonzahl = Integer.parseInt(standardpersonwagonzahl_string);
        o.printData("Zulassungsdatum: ");
        String standardpersonzulassungsdatum_string = getScanner().nextLine();
        Date standardpersonzulassungdatum = format.parse(standardpersonzulassungsdatum_string);
        o.printData("Maximale Personenladung: ");
        String standardpersonmaxpersonenladung_string = getScanner().nextLine();
        int standardpersonmaxpersonenladung = Integer.valueOf(standardpersonmaxpersonenladung_string);
        StandardPersonenZug newstandardpersonzug = new StandardPersonenZug(standardpersonmodell, standardpersonbetreiber, standardpersondurchschnittsgeschwindigkeit, standardpersonwagonzahl, standardpersonzulassungdatum, standardpersonmaxpersonenladung);
        standardpersonenzug.add(newstandardpersonzug);
        zug.add(newstandardpersonzug);
        o.printData("Standardpersonenzug wurde erstellt!");

    }

    public void createTransportZuege() throws ParseException{
        o.printData("Transport erstellen: ");
        o.printData("Modell: ");
        String transportmodell = getScanner().nextLine();
        o.printData("Betreiber: ");
        String transportbetreiber = getScanner().nextLine();
        o.printData("Durchschnittliche Kilometer in km/h: ");
        String transportdurchschnittsgeschwindigkeit_string = getScanner().nextLine();
        double transportdurchschnittsgeschwindigkeit = Double.parseDouble(transportdurchschnittsgeschwindigkeit_string);
        o.printData("Wagonzahl: ");
        String transportwagonzahl_string = getScanner().nextLine();
        int transportwagonzahl = Integer.parseInt(transportwagonzahl_string);
        o.printData("Zulassungsdatum: ");
        String transportzulassungsdatum_string = getScanner().nextLine();
        Date transportzulassungdatum = format.parse(transportzulassungsdatum_string);
        o.printData("Langstreckenzulassung (ja=true): ");
        String transportlangstreckenzulassung_string = getScanner().nextLine();
        boolean transportlangstreckenzulassung = Boolean.valueOf(transportlangstreckenzulassung_string);
        o.printData("Umweltbelastung (stark/normal/wenig): ");
        String transportumweltbelastung = getScanner().nextLine();
        o.printData("Maximales Gesamtgewicht in Kilogramm: ");
        String transportmaxgesamtgewicht_string = getScanner().nextLine();
        int transportmaxgesamtgewicht = Integer.valueOf(transportmaxgesamtgewicht_string);
        TransportZug newtransportzug = new TransportZug(transportmodell, transportbetreiber, transportdurchschnittsgeschwindigkeit, transportwagonzahl, transportzulassungdatum, transportlangstreckenzulassung, transportumweltbelastung, transportmaxgesamtgewicht);
        transportzug.add(newtransportzug);
        zug.add(newtransportzug);
        o.printData("Transportzug wurde erstellt!");
    }

    //Setter & Getter
    public void setHochgeschwindigkeitszug(ArrayList<HochgeschwindigkeitsZug> hochgeschwindigkeitszug) {
        this.hochgeschwindigkeitszug = hochgeschwindigkeitszug;
    }
    public void setMc(MainController mc) {
        this.mc = mc;
    }
    public void setFormat(DateFormat format) {
        this.format = format;
    }
    public void setStandardPersonenzug(ArrayList<StandardPersonenZug> standardpersonenzug) {
        this.standardpersonenzug = standardpersonenzug;
    }
    public void setReinelektrischzug(ArrayList<ReinelektrischZug> reinelektrischzug) {
        this.reinelektrischzug = reinelektrischzug;
    }
    public void setTransportzug(ArrayList<TransportZug> transportzug) {
        this.transportzug = transportzug;
    }
    public void setZug(ArrayList<Zug> zug) {
        this.zug = zug;
    }
    public ArrayList<HochgeschwindigkeitsZug> getHochgeschwindigkeitszug() {
        return hochgeschwindigkeitszug;
    }
    public MainController getMc() {
        return mc;
    }
    public DateFormat getFormat() {
        return format;
    }
    public ArrayList<StandardPersonenZug> getStandardPersonenzug() {
        return standardpersonenzug;
    }
    public ArrayList<ReinelektrischZug> getReinelektrischzug() {
        return reinelektrischzug;
    }
    public ArrayList<TransportZug> getTransportzug() {
        return transportzug;
    }
    public ArrayList<Zug> getZug() {
        return zug;
    }
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
    public Scanner getScanner() {
        return scanner;
    }



}
