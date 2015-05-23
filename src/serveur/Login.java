/**
 * Created by ZHU Yuting on 2015/05/07
 */
package serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Cette classe permet d'exposer deux méthodes d'ajout d'utilisateurs et de login
 * @author user
 *
 */
public interface Login extends Remote {
    /**
     * Ajouter un utilisateur
     * @param name
     * @param password
     * @throws RemoteException
     */
    public void addUser(String name, String password) throws RemoteException;
    
    /**
     * Se logguer
     * @param name
     * @param password
     * @return
     * @throws RemoteException
     */
    public boolean login(String name, String password) throws RemoteException;
}
