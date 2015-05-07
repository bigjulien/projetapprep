/**
 * Created by ZHU Yuting on 2015/05/07
 */
package serveur;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class LoginServeur {
    public LoginServeur() {
        try {
            System.out.println("Serveur running...");
            Login user = new LoginImpl();
            LocateRegistry.createRegistry(8888);
            Naming.rebind("rmi://127.0.0.1:8888/LoginServeur", user);
        } catch (Exception e) {
            System.err.println("Erreur: " + e);
        }
    }

}
