package test;

import javax.jms.JMSException;

import topics.Publisher;
import topics.Subscriber;

public class Main {

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
