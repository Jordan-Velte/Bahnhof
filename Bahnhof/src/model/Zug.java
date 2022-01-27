//JORDAN
package model;
//IMPORTS
//Import für Datumwerte
import java.util.Date;

//Oberklasse
//Abstrakte Klasse --> kein Element kann von der Oberklasse erstellt werden (macht im Sachkontext keinen Sinn)!
public abstract class Zug {
    //VARIABLENDEKLARATION
    String modell;
    String betreiber;
    double durchschnittsgeschwindigkeit;
    int wagonanzahl;
    Date zulassungsdatum;

    //CONSTRUCTOR
    public Zug(String modell, String betreiber, double durchschnittsgeschwindigkeit, int wagonanzahl, Date zulassungsdatum){
        setBetreiber(betreiber);
        setModell(modell);
        setDurchschnittsgeschwindigkeit(durchschnittsgeschwindigkeit);
        setWagonanzahl(wagonanzahl);
        setZulassungsdatum(zulassungsdatum);
    }

    //Setter & Getter
    public void setBetreiber(String betreiber) {
        this.betreiber = betreiber;
    }
    public void setDurchschnittsgeschwindigkeit(double durchschnittsgeschwindigkeit) {
        this.durchschnittsgeschwindigkeit = durchschnittsgeschwindigkeit;
    }
    public void setModell(String modell) {
        this.modell = modell;
    }
    public void setWagonanzahl(int wagonanzahl) {
        this.wagonanzahl = wagonanzahl;
    }
    public void setZulassungsdatum(Date zulassungsdatum) {
        this.zulassungsdatum = zulassungsdatum;
    }
    public String getBetreiber() {
        return betreiber;
    }
    public double getDurchschnittsgeschwindigkeit() {
        return durchschnittsgeschwindigkeit;
    }
    public String getModell() {
        return modell;
     }
    public int getWagonanzahl() {
        return wagonanzahl;
    }
    public Date getZulassungsdatum() {
        return zulassungsdatum;
    }
}
