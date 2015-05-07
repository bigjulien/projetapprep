package test;

import topics.MessageManager;

public class Main {

	public static void main(String[] args) {
	MessageManager  m = new MessageManager("toto");
	String[] ht = {"yolo","bidule","truc"};
	String[] ht2 = {"yolo","bidule"};
	String[] ht3 = {"yolo"};
	String[] ht4 = {"truc"};
	
	
	m.lancerLecture(ht2);
	m.publier("Salut les copains", ht);
	m.abonner("truc");
	m.publier("Blah", ht4);

	}

}
