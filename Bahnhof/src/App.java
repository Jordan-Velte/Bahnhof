import controller.MainController;

public class App {
    public static void main(String[] args) throws Exception {
        MainController mc = new MainController();
        mc.createDemoDatenset();
        mc.createMenu();
    }
}
 