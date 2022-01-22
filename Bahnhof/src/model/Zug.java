//Jordan
package model;
//Import für Datumwerte
import java.util.Date;
//Oberklasse
public abstract class Zug {
    String modell;
    String betreiber;
    double durchschnittsgeschwindigkeit;
    int wagonanzahl;
    Date zulassungsdatum;

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
