package controller;
import model.*;
import java.util.ArrayList;
public class ZugController {
    MainController mc;
    ArrayList<Zug> zug;
    ArrayList<HochgeschwindigkeitsZug> hochgeschwindigkeitszug;
    ArrayList<TransportZug> transportzug;
    ArrayList<ReinelektrischZug> reinelektrischzug;
    ArrayList<PersonenZug> personenzug;

    public ZugController(MainController mc){
        zug = new ArrayList<Zug>();
        hochgeschwindigkeitszug = new ArrayList<HochgeschwindigkeitsZug>();
        transportzug = new ArrayList<TransportZug>()
    }

    //Setter & Getter
    public void setHochgeschwindigkeitszug(ArrayList<HochgeschwindigkeitsZug> hochgeschwindigkeitszug) {
        this.hochgeschwindigkeitszug = hochgeschwindigkeitszug;
    }
    public void setMc(MainController mc) {
        this.mc = mc;
    }
    public void setPersonenzug(ArrayList<PersonenZug> personenzug) {
        this.personenzug = personenzug;
    }
    public void setReinelektrischzug(ArrayList<ReinelektrischZug> reinelektrischzug) {
        this.reinelektrischzug = reinelektrischzug;
    }
    public void setTransportzug(ArrayList<TransportZug> transportzug) {
        this.transportzug = transportzug;
    }
    public void setZug(ArrayList<Zug> zug) {
        this.zug = zug;
    }
    public ArrayList<HochgeschwindigkeitsZug> getHochgeschwindigkeitszug() {
        return hochgeschwindigkeitszug;
    }
    public MainController getMc() {
        return mc;
    }
    public ArrayList<PersonenZug> getPersonenzug() {
        return personenzug;
    }
    public ArrayList<ReinelektrischZug> getReinelektrischzug() {
        return reinelektrischzug;
    }
    public ArrayList<TransportZug> getTransportzug() {
        return transportzug;
    }
    public ArrayList<Zug> getZug() {
        return zug;
    }


}
