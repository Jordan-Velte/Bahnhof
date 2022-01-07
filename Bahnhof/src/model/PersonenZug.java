package model;
//Import für Datumwerte
import java.util.Date;

public class PersonenZug extends Zug{
    int maxpersonenladung;

    public PersonenZug(String modell, String betreiber, double durchschnittsgeschwindigkeit, int wagonzahl, Date zulassungsdatum, int maxpersonenladung){
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
