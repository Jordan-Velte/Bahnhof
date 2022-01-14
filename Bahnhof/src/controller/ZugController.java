package controller;
import model.*;
import java.util.ArrayList;
//Mehrere Imports für Datum/Standort!
import java.util.Locale;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ZugController {
    MainController mc;
    ArrayList<Zug> zug;
    ArrayList<HochgeschwindigkeitsZug> hochgeschwindigkeitszug;
    ArrayList<TransportZug> transportzug;
    ArrayList<ReinelektrischZug> reinelektrischzug;
    ArrayList<StandardPersonenZug> standardpersonenzug;
    //Formatfestlegung für die Datumsvariablen. Das Datum orientiert sich an dem deutschen Standard --> Per Punktnotation an jener Instanz können nun über die parse-Methode Strings übergeben werden, welche sich an diesem definierten Datumsformat orientieren.
    DateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN);

    public ZugController(MainController mc){
        zug = new ArrayList<Zug>();
        hochgeschwindigkeitszug = new ArrayList<HochgeschwindigkeitsZug>();
        transportzug = new ArrayList<TransportZug>();
        reinelektrischzug = new ArrayList<ReinelektrischZug>();
        standardpersonenzug = new ArrayList<StandardPersonenZug>();
    }

    public void createDemoDaten() throws ParseException{
        HochgeschwindigkeitsZug hz1 = new HochgeschwindigkeitsZug("Shinkansen 300X", "Central Japan Railway Company", 350, 6, format.parse("01.02.1992"), 20000000);
        HochgeschwindigkeitsZug hz2 = new HochgeschwindigkeitsZug("ICE 3", "Deutsche Bahn", 300, 8, format.parse("09.07.1999"), 33000000);
        StandardPersonenZug spz1 = new StandardPersonenZug("Intercity 1", "Deutsche Bahn", 200, 8, format.parse("26.09.1971"), 703);
        StandardPersonenZug spz2 = new StandardPersonenZug("Alstom Coradia Continental", "Deutsche Bahn", 160, 4, format.parse("01.12.2008"), 450);
        TransportZug tz1 = new TransportZug("Bombardier Traxx F140 AC1", "Deutsche Bahn Cargo", 150, 30, format.parse("01.01.2000"), true, "normal", 84000);
        TransportZug tz2 = new TransportZug("Bombardier Traxx P160 DE ME", "Deutsche Bahn Cargo", 160, 30, format.parse("13.12.2013"), true, "normal", 81000);
        //Reinelektrischzüge werden noch implementiert --> Problem mit Model-Klasse!
        //Reinelektrisch rz1: Siemens ACS-64, Amtrak, 200, 10, 7. Februar 2014, 4 Drehstrom-Asynchronmotoren, 30
        //Reinelektrisch rz2: Bombardier ALP-46, New Jersey Transit, 200, 10, 1. Dezember 1999, 4 Drehstrom-Asynchronmotoren, 30
        /*
        String modell, String betreiber, double durchschnittsgeschwindigkeit, int wagonzahl, Date zulassungsdatum, String energieversorgung, double batterielebensdauerinjahren
        */
        hochgeschwindigkeitszug.add(hz1);
        hochgeschwindigkeitszug.add(hz2);
        standardpersonenzug.add(spz1);
        standardpersonenzug.add(spz2);
        transportzug.add(tz1);
        transportzug.add(tz2);
        zug.add(hz1);
        zug.add(hz2);
        zug.add(spz1);
        zug.add(spz1);
        zug.add(tz1);
        zug.add(tz2);

       
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


}
