package clients;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.JMSException;
import javax.management.remote.rmi.RMIConnection;

import serveur.Login;
/**
 * 
 * @author Julien Le Van Suu
 * cette classe permet de lancer un publisher apres lecture des mdp/login sur le serveur
 *
 */
public class PublisherLaunch {
	public static void main(String [] args) throws JMSException
	{
		System.out.println("####### PUBLISHER #######");
		/**
		 * Lecture des logins
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir un login :");
		String name = sc.nextLine();
		
		System.out.println("Veuillez saisir un passw :");
		String password = sc.nextLine();
		
		
		/**
		 * Appel au serveur : le login est il bon ?
		 */
		boolean loginok = false;
        try {
            Login l = (Login) Naming
                    .lookup("rmi://127.0.0.1:8888/LoginServeur");
            System.out.println("Connecté au serveur de login!");
          
            
            loginok = l.login(name, password);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            Logger.getLogger(RMIConnection.class.getName()).log(Level.SEVERE,
                    null, e);
        } catch (NotBoundException e) {
            e.printStackTrace();
        }       

        /**
         * Boucle publisher
         */
		if(loginok)
		{
			System.out.println("Login OK");
			Publisher p = new Publisher(name);
			while(true)
			{
				System.out.println("Publier un tweet :");
				String toParse = sc.nextLine();
				String[] message = toParse.split("#");
				String[] hashtags = new String[message.length-1];
				for(int i = 1;i<message.length;i++)
				{
					hashtags[i-1] = message[i];
				}
				// On suppose que le message vient toujours avant les hashtags
				p.publier(message[0], hashtags);
			}
		}
		else
		{
			System.out.println("Login non valide. Au revoir");
		}
		sc.close();
	}

}
