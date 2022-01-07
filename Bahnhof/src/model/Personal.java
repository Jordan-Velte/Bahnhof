package model;

public class Personal extends Person{
    
    int personalnummer;

    public Personal(String vorname, String nachname, int personalnummer){
        super(vorname, nachname);
        setPersonalnummer(personalnummer);
    }


    // Setter und Getter

    public int getPersonalnummer() {
        return personalnummer;
    }

    public void setPersonalnummer(int personalnummer) {
        this.personalnummer = personalnummer;
    }


}
