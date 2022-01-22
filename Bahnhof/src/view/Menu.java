//Jordan
package view;
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
    public void startMenu(){
        System.out.println(getMc().getZc().getReinelektrischzug().get(0).getWagonanzahl());
        o.printData("(1) Dateneingabe");
        o.printData("(2) Datenausgabe");
        String initchoice = getScanner().nextLine();
        o.printData("Ihre Auswahl ist: " + initchoice);
        if(initchoice.equals("1")){
            o.printData("Dateingabe derzeit nicht verfügbar.");
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
            }
            else if(ausgabechoice.equals("3")){
                o.printData("Wählen Sie die Instanzen, die Sie ausgeben möchten:");
                o.printData("(1) Lokführer");
                o.printData("(2) Personal");
                o.printData("(3) Passagiere");
                o.printData("(4) Alle dokumentierten Stakeholder des Zugnetzwerkes");
                String personchoice = getScanner().nextLine();
                o.printData("Ihre Auswahl ist: " + personchoice);
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
            }
            else if(ausgabechoice.equals("4")){
                getMc().getZlc().printOutZuglinie();
            }
            else if(ausgabechoice.equals("5")){
                getMc().getBuc().printOutBuchung();
            }
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

