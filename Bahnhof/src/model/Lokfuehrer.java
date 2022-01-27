//LENNARD
package model;
//IMPORTS
import java.util.ArrayList;
import java.util.Date;

//Subklasse von Oberklasse Person
public class Lokfuehrer extends Person{
    
    //VARIABLENDEKLARATION
    int lokfuehrernummer;
    //Mehrere Qualifikationen möglich!
    ArrayList<String> qualifikation = new ArrayList<String>();
    Date fuehrerzulassung;

    //CONSTRUCTOR
    public Lokfuehrer(String vorname, String nachname, int lokfuehrernummer, ArrayList<String> qualifikation, Date fuehrerzulassung){
        super(vorname, nachname);
        setQualifikation(qualifikation);
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
