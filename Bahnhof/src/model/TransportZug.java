//JORDAN
package model;
//IMPORTS
//Import für Datumwerte
import java.util.Date;

//Subklasse von Oberklasse Zug
public class TransportZug extends Zug{
    //VARIABLENDEKLARATION
    boolean langstreckenzulassung;
    String umweltbelastung;
    //In KG
    double maxgesamtgewichtinkg;

    //CONSTRUCTOR
    public TransportZug(String modell, String betreiber, double durchschnittsgeschwindigkeit, int wagonanzahl, Date zulassungsdatum, boolean langstreckenzulassung, String umweltbelastung, double maxgesamtgewichtinkg){
        super(modell, betreiber, durchschnittsgeschwindigkeit, wagonanzahl, zulassungsdatum);
        setLangstreckenzulassung(langstreckenzulassung);
        setMaxgesamtgewichtinkg(maxgesamtgewichtinkg);
        setUmweltbelastung(umweltbelastung);
    }

    //Setter und Getter
    public void setLangstreckenzulassung(boolean langstreckenzulassung) {
        this.langstreckenzulassung = langstreckenzulassung;
    }
    public void setMaxgesamtgewichtinkg(double maxgesamtgewichtinkg) {
        this.maxgesamtgewichtinkg = maxgesamtgewichtinkg;
    }
    public void setUmweltbelastung(String umweltbelastung) {
        this.umweltbelastung = umweltbelastung;
    }
    public boolean getLangstreckenzulassung(){
        return langstreckenzulassung;
    }
    public double getMaxgesamtgewichtinkg() {
        return maxgesamtgewichtinkg;
    }
    public String getUmweltbelastung() {
        return umweltbelastung;
    }

}
