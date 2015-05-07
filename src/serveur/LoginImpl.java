package serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import user.User;

public class LoginImpl extends UnicastRemoteObject implements Login {

    public ArrayList<User> userList;

    protected LoginImpl() throws RemoteException {
        super();
        userList = new ArrayList<>();
    }

    @Override
    public boolean login(String name, String password) throws RemoteException {
        // TODO Auto-generated method stub
        return false;
    }

    }
