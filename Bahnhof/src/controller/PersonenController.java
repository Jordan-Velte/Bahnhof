package controller;

import model.*;
import java.util.ArrayList;

public class PersonenController {
    
    MainController mc;
    ArrayList<Person> personen;
    ArrayList<Lokfuehrer> lokfuehrer;
    ArrayList<Passagier> passagiere;
    ArrayList<Personal> personal;

    public PersonenController(MainController mc){
        setMc(mc);
        personen = new ArrayList<Person>();
        lokfuehrer = new ArrayList<Lokfuehrer>();
        passagiere = new ArrayList<Passagier>();
        personal = new ArrayList<Personal>();
    }


    public void createDemoDaten(){

        Passagier pa1 = new Passagier("Bernd", "Barbar", 01);
        Passagier pa2 = new Passagier("Peter", "Klaus", 02); 
        Passagier pa3 = new Passagier("Klaus", "Kleber", 03);
        passagiere.add(pa1);
        passagiere.add(pa2);
        passagiere.add(pa3);
        Personal pe1 = new Personal("Karl", "Kernig", 255);
        Personal pe2 = new Personal("Paul", "Pringle", 256);
        Personal pe3 = new Personal("Lola", "Lachs", 257);
        personal.add(pe1);
        personal.add(pe2);
        personal.add(pe3);
        Lokfuehrer lf = new Lokfuehrer("Til", "Tetris", 201, );

    }



    // Setter und Getter

    public MainController getMc() {
        return mc;
    }

    public void setMc(MainController mc) {
        this.mc = mc;
    }

    public ArrayList<Person> getPersonen() {
        return personen;
    }

    public void setPersonen(ArrayList<Person> personen) {
        this.personen = personen;
    }

    public ArrayList<Lokfuehrer> getLokfuehrer() {
        return lokfuehrer;
    }

    public void setLokfuehrer(ArrayList<Lokfuehrer> lokfuehrer) {
        this.lokfuehrer = lokfuehrer;
    }

    public ArrayList<Passagier> getPassagiere() {
        return passagiere;
    }

    public void setPassagiere(ArrayList<Passagier> passagiere) {
        this.passagiere = passagiere;
    }

    public ArrayList<Personal> getPersonal() {
        return personal;
    }

    public void setPersonal(ArrayList<Personal> personal) {
        this.personal = personal;
    }

}
