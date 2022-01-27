//Jordan
package view;
import java.text.ParseException;
import java.util.Scanner;
import controller.*;
public class Menu {
    Scanner scanner;
    Output o = new Output();
    MainController mc;

    public Menu(MainController mc){
        this.setMc(mc);
        this.setScanner(new Scanner(System.in));

    }

    //Menu-Methode
    public void startMenu() throws ParseException{
        o.printData("(1) Dateneingabe");
        o.printData("(2) Datenausgabe");
        o.printData("(3) Weitere Optionen");
        String initchoice = getScanner().nextLine();
        o.printData("Ihre Auswahl ist: " + initchoice);
        if(initchoice.equals("1")){
            o.printData("Wählen Sie die Instanzen, die Sie eingeben möchten: ");
            o.printData("(1) Bahnhöfe");
            o.printData("(2) Züge");
            o.printData("(3) Personen");
            o.printData("(4) Zuglinien");
            o.printData("(5) Buchungen");
            String eingabechoice = getScanner().nextLine();
            o.printData("Ihre Auswahl ist: " + eingabechoice);
            if(eingabechoice.equals("1")){
                getMc().getBc().createBahnhof();
            }
            else if(eingabechoice.equals("2")){
                o.printData("Wählen Sie die Instanzen, die Sie ausgeben möchten:");
                o.printData("(1) Reinelektrische Züge");
                o.printData("(2) Hochgeschwindigkeitszüge");
                o.printData("(3) Standardpersonenzüge");
                o.printData("(4) Transportzüge");
                String zugeingabechoice = getScanner().nextLine();
                o.printData("Ihre Auswahl ist: " + zugeingabechoice);
                
                switch(zugeingabechoice){
                    case "1": getMc().getZc().createReinelektrischZuege();
                    break;
                    case "2": getMc().getZc().createHochgeschwindigkeitsZuege();
                    break;
                    case "3": getMc().getZc().createStandardpersonenZuege();
                    break;
                    case "4": getMc().getZc().createTransportZuege();
                }
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
            }
            else if(eingabechoice.equals("3")){
                o.printData("Wählen Sie die Instanzen, die Sie ausgeben möchten:");
                o.printData("(1) Lokführer");
                o.printData("(2) Personal");
                o.printData("(3) Passagiere");
                String personeingabechoice = getScanner().nextLine();
                o.printData("Ihre Auswahl ist: " + personeingabechoice);
                switch(personeingabechoice){
                    case "1": getMc().getPc().createLokfuehrer();
                    break;
                    case "2": getMc().getPc().createPersonal();
                    break;
                    case "3": getMc().getPc().createPassagier();
                }
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
                
            }
            else if(eingabechoice.equals("4")){
                getMc().getZlc().createZuglinie();
            } 
            else if(eingabechoice.equals("5")){
                getMc().getBuc().createBuchung();
            }
        }
        else if(initchoice.equals("2")){
            o.printData("Wählen Sie die Instanzen, die Sie ausgeben möchten:");
            o.printData("(1) Bahnhöfe");
            o.printData("(2) Züge");
            o.printData("(3) Personen");
            o.printData("(4) Zuglinien");
            o.printData("(5) Buchungen");
            String ausgabechoice = getScanner().nextLine();
            o.printData("Ihre Auswahl ist: " + ausgabechoice);
            if(ausgabechoice.equals("1")){
                getMc().getBc().printOutBahnhof();
            }
            else if(ausgabechoice.equals("2")){
                o.printData("Wählen Sie die Instanzen, die Sie ausgeben möchten:");
                o.printData("(1) Reinelektrische Züge");
                o.printData("(2) Hochgeschwindigkeitszüge");
                o.printData("(3) Standardpersonenzüge");
                o.printData("(4) Transportzüge");
                o.printData("(5) Alle dokumentierten Züge des Zugnetzwerkes");
                String zugchoice = getScanner().nextLine();
                o.printData("Ihre Auswahl ist " + zugchoice);
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
            }
            else if(ausgabechoice.equals("3")){
                o.printData("Wählen Sie die Instanzen, die Sie ausgeben möchten:");
                o.printData("(1) Lokführer");
                o.printData("(2) Personal");
                o.printData("(3) Passagiere");
                o.printData("(4) Alle dokumentierten Stakeholder des Zugnetzwerkes");
                String personchoice = getScanner().nextLine();
                o.printData("Ihre Auswahl ist: " + personchoice);
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
            }
            else if(ausgabechoice.equals("4")){
                getMc().getZlc().printOutZuglinie();
            }
            else if(ausgabechoice.equals("5")){
                getMc().getBuc().printOutBuchung();
            }
        }
        else if(initchoice.equals("3"))
            o.printData("Wählen Sie die Instanzen, die Sie überprüfen möchten:");
            o.printData("(1) Bahnhof");
            o.printData("(2) Zuglinie");
            o.printData("(3) Buchung");
            String weitereoptionchoice = getScanner().nextLine();
            o.printData("Ihre Auswahl ist: " + weitereoptionchoice);
            if (weitereoptionchoice.equals("1")){
                o.printData("Segmentierung der Bahnhofsgrösse: ");
                getMc().getBc().checkBahnhofgroesse();
            }
            else if(weitereoptionchoice.equals("2")){
                o.printData("Überprüfung der Lokführer-Qualifikation: ");
                getMc().getZlc().checkLokfuehrerQualifikationReinelektrisch();
                getMc().getZlc().checkLokfuehrerQualifikationHochgeschwindigkeit();
                getMc().getZlc().checkLokfuehrerQualifikationStandardPerson();
                getMc().getZlc().checkLokfuehrerQualifikationTransport();
            }
            else if(weitereoptionchoice.equals("3")){
                o.printData("Segmentierung der Buchungspreise: ");
                getMc().getBuc().checkBuchungPreis();
            }
        else{
            o.printData("Fehlermeldung: Sie haben eine invalide Eingabe getroffen!");
        }
        startMenu();
    }

    //Dateingabe Menu

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

