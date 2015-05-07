package serveur;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class LoginServeur {
    public LoginServeur() {
        try {
            Login user = new LoginImpl();
            LocateRegistry.createRegistry(8888);
            Naming.rebind("rmi://localhost:8888/LoginServeur", user);
        } catch (Exception e) {
            System.err.println("Erreur: " + e);
        }
    }

}
