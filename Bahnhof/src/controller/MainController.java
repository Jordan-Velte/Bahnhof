package controller;

import view.*;

// Lennard
public class MainController {
    
    PersonenController pc;
    ZugController zc;
    BahnhofsController bc;
    GleisController gc;
    Output output;

    public MainController(){
        setOutput(new Output());
        setPc(new PersonenController(this));
        setZc(new ZugController(this));
        setBc(new BahnhofsController(this));
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

    public void setOutput(Output output) {
        this.output = output;
    }

    public PersonenController getPc() {
        return pc;
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

    public BahnhofsController getBc() {
        return bc;
    }

    public void setBc(BahnhofsController bc) {
        this.bc = bc;
    }

    public GleisController getGc() {
        return gc;
    }

    public void setGc(GleisController gc) {
        this.gc = gc;
    }

}
