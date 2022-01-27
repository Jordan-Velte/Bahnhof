//JORDAN, LENNARD
//IMPORTS
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
//--> Controller als Schnitstelle zwischen model und view! (siehe Import)

public class ZuglinieController {
    //VARIABLENDEKLARATION
    MainController mc;
    //Output-Instanz --> Zugriff auf printData-Methodik über Punktnotation
    Output o = new Output();
    ArrayList<Zuglinie> zuglinie;
    DateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN);
    //Notwendig für Interaktion mit dem Terminal (siehe create-Methode)
    Scanner scanner;

    //CONSTRUCTOR
    //Übergabe des MainControllers --> Über Punktnotation somit Zugriff auf andere Klassen!
    public ZuglinieController(MainController mc){
        setMc(mc);
        setZuglinie(zuglinie);
        zuglinie = new ArrayList<Zuglinie>();
        //Setter für den Scanner, notwendig für Eingabe übers Terminal
        this.setScanner(new Scanner(System.in));
    }

    //DEMODATEN
    public void createDemoDaten() throws ParseException{
        //Zuglinie 1 Hamburg Berlin
        //ArrayList für Personalkombination erstellen
        ArrayList<Personal> personalkombination1 = new ArrayList<Personal>();
        //Über Getter-Punktnotation (siehe MainController), einzelne Elemente des Personal-Arrays hinzufügen --> Punktnotation im Rahmen der add-Methodik!
        personalkombination1.add(getMc().getPc().getPersonal().get(0));
        //Zwei Elemente werden hinzugefügt, weil mehrere Stopps auf der Zuglinie
        personalkombination1.add(getMc().getPc().getPersonal().get(1));
        //ArrayList für Bahnhofkombination erstellen
        ArrayList<Bahnhof> bahnhofkombination1 = new ArrayList<Bahnhof>();
        //Hamburg
        //Über Getter-Punktnotation (siehe MainController), einzelne Elemente des Bahnhof-Arrays hinzufügen --> Punktnotation im Rahmen der add-Methodik!
        bahnhofkombination1.add(getMc().getBc().getBahnhoefe().get(0));
        //Berlin
        bahnhofkombination1.add(getMc().getBc().getBahnhoefe().get(1));
        //Instanzerstellung (Initialisierung der Variablen): Lokführer wird zusätzlich über die erwähnte MainController-Punktnotation als Parameter übergegeben. Darüber hinaus werden die obig erstellen ArrayLists übergeben. 
        Zuglinie z1 = new Zuglinie(1, getMc().getZc().getHochgeschwindigkeitszug().get(0), getMc().getPc().getLokfuehrer().get(0), personalkombination1, bahnhofkombination1, format.parse("12.02.2022"));
        //Hinzufügen der Demodaten-Instanz in Zuglinien-ArrayList
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

    //DATENEINGABE-METHODE ZUGLINIE
    public void createZuglinie() throws ParseException{
        o.printData("Zugline erstellen");
        //Zugliniennummer
        o.printData("Zugliniennummer: ");
        //Erfassung des im Terminal eingegebenen Strings über Getter des Scanners
        String zugliniennummer_string = getScanner().nextLine();
        //Umwandlung des Strings in Integer
        int zugliniennummer = Integer.valueOf(zugliniennummer_string);
        o.printData("Zug: ");
        //Auswahl eines Zuges durch For-Each-Schleife: Der Index i1 iteriert hierbei die Elemente der ArrayList durch (erneut MainController-Punktnotation --> deshalb ist eine Übergabe des MainControllers im Constructor der Controller-Klasse essenziell)
        int i1 = 0;
        for(Zug zug : getMc().getZc().getZug()){
            //Ausgabe der einzelnen Elemente der ArrayList --> Per Punktnotation (Getter) werden hierbei die jeweiligen Initialisierungen der Klassenvariablen aufgerufen
            o.printData(i1 + " - " + zug.getModell() + " " + zug.getBetreiber());
            //Index wird bei jedem Durchlauf um 1 erhöht
            i1++;
        }
        String zugchoice = getScanner().nextLine();
        int zugindex = Integer.valueOf(zugchoice);
        //Der in einen int umgewandelte Zugindex kann nun bei der Instanzerstellung für einen neuen Zug berücksichtigt werden. Somit wird das entsprechende Elemente in der ArrayList ausgwählt.
        Zug zugliniezug = getMc().getZc().getZug().get(zugindex);
        //Lokführer
        o.printData("Lokführer: ");
        int i2 = 0;
        for(Lokfuehrer lokfuehrer : getMc().getPc().getLokfuehrer()){
            o.printData(i2 + " - " + lokfuehrer.getVorname() + " " + lokfuehrer.getNachname());
            i2++;
        }
        String lokfuehrerchoice = getScanner().nextLine();
        int lokfuehrerindex = Integer.valueOf(lokfuehrerchoice);
        Lokfuehrer zuglinielokfuehrer = getMc().getPc().getLokfuehrer().get(lokfuehrerindex);
        //Personal
        o.printData("Personal (abbruch: nein): ");
        int i3=0;
        //For-Each-Schleife für das gesamte Personal
        for(Personal personal : getMc().getPc().getPersonal()){
            if(personal!=null){
                o.printData(i3 + " - " + personal.getVorname() + " " + personal.getNachname());
                i3++;
            }
        }
        String personalchoice_string = getScanner().nextLine();
        int personalchoice = Integer.valueOf(personalchoice_string);
        //Erstellung einer ArrayList für Instanzen der Personalklasse
        ArrayList<Personal> personalal = new ArrayList<Personal>();
        //Hinzufügen der entsprechenden neuen Instanz in die ArrayList über Punktnotation --> Index erneut übergeben für das respektive Element der ArrayList
        personalal.add(getMc().getPc().getPersonal().get(personalchoice));
        //Sollen weitere Personal-Instanzen der ArrayList hinzugefügt werden?
        o.printData("Weiteres Personal (ja/nein)?");
        String weiterfrage = getScanner().nextLine();
        //Wenn Wert ja: Ablauf wiederholt sich in while-Schleife! --> es werden immer mehr Elemente der ArrayList über obigen Prozess hinzugefügt
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
        //Wenn Wert nein: keine Elemente werden der Personal-ArrayLists mehr hinzugefügt
        while(weiterfrage.equals("nein")){
            //Gleicher Prozess wiederum für Bahnhöfe, da ebenfalls eine ArrayList von Bahnhöfen bei der Instanzerstellung einer Zuglinie übergeben wird!
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
            //While-Schleife nicht unbedingt notwendig (siehe oben), aber trotzdem legitime Möglichkeit! --> Hier Entscheidung von uns: If-Bedingung (gleiches Prinzip)
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
            //Wenn die Weiterfrage2 (für Bahnhöfe) ebenfalls mit nein beantwortet wird, so ist nun letztlich noch das Fahrtdatum relevant
            if(weiterfrage2.equals("nein")){
                o.printData("Fahrtdatum: ");
                String zugliniefahrtdatum_string = getScanner().nextLine();
                //Datumsfeld --> parse-Parameterübergabe des Strings notwendig für das obig definierten Format (Punktnotation)
                Date zugliniefahrtdatum = format.parse(zugliniefahrtdatum_string);
                //Instanzerstellung einer neuen Zuglinie
                Zuglinie newzuglinie = new Zuglinie(zugliniennummer, zugliniezug, zuglinielokfuehrer, personalal, bahnhofal, zugliniefahrtdatum);
                zuglinie.add(newzuglinie);
                o.printData("Zugline wurde erstellt!");
                //Break: Stopp
                break;
            }
            
            }


    }

    //DATENAUSGABE-METHODE Zuglinie
    public void printOutZuglinie(){
        //Über For-Each-Schleife: Iterierung der einzelnen Elemente der ArrayList --> Punktnotation an der Output-Klasse ermöglicht Zugriff auf print-Data Methode (Ausgabe im Terminal). Ebenfalls durch Punktnotation wird an der zuglinie-Instanz die entsprechenden Getter für die Klassenvariablen aufgerufen (initialisierte Werte)
        for(Zuglinie zuglinie : zuglinie){
            //Sofern Instanz zuglinie nicht null ist: 
            if(zuglinie!=null){
                o.printData("Zugliniennummer: " + zuglinie.getZugliniennummer() + "; Zug: " + zuglinie.getZug().getBetreiber() + " " + zuglinie.getZug().getModell() + "; Abfahrt: " + zuglinie.getBahnhof().get(0).getName()+ "; Ankunft: " + zuglinie.getBahnhof().get(zuglinie.getBahnhof().size()-1).getName() + "; Datum: "  + zuglinie.getFahrtDatum());
            }
        }
    }

    //Überprüfung der Qualifikation der Lokführer: Reinelektrischer Zug
    public void checkLokfuehrerQualifikationReinelektrisch(){
        //For-Each-Schleife für alle Zuglinien in der ArrayList
        for(Zuglinie zuglinie : zuglinie){
            //Sofern Lokführer nicht die Qualifikation für reinelektrische Züge besitzt UND der Zug aber ein reinelektrischer Zug ist (siehe Model-Klassenname), so ist der Lokführer nicht qualifiziert diesen Zug zu fahren!
            if((!zuglinie.getLokfuehrer().getQualifikation().contains("reinelektrisch")) && zuglinie.getZug().getClass().getName() == "model.ReinelektrischZug"){
                o.printData("Der Lokführer " + zuglinie.getLokfuehrer().getVorname() + " " + zuglinie.getLokfuehrer().getNachname() + " ist nicht qualifiziert, den reinelektrischen Zug " + zuglinie.getZug().getBetreiber() + " " + zuglinie.getZug().getModell() + " zu führen.");
            }
            //Besitzt der Lokführer jedoch die Qualifikation für reinelektrische Züge (siehe Punktnotation an Arraylist für "besitzt" reinelektrisch) UND handelt es sich um einen reinelektrischen Zug, dann ist der Lehrer qualifiziert diesen Zug zu fahren --> seine Qualifikation für diesen Zug ist in der ArrayList gegeben
            else if((zuglinie.getLokfuehrer().getQualifikation().contains("reinelektrisch")) && zuglinie.getZug().getClass().getName() == "model.ReinelektrischZug"){
                o.printData("Der Lokführer " + zuglinie.getLokfuehrer().getVorname() + " " + zuglinie.getLokfuehrer().getNachname() + " ist qualifiziert, den reinelektrischen Zug " + zuglinie.getZug().getBetreiber() + " " + zuglinie.getZug().getModell() + " zu führen.");
            }
            else{
                break;
            }
        }
    }

    //Überprüfung der Qualifikation der Lokführer: Standardpersonenzug
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
    
    //Überprüfung der Qualifikation der Lokführer: Hochgeschwindigkeitszug
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

    //Überprüfung der Qualifikation der Lokführer: Transportzug
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



    //Setter und Getter
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

//CODE GRAVEYARD
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