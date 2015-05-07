/**
 * Created by ZHU Yuting on 2015/05/07
 */
package serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import user.User;
import user.UserOperation;

public class LoginImpl extends UnicastRemoteObject implements Login {

    protected LoginImpl() throws RemoteException {
        super();
    }

    @Override
    public boolean login(String name, String password) throws RemoteException {
        return UserOperation.login(name, password);
    }

    @Override
    public void addUser(String name, String password) throws RemoteException {
        UserOperation.addUser(name, password);
    }

}
