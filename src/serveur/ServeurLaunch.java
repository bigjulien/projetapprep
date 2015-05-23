/**
 * Created by ZHU Yuting on 2015/05/07
 */
package serveur;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
/**
 * Lancer le serveur
 * @author user
 *
 */
public class ServeurLaunch {

    public static void main(String[] args) {
        try {
        	System.out.println("####### Login server #######");
            Login user = new LoginImpl();
            //Pour ne pas avoir a remplir manuellement a chaque lancement du serveur
            user.addUser("test", "test");
            user.addUser("test2", "test2");
            user.addUser("lel", "lel");
            LocateRegistry.createRegistry(8888);
            Naming.rebind("rmi://127.0.0.1:8888/LoginServeur", user);
       } catch (Exception e) {
            System.err.println("Erreur: " + e);
       }
        
    }

}
