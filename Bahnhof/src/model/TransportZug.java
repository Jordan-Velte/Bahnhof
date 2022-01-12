//Jordan
package model;
//Import für Datumwerte
import java.util.Date;

public class TransportZug extends Zug{
    boolean langstreckenzulassung;
    String umweltbelastung;
    //In KG
    double maxgesamtgewichtinkg;

    public TransportZug(String modell, String betreiber, double durchschnittsgeschwindigkeit, int wagonzahl, Date zulassungsdatum, boolean langstreckenzulassung, String umweltbelastung, double maxgesamtgewichtinkg){
        super(modell, betreiber, durchschnittsgeschwindigkeit, wagonzahl, zulassungsdatum);
        setLangstreckenzulassung(langstreckenzulassung);
        setMaxgesamtgewichtinkg(maxgesamtgewichtinkg);
        setUmweltbelastung(umweltbelastung);
    }

    public void setLangstreckenzulassung(boolean langstreckenzulassung) {
        this.langstreckenzulassung = langstreckenzulassung;
    }
    public void setMaxgesamtgewichtinkg(double maxgesamtgewichtinkg) {
        this.maxgesamtgewichtinkg = maxgesamtgewichtinkg;
    }
    public void setUmweltbelastung(String umweltbelastung) {
        this.umweltbelastung = umweltbelastung;
    }
    public double getMaxgesamtgewichtinkg() {
        return maxgesamtgewichtinkg;
    }
    public String getUmweltbelastung() {
        return umweltbelastung;
    }

}
