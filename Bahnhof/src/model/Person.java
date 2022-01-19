package model;

// Lennard
public abstract class Person {
    
    String vorname;
    String nachname;

    public Person(String vorname, String nachname){
        setVorname(vorname);
        setNachname(nachname);
    }


    // Setter und Getter

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }



}
