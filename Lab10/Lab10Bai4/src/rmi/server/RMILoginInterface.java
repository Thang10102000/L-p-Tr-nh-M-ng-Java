package rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import rmi.client.User;

public interface RMILoginInterface extends Remote {

    public boolean checkLogin(User user) throws RemoteException;
    
}
