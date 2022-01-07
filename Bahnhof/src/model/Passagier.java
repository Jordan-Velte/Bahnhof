package model;

public class Passagier extends Person{
 
    int kundennummer;

    public Passagier(String vorname, String nachname, int kundennummer){
        super(vorname, nachname);
        setKundennummer(kundennummer);
    }

    // Setter und Getter

    public int getKundennummer() {
        return kundennummer;
    }

    public void setKundennummer(int kundennummer) {
        this.kundennummer = kundennummer;
    }



}
