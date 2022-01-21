//Jordan
package view;
import java.util.Scanner;
import view.Output;
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
            o.printData("(2) Personen");
            o.printData("(3) Züge");
            o.printData("(4) Zuglinien");
            o.printData("(5) Buchungen");
            String ausgabechoice = getScanner().nextLine();
            o.printData("Ihre Auswahl ist: " + ausgabechoice);
            if(ausgabechoice.equals("1")){
                getMc().getBc().printOutBahnhof();
            }
            else if(ausgabechoice.equals("2")){
                o.printData("Ausgabe weiter!");
            }
            else if(ausgabechoice.equals("3")){
                o.printData("Ausgabe weiter!");
            }
            else if(ausgabechoice.equals("4")){
                o.printData("Wird noch implementiert");
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

