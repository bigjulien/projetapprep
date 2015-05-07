package serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Login extends Remote {
   
    public boolean login(String name, String password) throws RemoteException;
}
