package rmi.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import rmi.client.User;

public class RMILoginServerControl extends UnicastRemoteObject implements
        RMILoginInterface {

    private int serverPort = 3232;
    private Registry registry;
    private Connection con;
    private RMILoginServerView view;
    private String rmiService = "rmiLoginServer";

    public RMILoginServerControl(RMILoginServerView view) throws RemoteException {
        this.view = view;
        getDBConnection("rmi","root","Anhanh123");
        view.showMessage("RMI server is running...");
// dang ki RMI server
        try {
            registry = LocateRegistry.createRegistry(serverPort);
            registry.rebind(rmiService, this);
        } catch (RemoteException e) {
            throw e;
        }
    }

    public boolean checkLogin(User user) throws RemoteException {
           return  checkUser(user);
          
    }
    
    private void getDBConnection(String dbName,
            String username, String password) {
        String dbUrl = "jdbc:mysql://localhost:3306/" + dbName;
          String dbClass = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(dbClass);
            con = DriverManager.getConnection(dbUrl, username, password);
        } catch (Exception e) {
            view.showMessage(e.getStackTrace().toString());
           e.printStackTrace();
        }
    }

    public boolean checkUser(User user) {
//        String query = "Select * FROM rmi.users WHERE username ='"
//                + user.getUserName()
//                + "' AND password ='" + user.getPassword() + "'";

      String query= "Select * FROM rmi.users WHERE username ='"+ user.getUserName()+"' and password= '"+user.getPassword()+"'";
       
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            //System.out.println(rs.getString("username"));
            return rs.next();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            view.showMessage(e.getStackTrace().toString());
        }
        
        return false;
    }
    
    
}
