//JORDAN
package model;
//Import für Datumwerte
import java.util.Date;

//Subklasse von Oberklasse Zug
public class HochgeschwindigkeitsZug extends Zug{
    //VARIABLENDEKLARATION
    //In Euro
    double entwicklungskosten;

    //CONSTRUCTOR
    public HochgeschwindigkeitsZug(String modell, String betreiber, double durchschnittsgeschwindigkeit, int wagonanzahl, Date zulassungsdatum, double entwicklungskosten){
        super(modell, betreiber, durchschnittsgeschwindigkeit, wagonanzahl, zulassungsdatum);
        setEntwicklungskosten(entwicklungskosten);
    }

    //Setter und Getter
    public void setEntwicklungskosten(double entwicklungskosten) {
        this.entwicklungskosten = entwicklungskosten;
    }
    public double getEntwicklungskosten() {
        return entwicklungskosten;
    }

}
