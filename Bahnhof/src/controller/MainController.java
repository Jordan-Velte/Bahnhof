package controller;

import view.*;

// Lennard, Jordan
public class MainController {
    
    PersonenController pc;
    ZugController zc;
    BuchungController bc;
    ZuglinieController zlc;
    Output output;

    public MainController(){
        setOutput(new Output());
        setPc(new PersonenController(this));
        setZc(new ZugController(this));
        setBc(new BuchungController(this));
        setZlc(new ZuglinieController(this));
        createDemoData();
        printDemoData();
    }

    public void createDemoData(){
        getPc().createDemoDaten();
        getZc().createDemoDaten();
    }


    public void printDemoData(){

    }


    public Output getOutput() {
        return output;
    }
    public void setOutput(Output output) {
        this.output = output;
    }
    public PersonenController getPc() {
        return pc;
    }
    public BuchungController getBc() {
        return bc;
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
    public void setBc(BuchungController bc) {
        this.bc = bc;
    }
    public void setZlc(ZuglinieController zlc) {
        this.zlc = zlc;
    }

}
