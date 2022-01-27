//LENNARD
import controller.MainController;

public class App {
    public static void main(String[] args) throws Exception {
        //Instanzerstellung des MainControllers --> Per Punktnotation an der Instanz die Demodaten-Methode, sowie die Menu-Methode aufrufen
        MainController mc = new MainController();
        mc.createDemoDatenset();
        mc.createMenu();
    }
}
 