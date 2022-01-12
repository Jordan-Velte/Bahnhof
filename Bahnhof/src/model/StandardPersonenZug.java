//Jordan
package model;
//Import für Datumwerte
import java.util.Date;

public class StandardPersonenZug extends Zug{
    //Anzahl
    int maxpersonenladung;

    public StandardPersonenZug(String modell, String betreiber, double durchschnittsgeschwindigkeit, int wagonzahl, Date zulassungsdatum, int maxpersonenladung){
        super(modell, betreiber, durchschnittsgeschwindigkeit, wagonzahl, zulassungsdatum);
        setMaxpersonenladung(maxpersonenladung);
    }
    
    public void setMaxpersonenladung(int maxpersonenladung) {
        this.maxpersonenladung = maxpersonenladung;
    }
    public int getMaxpersonenladung() {
        return maxpersonenladung;
    }

}
