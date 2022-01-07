package model;
//Import für Datumwerte
import java.util.Date;
public class Reinelektrisch extends Zug{
    //z.B. Wechselstrom, Gleichstrom etc.
    String energieversorgung;
    double batterielebensdauerinjahren;

    Reinelektrisch(String modell, String betreiber, double durchschnittsgeschwindigkeit, int wagonzahl, Date zulassungsdatum, String energieversorgung, double batterielebensdauerinjahren){
        super(modell, betreiber, durchschnittsgeschwindigkeit, wagonzahl, zulassungsdatum);
        setBatterielebensdauerinjahren(batterielebensdauerinjahren);
        setEnergieversorgung(energieversorgung);
    }

    public void setBatterielebensdauerinjahren(double batterielebensdauerinjahren) {
        this.batterielebensdauerinjahren = batterielebensdauerinjahren;
    }
    public void setEnergieversorgung(String energieversorgung) {
        this.energieversorgung = energieversorgung;
    }
    public double getBatterielebensdauerinjahren() {
        return batterielebensdauerinjahren;
    }
    public String getEnergieversorgung() {
        return energieversorgung;
    }

}
