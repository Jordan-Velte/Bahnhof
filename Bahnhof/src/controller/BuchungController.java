//Jordan
package controller;
import model.*;
import java.util.ArrayList;
import java.util.Locale;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class BuchungController {
    MainController mc;
    ArrayList<Buchung> buchung = new ArrayList<Buchung>();
    DateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN);

    public BuchungController(MainController mc){
        setBuchung(buchung);
        setMc(mc);
    }
    public void createDemoDaten() throws ParseException{
        Buchung b1 = new Buchung(1, getMc().getZlc().getZuglinie().get(0), getMc().getPc().getPassagiere().get(0), 68.9, format.parse("1.1.2022"));
        Buchung b2 = new Buchung(2, getMc().getZlc().getZuglinie().get(1), getMc().getPc().getPassagiere().get(1), 100.9, format.parse("8.1.2022"));
        buchung.add(b1);
        buchung.add(b2);
    }

    

    public void setBuchung(ArrayList<Buchung> buchung) {
        this.buchung = buchung;
    }
    public void setFormat(DateFormat format) {
        this.format = format;
    }
    public void setMc(MainController mc) {
        this.mc = mc;
    }
    public ArrayList<Buchung> getBuchung() {
        return buchung;
    }
    public DateFormat getFormat() {
        return format;
    }
    public MainController getMc() {
        return mc;
    }
}
