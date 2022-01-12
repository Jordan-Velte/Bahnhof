//Jordan
package model;
import java.util.ArrayList;
//Import für Datumwerte
import java.util.Date;

public class Zuglinie {
    Lokfuehrer lokfuehrer;
    ArrayList<Personal> personal = new ArrayList<Personal>();
    //Bahnhöfe!!
    Zug zug;
    int zugliniennummer;
    Date fahrtdatum;

    //Bahnhöfe fehlen!
    public Zuglinie(int zugliniennummer, Zug zug, Lokfuehrer lokfuehrer, ArrayList<Personal> personal, Date fahrtdatum){
        setLokfuehrer(lokfuehrer);
        setPersonal(personal);
        setZug(zug);
        setZugliniennummer(zugliniennummer);
        setFahrtDatum(fahrtdatum);
    }

    public void setLokfuehrer(Lokfuehrer lokfuehrer) {
        this.lokfuehrer = lokfuehrer;
    }
    public void setPersonal(ArrayList<Personal> personal) {
        this.personal = personal;
    }
    public void setZug(Zug zug) {
        this.zug = zug;
    }
    public void setFahrtDatum(Date fahrtdatum) {
        this.fahrtdatum = fahrtdatum;
    }
    public void setZugliniennummer(int zugliniennummer) {
        this.zugliniennummer = zugliniennummer;
    }
    public Lokfuehrer getLokfuehrer() {
        return lokfuehrer;
    }
    public ArrayList<Personal> getPersonal() {
        return personal;
    }
    public Zug getZug() {
        return zug;
    }
    public Date getFahrtDatum() {
        return fahrtdatum;
    }
    public int getZugliniennummer() {
        return zugliniennummer;
    }


}
