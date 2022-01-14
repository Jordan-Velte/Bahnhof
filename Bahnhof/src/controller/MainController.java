package controller;

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

    public MainController(){
        setOutput(new Output());
        setPc(new PersonenController(this));
        setZc(new ZugController(this));
        setBuc(new BuchungController(this));
        setZlc(new ZuglinieController(this));
        setBc(new BuchungController(this));
        setGc(new GleisController(this));
        

        createDemoData();
        printDemoData();
    }

    public void createDemoData(){
        getPc().createDemoDaten();
        getZc().createDemoDaten();
    }


    public void printDemoData(){

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


}
