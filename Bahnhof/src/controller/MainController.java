//LENNARD
package controller;
//IMPORTS
import java.text.ParseException;
import view.*;

public class MainController {
    //VARIABLENDEKLARATION
    //Erstellung der einzelnen Instanzen von den jeweiligen Controller-Klassen --> Notwendige Bedingung in MVC-Struktur: MainController hat über Punktnotation Zugriff auf alle anderen Controller-Klassen!
    PersonenController pc;
    ZugController zc;
    BuchungController buc;
    ZuglinieController zlc;
    BahnhofsController bc;
    GleisController gc;
    //Instanzerstellung Output-Klasse
    Output output;
    //Instanzerstellung Menu-Klasse
    Menu menu;

    //CONSTRUCTOR
    public MainController() throws ParseException{
        //Übergabe des MainControllers für die jeweilige Controller-Klasse über Instanzerstellung (Parameterübergabe des Main-Controllers --> this) in Setter der Klasse
        setPc(new PersonenController(this));
        setZc(new ZugController(this));
        setBuc(new BuchungController(this));
        setZlc(new ZuglinieController(this));
        setBc(new BahnhofsController(this));
        setGc(new GleisController(this));
        setOutput(new Output());
        setMenu(new Menu(this));
        
    }

    //DEMODATEN
    public void createDemoDatenset() throws ParseException{
        //Aufrufen der respektiven Demodaten-Methoden der Klassen-Controller
        getPc().createDemoDaten();
        getZc().createDemoDaten();
        getGc().createDemoDaten();
        getBc().createDemoDaten();
        getZlc().createDemoDaten();
        getBuc().createDemoDaten();

    }

    //MENU-START-METHODE
    public void createMenu() throws ParseException{
        //Das obig deklarierte Menu kann nun per Getter, beziehungsweise Punktnotation, die startMenu-Methode der Menu Klasse öffnen --> In der MVC-Struktur ist der MainController somit Schnittstelle zwischen model (Demodaten) und view (Menu)!
        getMenu().startMenu();
    }

    // Setter und Getter
    public Output getOutput() {
        return output;
    }
    public void setBc(BahnhofsController bc) {
        this.bc = bc;
    }
    public void setGc(GleisController gc) {
        this.gc = gc;
    }
    public void setOutput(Output output) {
        this.output = output;
    }
    public PersonenController getPc() {
        return pc;
    }
    public BuchungController getBuc() {
        return buc;
    }
    public ZuglinieController getZlc() {
        return zlc;
    }
    public void setPc(PersonenController pc) {
        this.pc = pc;
    }
    public ZugController getZc() {
        return zc;
    }
    public void setZc(ZugController zc) {
        this.zc = zc;
    }
    public void setBuc(BuchungController buc) {
        this.buc = buc;
    }
    public void setZlc(ZuglinieController zlc) {
        this.zlc = zlc;
    }
    public BahnhofsController getBc() {
        return bc;
    }
    public GleisController getGc() {
        return gc;
    }
    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    public Menu getMenu() {
        return menu;
    }


}
