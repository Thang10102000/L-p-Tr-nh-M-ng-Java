package rmi.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmi.server.RMILoginInterface;

public class RMILoginClientControl {

    private RMILoginClientView view;
    private String serverHost = "localhost";
    private int serverPort = 3232;
    private RMILoginInterface rmiServer;
    private Registry registry;
    private String rmiService = "rmiLoginServer";

    public RMILoginClientControl(RMILoginClientView view) {
        this.view = view;
        view.addLoginListener(new LoginListener());
        try {
// lay the dang ki
            registry = LocateRegistry.getRegistry(serverHost, serverPort);
// tim kiem RMI server
            rmiServer = (RMILoginInterface) (registry.lookup(rmiService));
        } catch (RemoteException e) {
            view.showMessage(e.getStackTrace().toString());
            e.printStackTrace();
        } catch (NotBoundException e) {
            view.showMessage(e.getStackTrace().toString());
            e.printStackTrace();
        }
    }

    class LoginListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                User model = view.getUser();
                if (rmiServer.checkLogin(model)) {
                    view.showMessage("Đăng nhập thành công !");
                } else {
                    view.showMessage("Sai tài khoản hoặc mật khẩu !");
                }
            } catch (Exception ex) {
                view.showMessage(ex.getStackTrace().toString());
                ex.printStackTrace();
            }
        }
    }
}
