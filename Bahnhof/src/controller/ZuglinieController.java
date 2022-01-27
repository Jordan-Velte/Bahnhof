//Jordan
package controller;
import model.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import view.*;

public class ZuglinieController {
    MainController mc;
    Output o = new Output();
    ArrayList<Zuglinie> zuglinie;
    DateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN);
    Scanner scanner;

    public ZuglinieController(MainController mc){
        setMc(mc);
        setZuglinie(zuglinie);
        zuglinie = new ArrayList<Zuglinie>();
        this.setScanner(new Scanner(System.in));
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
        bahnhofkombination2.add(getMc().getBc().getBahnhoefe().get(3));
        Zuglinie z2 = new Zuglinie(1, getMc().getZc().getHochgeschwindigkeitszug().get(1), getMc().getPc().getLokfuehrer().get(1), personalkombination1, bahnhofkombination2, format.parse("13.02.2022"));
        zuglinie.add(z2);
    }

    //createZuglinie
    public void createZuglinie() throws ParseException{
        o.printData("Zugline erstellen");
        o.printData("Zugliniennummer: ");
        String zugliniennummer_string = getScanner().nextLine();
        int zugliniennummer = Integer.valueOf(zugliniennummer_string);
        o.printData("Zug: ");
        int i1 = 0;
        for(Zug zug : getMc().getZc().getZug()){
            o.printData(i1 + " - " + zug.getModell() + " " + zug.getBetreiber());
            i1++;
        }
        String zugchoice = getScanner().nextLine();
        int zugindex = Integer.valueOf(zugchoice);
        Zug zugliniezug = getMc().getZc().getZug().get(zugindex);
        o.printData("Lokführer: ");
        int i2 = 0;
        for(Lokfuehrer lokfuehrer : getMc().getPc().getLokfuehrer()){
            o.printData(i2 + " - " + lokfuehrer.getVorname() + " " + lokfuehrer.getNachname());
            i2++;
        }
        String lokfuehrerchoice = getScanner().nextLine();
        int lokfuehrerindex = Integer.valueOf(lokfuehrerchoice);
        Lokfuehrer zuglinielokfuehrer = getMc().getPc().getLokfuehrer().get(lokfuehrerindex);

        o.printData("Personal (abbruch: nein): ");
        int i3=0;
        for(Personal personal : getMc().getPc().getPersonal()){
            if(personal!=null){
                o.printData(i3 + " - " + personal.getVorname() + " " + personal.getNachname());
                i3++;
            }
        }
        String personalchoice_string = getScanner().nextLine();
        int personalchoice = Integer.valueOf(personalchoice_string);
        ArrayList<Personal> personalal = new ArrayList<Personal>();
        personalal.add(getMc().getPc().getPersonal().get(personalchoice));
        o.printData("Weiteres Personal (ja/nein)?");
        String weiterfrage = getScanner().nextLine();

        while(weiterfrage.equals("ja")){
            int i4 = 0;
            for(Personal personal : getMc().getPc().getPersonal()){
                if(personal!=null){
                    o.printData(i4 + " - " + personal.getVorname() + " " + personal.getNachname());
                }
                i4++;
            }
            String personalchoice_string_al = getScanner().nextLine();
            int personalindex_al = Integer.valueOf(personalchoice_string_al);
            personalal.add(getMc().getPc().getPersonal().get(personalindex_al));
            o.printData("Weiteres Personal (ja/nein)?");
            weiterfrage = getScanner().nextLine();
        }

        while(weiterfrage.equals("nein")){
            o.printData("Bahnhöfe (abbruch: nein): ");
            int i5=0;
            for(Bahnhof bahnhof : getMc().getBc().getBahnhoefe()){
                if(bahnhof!=null){
                    o.printData(i5 + " - " + bahnhof.getName() + " " + bahnhof.getStandort());
                    i5++;
                }
            }
            String bahnhofchoice_string = getScanner().nextLine();
            int bahnhofchoice = Integer.valueOf(bahnhofchoice_string);
            ArrayList<Bahnhof> bahnhofal = new ArrayList<Bahnhof>();
            bahnhofal.add(getMc().getBc().getBahnhoefe().get(bahnhofchoice));
            o.printData("Weitere Bahnhöfe (ja/nein)?");
            String weiterfrage2 = getScanner().nextLine();
            if(weiterfrage2.equals("ja")){
                int i6 = 0;
                for(Bahnhof bahnhof : getMc().getBc().getBahnhoefe()){
                    if(bahnhof!=null){
                        o.printData(i6+ " - " + bahnhof.getName() + " " + bahnhof.getStandort());
                    }
                    i6++;
                }
                String bahnhofchoice_string_al = getScanner().nextLine();
                int bahnhofindex_al = Integer.valueOf(bahnhofchoice_string_al);
                bahnhofal.add(getMc().getBc().getBahnhoefe().get(bahnhofindex_al));
                o.printData("Weitere Bahnhöfe (ja/nein)?");
                weiterfrage2 = getScanner().nextLine();
            }
            if(weiterfrage2.equals("nein")){
                o.printData("Fahrtdatum: ");
                String zugliniefahrtdatum_string = getScanner().nextLine();
                Date zugliniefahrtdatum = format.parse(zugliniefahrtdatum_string);
                Zuglinie newzuglinie = new Zuglinie(zugliniennummer, zugliniezug, zuglinielokfuehrer, personalal, bahnhofal, zugliniefahrtdatum);
                zuglinie.add(newzuglinie);
                o.printData("Zugline wurde erstellt!");
                break;
            }
            
            }
            /*
            o.printData("Bahnhöfe (wenn fertig: abbruch): ");
            int i5=0;
            for(Bahnhof bahnhof : getMc().getBc().getBahnhoefe()){
                if(bahnhof!=null){
                    o.printData(i5 + " - " + bahnhof.getName() + " " + bahnhof.getStandort());
                    i5++;
                }
            }
            String bahnhofchoice_string = getScanner().nextLine();
            int bahnhofchoice = Integer.valueOf(bahnhofchoice_string);
            ArrayList<Bahnhof> bahnhofal = new ArrayList<Bahnhof>();
            bahnhofal.add(getMc().getBc().getBahnhoefe().get(bahnhofchoice));
            while(bahnhofchoice_string!="abbruch"){
                int i6 = 0;
                for(Bahnhof bahnhof : getMc().getBc().getBahnhoefe()){
                    if(bahnhof!=null){
                        o.printData(i6+ " - " + bahnhof.getName() + " " + bahnhof.getStandort());
                    }
                    i6++;
                }
                String bahnhofchoice_string_al = getScanner().nextLine();
                int bahnhofindex_al = Integer.valueOf(bahnhofchoice_string_al);
                bahnhofal.add(getMc().getBc().getBahnhoefe().get(bahnhofindex_al));
            }
            if(bahnhofchoice_string=="abbruch"){
                o.printData("Fahrtdatum: ");
                String zugliniefahrtdatum_string = getScanner().nextLine();
                Date zugliniefahrtdatum = format.parse(zugliniefahrtdatum_string);
                Zuglinie newzuglinie = new Zuglinie(zugliniennummer, zugliniezug, zuglinielokfuehrer, personalal, bahnhofal, zugliniefahrtdatum);
                zuglinie.add(newzuglinie);
                o.printData("Zugline wurde erstellt!");
            } 
            */

    }

    //PrintoutZuglinien
    public void printOutZuglinie(){
        for(Zuglinie zuglinie : zuglinie){
            if(zuglinie!=null){
                o.printData("Zugliniennummer: " + zuglinie.getZugliniennummer() + "; Zug: " + zuglinie.getZug().getBetreiber() + " " + zuglinie.getZug().getModell() + "; Abfahrt: " + zuglinie.getBahnhof().get(0).getName()+ "; Ankunft: " + zuglinie.getBahnhof().get(zuglinie.getBahnhof().size()-1).getName() + "; Datum: "  + zuglinie.getFahrtDatum());
            }
        }
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
