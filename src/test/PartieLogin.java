/**
 * Created by ZHU Yuting on 2015/05/07
 */
package test;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.management.remote.rmi.RMIConnection;

import serveur.Login;
/**
 * La partie login testée independamment
 * @author user
 *
 */
public class PartieLogin {

    public PartieLogin() {
    }

    public static void main(String[] args) {
        try {
            System.out.println("Client running...");
            Login l = (Login) Naming
                    .lookup("rmi://127.0.0.1:8888/LoginServeur");
            System.out.println("connect success!");
            l.addUser("abc", "abc");
            l.login("", "");
            System.out.println(l.login("abc", "abc"));
            System.out.println(l.login("abc", "a"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            Logger.getLogger(RMIConnection.class.getName()).log(Level.SEVERE,
                    null, e);
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

}
