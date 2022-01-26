package controller;

import java.text.ParseException;

import view.*;

// Lennard, Jordan
public class MainController {
    
    PersonenController pc;
    ZugController zc;
    BuchungController buc;
    ZuglinieController zlc;
    BahnhofsController bc;
    GleisController gc;
    Output output;
    Menu menu;

    public MainController() throws ParseException{
        setOutput(new Output());
        setPc(new PersonenController(this));
        setZc(new ZugController(this));
        setBuc(new BuchungController(this));
        setZlc(new ZuglinieController(this));
        setBc(new BahnhofsController(this));
        setGc(new GleisController(this));
        setMenu(new Menu(this));
    }

    public void createDemoDatenset() throws ParseException{
        getPc().createDemoDaten();
        getZc().createDemoDaten();
        getGc().createDemoDaten();
        getBc().createDemoDaten();
        getZlc().createDemoDaten();
        getBuc().createDemoDaten();

    }

    public void createMenu() throws ParseException{
        getMenu().startMenu();
    }

    //Kommt noch in Menü!
    /*
    public void checkLokfuehrerQualifikation(){
        getZlc().checkLokfuehrerQualifikationReinelektrisch();
        getZlc().checkLokfuehrerQualifikationStandardPerson();
        getZlc().checkLokfuehrerQualifikationHochgeschwindigkeit();
        getZlc().checkLokfuehrerQualifikationTransport();
    }
    */

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
