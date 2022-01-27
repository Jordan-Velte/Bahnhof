//JORDAN
package model;
//IMPORTS
//Import für Datumwerte
import java.util.Date;
//Subklasse von Oberklasse Zug
public class StandardPersonenZug extends Zug{
    //VARIABLENDEKLARATION
    //Anzahl
    int maxpersonenladung;

    //CONSTRUCTOR
    public StandardPersonenZug(String modell, String betreiber, double durchschnittsgeschwindigkeit, int wagonanzahl, Date zulassungsdatum, int maxpersonenladung){
        super(modell, betreiber, durchschnittsgeschwindigkeit, wagonanzahl, zulassungsdatum);
        setMaxpersonenladung(maxpersonenladung);
    }

    //Setter und Getter
    public void setMaxpersonenladung(int maxpersonenladung) {
        this.maxpersonenladung = maxpersonenladung;
    }
    public int getMaxpersonenladung() {
        return maxpersonenladung;
    }

}
