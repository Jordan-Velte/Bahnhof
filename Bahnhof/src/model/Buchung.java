//JORDAN
package model;
//IMPORTS
//Import für Datumwerte
import java.util.Date;

public class Buchung {
    //VARIABLENDEKLARATION
    Passagier passagier;
    Zuglinie zuglinie;
    int buchungsnummer;
    //In Euro
    double preis;
    Date buchungsdatum;
    //ArrayList für ausgewählte Bahnhöfe!

    //CONSTRUCTOR
    public Buchung(int buchungsnummer, Zuglinie zuglinie, Passagier passagier, double preis, Date buchungsdatum){
        setBuchungsnummer(buchungsnummer);
        setPassagier(passagier);
        setPreis(preis);
        setZuglinie(zuglinie);
        setBuchungsdatum(buchungsdatum);
    }

    //Setter & Getter
    public void setBuchungsnummer(int buchungsnummer) {
        this.buchungsnummer = buchungsnummer;
    }
    public void setBuchungsdatum(Date buchungsdatum) {
        this.buchungsdatum = buchungsdatum;
    }
    public void setZuglinie(Zuglinie zuglinie) {
        this.zuglinie = zuglinie;
    }
    public void setPassagier(Passagier passagier) {
        this.passagier = passagier;
    }
    public void setPreis(double preis) {
        this.preis = preis;
    }
    public int getBuchungsnummer() {
        return buchungsnummer;
    }
    public Passagier getPassagier() {
        return passagier;
    }
    public Date getBuchungsdatum() {
        return buchungsdatum;
    }
    public double getPreis() {
        return preis;
    }
    public Zuglinie getZuglinie() {
        return zuglinie;
    }


}
