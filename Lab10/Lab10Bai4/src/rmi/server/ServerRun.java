package rmi.server;

public class ServerRun {

    public static void main(String[] args) {
        RMILoginServerView view = new RMILoginServerView();
        try {
            RMILoginServerControl control = new RMILoginServerControl(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
