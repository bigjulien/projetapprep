package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import serveur.Login;
import serveur.LoginImpl;
import user.User;

public class Client {

    User user;
    public Client(){}
    public static void main(String[] args) {
        Client client=new Client();
        try {
            Login l=(Login)Naming.lookup("rmi://localhost:8888/Login");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

}
