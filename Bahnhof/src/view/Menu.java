//JORDAN
package view;
//IMPORTS
import java.text.ParseException;
import java.util.Scanner;
import controller.*;
public class Menu {
    //Scanner: Relevant für Interaktion mit dem Terminal
    Scanner scanner;
    //Output-Instanz --> Per Punktnotation printData-Methode (Ausgabemethode) aufrufen 
    Output o = new Output();
    //MainController für Parameterübergabe im Menu!
    MainController mc;

    public Menu(MainController mc){
        //MainController wird dem Menu übergeben --> Zugriff auf klassenspezifische Klassen-Controller + Methoden!
        this.setMc(mc);
        //Setter für den Scanner, notwendig für Eingabe übers Terminal
        this.setScanner(new Scanner(System.in));

    }

    //Menu-Methode
    public void startMenu() throws ParseException{
        //EINLEITUNGSMENU
        o.printData("(1) Dateneingabe");
        o.printData("(2) Datenausgabe");
        o.printData("(3) Weitere Optionen");
        String initchoice = getScanner().nextLine();
        o.printData("Ihre Auswahl ist: " + initchoice);
        //DATENEINGABE, wenn Eingabe im Terminal (initchoice) gleich 1
        if(initchoice.equals("1")){
            o.printData("Wählen Sie die Instanzen, die Sie eingeben möchten: ");
            //Untermenu: Dateneingabe
            o.printData("(1) Bahnhöfe");
            o.printData("(2) Züge");
            o.printData("(3) Personen");
            o.printData("(4) Zuglinien");
            o.printData("(5) Buchungen");
            String eingabechoice = getScanner().nextLine();
            o.printData("Ihre Auswahl ist: " + eingabechoice);
            if(eingabechoice.equals("1")){
                //Dateineingabe Bahnhof --> Per Punktnotation über MainController (siehe obige Parameterübergabe im Menu-Constructor). Somit kann auf die klassenspezifischen Controller (natürlich inklusive Methoden, Variablen etc.) zugegriffen werden
                getMc().getBc().createBahnhof();
            }
            else if(eingabechoice.equals("2")){
                //Dateneingabe: Zug-Subklassen
                o.printData("Wählen Sie die Instanzen, die Sie ausgeben möchten:");
                o.printData("(1) Reinelektrische Züge");
                o.printData("(2) Hochgeschwindigkeitszüge");
                o.printData("(3) Standardpersonenzüge");
                o.printData("(4) Transportzüge");
                String zugeingabechoice = getScanner().nextLine();
                o.printData("Ihre Auswahl ist: " + zugeingabechoice);
                //Switch-Case: Dateningabe für Zug-Subklassen entsprechend der Nummerierung
                switch(zugeingabechoice){
                    //Wenn zugeingabechoice gleich 1: Methode, um reinelektrischen Zug zu erstellen, wird aufgerufen, usw.  
                    case "1": getMc().getZc().createReinelektrischZuege();
                    break;
                    case "2": getMc().getZc().createHochgeschwindigkeitsZuege();
                    break;
                    case "3": getMc().getZc().createStandardpersonenZuege();
                    break;
                    case "4": getMc().getZc().createTransportZuege();
                }
            }
            else if(eingabechoice.equals("3")){
                //Dateneingabe: Person-Subklassen
                o.printData("Wählen Sie die Instanzen, die Sie ausgeben möchten:");
                o.printData("(1) Lokführer");
                o.printData("(2) Personal");
                o.printData("(3) Passagiere");
                String personeingabechoice = getScanner().nextLine();
                o.printData("Ihre Auswahl ist: " + personeingabechoice);
                //Switch-Case: Dateningabe für Zug-Subklassen entsprechend der Nummerierung
                switch(personeingabechoice){
                    //Wenn personeingabechoice gleich 1: Methode, um Lokführer zu erstellen, wird aufgerufen, usw.  
                    case "1": getMc().getPc().createLokfuehrer();
                    break;
                    case "2": getMc().getPc().createPersonal();
                    break;
                    case "3": getMc().getPc().createPassagier();
                } 
            }
            //Dateneingabe: Zuglinie
            else if(eingabechoice.equals("4")){
                getMc().getZlc().createZuglinie();
            } 
            else if(eingabechoice.equals("5")){
                getMc().getBuc().createBuchung();
            }
        }
        //DATENAUSGABE, wenn Eingabe im Terminal (initchoice) gleich 2
        else if(initchoice.equals("2")){
            //Untermenu: Datenausgabe
            o.printData("Wählen Sie die Instanzen, die Sie ausgeben möchten:");
            o.printData("(1) Bahnhöfe");
            o.printData("(2) Züge");
            o.printData("(3) Personen");
            o.printData("(4) Zuglinien");
            o.printData("(5) Buchungen");
            String ausgabechoice = getScanner().nextLine();
            o.printData("Ihre Auswahl ist: " + ausgabechoice);
            //Ausgabemethode: Bahnhof
            if(ausgabechoice.equals("1")){
                getMc().getBc().printOutBahnhof();
            }
            else if(ausgabechoice.equals("2")){
                //Datenausgabe: Zug-Subklassen
                o.printData("Wählen Sie die Instanzen, die Sie ausgeben möchten:");
                o.printData("(1) Reinelektrische Züge");
                o.printData("(2) Hochgeschwindigkeitszüge");
                o.printData("(3) Standardpersonenzüge");
                o.printData("(4) Transportzüge");
                o.printData("(5) Alle dokumentierten Züge des Zugnetzwerkes");
                String zugchoice = getScanner().nextLine();
                o.printData("Ihre Auswahl ist " + zugchoice);
                //Switch Case für Ausgabemethoden der Zug-Subklassen
                switch (zugchoice){
                    case "1" : getMc().getZc().printOutReinelektrischZuege();
                    break;
                    case "2" : getMc().getZc().printOutHochgeschwindigkeitsZuege();
                    break;
                    case "3" : getMc().getZc().printOutStandardPersonenZuege();
                    break;
                    case "4" : getMc().getZc().printOutTransportZuege();
                    break;
                }
            }
            else if(ausgabechoice.equals("3")){
                //Datenausgabe: Person-Subklassen
                o.printData("Wählen Sie die Instanzen, die Sie ausgeben möchten:");
                o.printData("(1) Lokführer");
                o.printData("(2) Personal");
                o.printData("(3) Passagiere");
                o.printData("(4) Alle dokumentierten Stakeholder des Zugnetzwerkes");
                String personchoice = getScanner().nextLine();
                o.printData("Ihre Auswahl ist: " + personchoice);
                //Switch Case für Ausgabemethoden der Person-Subklassen
                switch(personchoice){
                    case "1": getMc().getPc().printOutLokfuehrer();
                    break;
                    case "2": getMc().getPc().printOutPersonal();
                    break;
                    case "3": getMc().getPc().printOutPassagiere();
                    break;
                    case "4": getMc().getPc().printOutPersonen();
                    break;
                }
            }
            //Datenausgabe Zuglinie
            else if(ausgabechoice.equals("4")){
                getMc().getZlc().printOutZuglinie();
            }
            //Datenausgabe Buchung
            else if(ausgabechoice.equals("5")){
                getMc().getBuc().printOutBuchung();
            }
        }
        //WEITERE OPTIONEN: Überprüfungsmethoden, weitere Checks über klassenspezifische Controller, etc., wenn Eingabe im Terminal (initchoice) gleich 3
        else if(initchoice.equals("3"))
            //Untermenu: Weitere Optionen
            o.printData("Wählen Sie die Instanzen, die Sie überprüfen möchten:");
            o.printData("(1) Bahnhof");
            o.printData("(2) Zuglinie");
            o.printData("(3) Buchung");
            String weitereoptionchoice = getScanner().nextLine();
            o.printData("Ihre Auswahl ist: " + weitereoptionchoice);
            //Segmetierung der Bahnhofsgroesse! --> Bahnhof
            if (weitereoptionchoice.equals("1")){
                o.printData("Segmentierung der Bahnhofsgrösse: ");
                getMc().getBc().checkBahnhofgroesse();
            }
            //Lokführer-Qualifikation auf Zuglinie
            else if(weitereoptionchoice.equals("2")){
                o.printData("Überprüfung der Lokführer-Qualifikation: ");
                getMc().getZlc().checkLokfuehrerQualifikationReinelektrisch();
                getMc().getZlc().checkLokfuehrerQualifikationHochgeschwindigkeit();
                getMc().getZlc().checkLokfuehrerQualifikationStandardPerson();
                getMc().getZlc().checkLokfuehrerQualifikationTransport();
            }
            //Kategorisierung der Buchungspreise
            else if(weitereoptionchoice.equals("3")){
                o.printData("Segmentierung der Buchungspreise: ");
                getMc().getBuc().checkBuchungPreis();
            }
        //Sofern Eingabe nicht 1,2, oder 3: else (d.h. Fehlermeldung)
        else{
            o.printData("Fehlermeldung: Sie haben eine invalide Eingabe getroffen!");
        }
        //Methode wird erneut aufgerufen, wenn If-Bedingungen oder else-Bedingung erfüllt wure!
        startMenu();
    }

    //Setter & Getter
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
    public Scanner getScanner() {
        return scanner;
    }
    public void setMc(MainController mc) {
        this.mc = mc;
    }
    public MainController getMc() {
        return mc;
    }
    public void setO(Output o) {
        this.o = o;
    }
    public Output getO() {
        return o;
    }


}


//CODE GRAVEYARD: 
                /*
                if(personchoice.equals("1")){
                    getMc().getPc().printOutLokfuehrer();
                }
                else if(personchoice.equals("2")){
                    getMc().getPc().printOutPersonal();
                }
                else if(personchoice.equals("3")){
                    getMc().getPc().printOutPassagiere();
                }
                else if(personchoice.equals("4")){
                    getMc().getPc().printOutPersonen();
                }
                */
                                /*
                if(zugchoice.equals("1")){
                    getMc().getZc().printOutReinelektrischZuege();
                }
                else if(zugchoice.equals("2")){
                    getMc().getZc().printOutHochgeschwindigkeitsZuege();
                }
                else if(zugchoice.equals("3")){
                    getMc().getZc().printOutStandardPersonenZuege();
                }
                else if(zugchoice.equals("4")){
                    getMc().getZc().printOutTransportZuege();
                }
                else if(zugchoice.equals("5")){
                    getMc().getZc().printOutZuege();
                }
                */
                /*
                if(personeingabechoice.equals("1")){
                    getMc().getPc().createLokfuehrer();
                }
                else if(personeingabechoice.equals("2")){
                    getMc().getPc().createPersonal();
                }
                else if(personeingabechoice.equals("3")){
                    getMc().getPc().createPassagier();
                }
                */
                                /*
                if(zugeingabechoice.equals("1")){
                    getMc().getZc().createReinelektrischZuege();
                }
                else if(zugeingabechoice.equals("2")){
                    getMc().getZc().createHochgeschwindigkeitsZuege();
                }
                else if(zugeingabechoice.equals("3")){
                    getMc().getZc().createStandardpersonenZuege();
                }
                else if(zugeingabechoice.equals("4")){
                    getMc().getZc().createTransportZuege();
                }
                */