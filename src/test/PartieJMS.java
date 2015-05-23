package test;
/**
 * Test de la partie JMS independamment
 */
import javax.jms.JMSException;

import clients.Publisher;
import clients.Subscriber;

public class PartieJMS {

	public static void main(String[] args) throws JMSException {
	Publisher p = new Publisher("Moa");
	Subscriber s = new Subscriber();
	String[] ht = {"yolo","bidule","truc"};
	String[] ht2 = {"yolo","bidule"};
	String[] ht3 = {"yolo"};
	String[] ht4 = {"truc"};
	
	
	s.lancerLecture(ht2);
	p.publier("Salut les copains", ht);
	s.abonner("truc");
	p.publier("Blah", ht4);

	}

}
