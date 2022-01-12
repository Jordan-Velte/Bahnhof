package controller;
import model.*;
import java.util.ArrayList;
import java.util.Locale;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
public class ZuglinieController {
    MainController mc;
    ArrayList<Zuglinie> zuglinie = new ArrayList<Zuglinie>();
    DateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN);

    public ZuglinieController(MainController mc){
        setMc(mc);
        setZuglinie(zuglinie);
    }

    public void createDemoDaten() throws ParseException{
        //Demodaten kommen noch
    }

    //Setter & Getter
    public void setMc(MainController mc) {
        this.mc = mc;
    }
    public void setFormat(DateFormat format) {
        this.format = format;
    }
    public void setZuglinie(ArrayList<Zuglinie> zuglinie) {
        this.zuglinie = zuglinie;
    }
    public MainController getMc() {
        return mc;
    }
    public DateFormat getFormat() {
        return format;
    }
    public ArrayList<Zuglinie> getZuglinie() {
        return zuglinie;
    }

    
}
