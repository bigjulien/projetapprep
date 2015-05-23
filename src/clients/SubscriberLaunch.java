package clients;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.JMSException;
import javax.management.remote.rmi.RMIConnection;

import serveur.Login;
import serveur.UserOperation;
/**
 * 
 * @author Julien Le Van Suu
 * cette classe permet de lancer un subscriber apres lecture des mdp/login sur le serveur
 *
 */
public class SubscriberLaunch {
	public static void main(String [] args) throws JMSException
	{
		System.out.println("####### SUBSCRIBER #######");
		/**
		 * Lecture des logins
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir un login :");
		String name = sc.nextLine();
		
		System.out.println("Veuillez saisir un passw :");
		String password = sc.nextLine();
		
		boolean loginok = false;
		
		/**
		 * Appel au serveur : le login est il bon ?
		 */
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
         * Boucle subscriber
         */
		if(loginok)
		{
			System.out.println("Login OK");
			Subscriber s = new Subscriber();
			ArrayList<String> hashtags = new ArrayList<String>();
			while(true)
			{
				//Si on a rentré tous les abo on rentre c
				System.out.println("S'abonner a (c pour continuer) :");
				String hashtag = sc.nextLine();
				if(hashtag.equals("c"))break;
				hashtags.add(hashtag);
			}
			String[] ht = hashtags.toArray(new String[hashtags.size()]);
			s.lancerLecture(ht);
			
		}
		else
		{
			System.out.println("Login non valide. Au revoir");
		}
		sc.close();
	}

}