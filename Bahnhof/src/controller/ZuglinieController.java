//Jordan
package controller;
import model.*;
import java.util.ArrayList;
import java.util.Locale;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import view.*;

public class ZuglinieController {
    MainController mc;
    Output o = new Output();
    ArrayList<Zuglinie> zuglinie = new ArrayList<Zuglinie>();
    DateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN);

    public ZuglinieController(MainController mc){
        setMc(mc);
        setZuglinie(zuglinie);
    }


    public void createDemoDaten() throws ParseException{
        //Zuglinie 1 Hamburg Berlin
        ArrayList<Personal> personalkombination1 = new ArrayList<Personal>();
        personalkombination1.add(getMc().getPc().getPersonal().get(0));
        personalkombination1.add(getMc().getPc().getPersonal().get(1));
        ArrayList<Bahnhof> bahnhofkombination1 = new ArrayList<Bahnhof>();
        //Hamburg
        bahnhofkombination1.add(getMc().getBc().getBahnhoefe().get(0));
        //Berlin
        bahnhofkombination1.add(getMc().getBc().getBahnhoefe().get(1));
        Zuglinie z1 = new Zuglinie(1, getMc().getZc().getHochgeschwindigkeitszug().get(0), getMc().getPc().getLokfuehrer().get(0), personalkombination1, bahnhofkombination1, format.parse("12.02.2022"));
        zuglinie.add(z1);

        //Zuglinie 2 Hamburg Frankfurt
        ArrayList<Personal> personalkombination2 = new ArrayList<Personal>();
        personalkombination2.add(getMc().getPc().getPersonal().get(0));
        personalkombination2.add(getMc().getPc().getPersonal().get(1));
        personalkombination2.add(getMc().getPc().getPersonal().get(2));
        ArrayList<Bahnhof> bahnhofkombination2 = new ArrayList<Bahnhof>();
        //Hamburg
        bahnhofkombination2.add(getMc().getBc().getBahnhoefe().get(0));
        //Frankfurt
        bahnhofkombination2.add(getMc().getBc().getBahnhoefe().get(2));
        Zuglinie z2 = new Zuglinie(1, getMc().getZc().getHochgeschwindigkeitszug().get(1), getMc().getPc().getLokfuehrer().get(1), personalkombination1, bahnhofkombination1, format.parse("13.02.2022"));
        zuglinie.add(z2);
    }

    public void checkLokfuehrerQualifikationReinelektrisch(){
        for(Zuglinie zuglinie : zuglinie){
            if((!zuglinie.getLokfuehrer().getQualifikation().contains("reinelektrisch")) && zuglinie.getZug().getClass().getName() == "model.ReinelektrischZug"){
                o.printData("Der Lokführer " + zuglinie.getLokfuehrer().getVorname() + " " + zuglinie.getLokfuehrer().getNachname() + " ist nicht qualifiziert, den reinelektrischen Zug " + zuglinie.getZug().getBetreiber() + " " + zuglinie.getZug().getModell() + " zu führen.");
            }
            else if((zuglinie.getLokfuehrer().getQualifikation().contains("reinelektrisch")) && zuglinie.getZug().getClass().getName() == "model.ReinelektrischZug"){
                o.printData("Der Lokführer " + zuglinie.getLokfuehrer().getVorname() + " " + zuglinie.getLokfuehrer().getNachname() + " ist qualifiziert, den reinelektrischen Zug " + zuglinie.getZug().getBetreiber() + " " + zuglinie.getZug().getModell() + " zu führen.");
            }
            else{
                break;
            }
        }
    }

    public void checkLokfuehrerQualifikationStandardPerson(){
        for(Zuglinie zuglinie : zuglinie){
            if((!zuglinie.getLokfuehrer().getQualifikation().contains("standardperson")) && zuglinie.getZug().getClass().getName() == "model.StandardPersonenZug"){
                o.printData("Der Lokführer " + zuglinie.getLokfuehrer().getVorname() + " " + zuglinie.getLokfuehrer().getNachname() + " ist nicht qualifiziert, den Personenzug " + zuglinie.getZug().getBetreiber() + " " + zuglinie.getZug().getModell() + " zu führen.");
            }
            else if((zuglinie.getLokfuehrer().getQualifikation().contains("standardperson")) && zuglinie.getZug().getClass().getName() == "model.StandardPersonenZug"){
                o.printData("Der Lokführer " + zuglinie.getLokfuehrer().getVorname() + " " + zuglinie.getLokfuehrer().getNachname() + " ist qualifiziert, den Personenzug " + zuglinie.getZug().getBetreiber() + " " + zuglinie.getZug().getModell() + " zu führen.");
            }
            else{
                break;
            }
        }
    }

    public void checkLokfuehrerQualifikationHochgeschwindigkeit(){
        for(Zuglinie zuglinie : zuglinie){
            if((!zuglinie.getLokfuehrer().getQualifikation().contains("hochgeschwindigkeit")) && zuglinie.getZug().getClass().getName() == "model.HochgeschwindigkeitsZug"){
                o.printData("Der Lokführer " + zuglinie.getLokfuehrer().getVorname() + " " + zuglinie.getLokfuehrer().getNachname() + " ist nicht qualifiziert, den Hochgeschwindigkeitszug " + zuglinie.getZug().getBetreiber() + " " + zuglinie.getZug().getModell() + " zu führen.");
            }
            else if((zuglinie.getLokfuehrer().getQualifikation().contains("hochgeschwindigkeit")) && zuglinie.getZug().getClass().getName() == "model.HochgeschwindigkeitsZug"){
                o.printData("Der Lokführer " + zuglinie.getLokfuehrer().getVorname() + " " + zuglinie.getLokfuehrer().getNachname() + " ist qualifiziert, den Hochgeschwindigkeitszug " + zuglinie.getZug().getBetreiber() + " " + zuglinie.getZug().getModell() + " zu führen.");
            }
            else{
                break;
            }
        }
    }

    public void checkLokfuehrerQualifikationTransport(){
        for(Zuglinie zuglinie : zuglinie){
            if((!zuglinie.getLokfuehrer().getQualifikation().contains("transport")) && zuglinie.getZug().getClass().getName() == "model.TransportZug"){
                o.printData("Der Lokführer " + zuglinie.getLokfuehrer().getVorname() + " " + zuglinie.getLokfuehrer().getNachname() + " ist nicht qualifiziert, den Transportzug " + zuglinie.getZug().getBetreiber() + " " + zuglinie.getZug().getModell() + " zu führen.");
            }
            else if((zuglinie.getLokfuehrer().getQualifikation().contains("transport")) && zuglinie.getZug().getClass().getName() == "model.TransportZug"){
                o.printData("Der Lokführer " + zuglinie.getLokfuehrer().getVorname() + " " + zuglinie.getLokfuehrer().getNachname() + " ist qualifiziert, den Transportzug " + zuglinie.getZug().getBetreiber() + " " + zuglinie.getZug().getModell() + " zu führen.");
            }
            else{
                break;
            }
        }
    }



    //Setter & Getter
    public void setMc(MainController mc) {
        this.mc = mc;
    }
    public void setFormat(DateFormat format) {
        this.format = format;
    }
    public void setZuglinie(ArrayList<Zuglinie> zuglinie) {
        this.zuglinie = zuglinie;
    }
    public MainController getMc() {
        return mc;
    }
    public DateFormat getFormat() {
        return format;
    }
    public ArrayList<Zuglinie> getZuglinie() {
        return zuglinie;
    }

    
}

    //Lehrerqualifikation prüfen
    //Optionen: reinelektrisch, standardperson, hochgeschwindigkeit, transport
    /*
    public void checkLokfuehrerQualifikation(){
        for(Zuglinie zuglinie : zuglinie){
            if((zuglinie.getLokfuehrer().getQualifikation().contains("reinelektrisch")) && zuglinie.getZug().getClass().getName() == "model.ReinelektrischZug"){
                o.printData("Der Lokführer " + zuglinie.getLokfuehrer().getVorname() + " " + zuglinie.getLokfuehrer().getNachname() + " ist qualifiziert, den reinelektrischen Zug " + zuglinie.getZug().getBetreiber() + " " + zuglinie.getZug().getModell() + " zu führen.");
            }
            else if((zuglinie.getLokfuehrer().getQualifikation().contains("standardperson")) && zuglinie.getZug().getClass().getName() == "model.StandardPersonenZug"){
                o.printData("Der Lokführer " + zuglinie.getLokfuehrer().getVorname() + " " + zuglinie.getLokfuehrer().getNachname() + " ist qualifiziert, den Personenzug " + zuglinie.getZug().getBetreiber() + " " + zuglinie.getZug().getModell() + " zu führen."); 
            }
            else if((zuglinie.getLokfuehrer().getQualifikation().contains("hochgeschwindigkeit")) && zuglinie.getZug().getClass().getName() == "model.HochgeschwindigkeitsZug"){
                o.printData("Der Lokführer " + zuglinie.getLokfuehrer().getVorname() + " " + zuglinie.getLokfuehrer().getNachname() + " ist qualifiziert, den Hochgeschwindigkeitszug " + zuglinie.getZug().getBetreiber() + " " + zuglinie.getZug().getModell() + " zu führen.");
            }
            else if((zuglinie.getLokfuehrer().getQualifikation().contains("transport")) && zuglinie.getZug().getClass().getName() == "model.TransportZug"){
                o.printData("Der Lokführer " + zuglinie.getLokfuehrer().getVorname() + " " + zuglinie.getLokfuehrer().getNachname() + " ist qualifiziert, den Transportzug " + zuglinie.getZug().getBetreiber() + " " + zuglinie.getZug().getModell() + " zu führen.");
            }
            else{
                o.printData("Der Lokführer " + zuglinie.getLokfuehrer().getVorname() + " " + zuglinie.getLokfuehrer().getNachname() + " ist nicht qualifiziert den Zug " + zuglinie.getZug().getBetreiber() + " " + zuglinie.getZug().getModell() + " zu führen."); 
            }
        }
    }
    */
