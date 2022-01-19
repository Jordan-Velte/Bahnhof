package model;

import java.util.ArrayList;
// Lennard
import java.util.Date;

public class Lokfuehrer extends Person{
 
    int lokfuehrernummer;
    ArrayList<String> qualifikation;
    Date fuehrerzulassung;

    public Lokfuehrer(String vorname, String nachname, int lokfuehrernummer, ArrayList<String> qualifikation, Date fuehrerzulassung){
        super(vorname, nachname);
        qualifikation = new ArrayList<String>();
        setFuehrerzulassung(fuehrerzulassung);
        setLokfuehrernummer(lokfuehrernummer);
    }

    // Setter und Getter
    public Date getFuehrerzulassung() {
        return fuehrerzulassung;
    }

    public void setQualifikation(ArrayList<String> qualifikation) {
        this.qualifikation = qualifikation;
    }

    public ArrayList<String> getQualifikation() {
        return qualifikation;
    }

    public void setFuehrerzulassung(Date fuehrerzulassung) {
        this.fuehrerzulassung = fuehrerzulassung;
    }

    public int getLokfuehrernummer() {
        return lokfuehrernummer;
    }

    public void setLokfuehrernummer(int lokfuehrernummer) {
        this.lokfuehrernummer = lokfuehrernummer;
    }


}
