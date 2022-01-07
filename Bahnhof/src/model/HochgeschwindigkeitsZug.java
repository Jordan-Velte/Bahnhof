package model;
//Import für Datumwerte
import java.util.Date;

public class HochgeschwindigkeitsZug extends Zug{
    double entwicklungskosten;

    public HochgeschwindigkeitsZug(String modell, String betreiber, double durchschnittsgeschwindigkeit, int wagonzahl, Date zulassungsdatum, double entwicklungskosten){
        super(modell, betreiber, durchschnittsgeschwindigkeit, wagonzahl, zulassungsdatum);
    }

    public void setEntwicklungskosten(double entwicklungskosten) {
        this.entwicklungskosten = entwicklungskosten;
    }
    public double getEntwicklungskosten() {
        return entwicklungskosten;
    }

}
