//JORDAN
package model;
//IMPORTS
//Import für Datumwerte
import java.util.Date;
//Subklasse von Oberklasse Zug
public class ReinelektrischZug extends Zug{
    //VARIABLENDEKLARATION
    //z.B. Wechselstrom, Gleichstrom etc.
    String energieversorgung;
    double batterielebensdauerinjahren;

    //CONSTRUCTOR
    public ReinelektrischZug(String modell, String betreiber, double durchschnittsgeschwindigkeit, int wagonanzahl, Date zulassungsdatum, String energieversorgung, double batterielebensdauerinjahren){
        super(modell, betreiber, durchschnittsgeschwindigkeit, wagonanzahl, zulassungsdatum);
        setBatterielebensdauerinjahren(batterielebensdauerinjahren);
        setEnergieversorgung(energieversorgung);
    }

    //Setter & Getter
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
