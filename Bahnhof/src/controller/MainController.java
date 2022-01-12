package controller;

import view.*;

// Lennard
public class MainController {
    
    PersonenController pc;
    ZugController zc;
    Output output;

    public MainController(){
        setOutput(new Output());
        setPc(new PersonenController(this));
        setZc(new ZugController(this));

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

    public void setPc(PersonenController pc) {
        this.pc = pc;
    }

    public ZugController getZc() {
        return zc;
    }

    public void setZc(ZugController zc) {
        this.zc = zc;
    }
}
