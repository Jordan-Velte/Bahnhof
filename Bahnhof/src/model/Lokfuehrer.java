package model;

// Lennard
import java.util.Date;

public class Lokfuehrer extends Person{
 
    int lokfuehrernummer;
    String qualifikation;
    Date fuehrerzulassung;

    public Lokfuehrer(String vorname, String nachname, int lokfuehrernummer, String qualifikation, Date fuehrerzulassung){
        super(vorname, nachname);
        setFuehrerzulassung(fuehrerzulassung);
        setLokfuehrernummer(lokfuehrernummer);
    }

    // Setter und Getter
    public Date getFuehrerzulassung() {
        return fuehrerzulassung;
    }

   public void setQualifikation(String qualifikation) {
       this.qualifikation = qualifikation;
   }

   public String getQualifikation() {
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
