package model;

import java.util.Date;

public class Lokfuehrer extends Person{
 
    int lokfuehrernummer;
    Date fuehrerzulassung;


    public Lokfuehrer(String vorname, String nachname, int lokfuehrernummer, Date fuehrerzulassung){
        super(vorname, nachname);
        setFuehrerzulassung(fuehrerzulassung);
        setLokfuehrernummer(lokfuehrernummer);
    }

    // Setter und Getter

    public Date getFuehrerzulassung() {
        return fuehrerzulassung;
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
