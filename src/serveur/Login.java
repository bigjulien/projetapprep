/**
 * Created by ZHU Yuting on 2015/05/07
 */
package serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;

import user.User;

public interface Login extends Remote {
    
    public void addUser(String name, String password) throws RemoteException;

    public boolean login(String name, String password) throws RemoteException;
}
