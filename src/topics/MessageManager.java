package topics;

import javax.jms.JMSException;

public class MessageManager{
	Publisher p ;
	Subscriber s = new Subscriber();
	
	public MessageManager(String username)
	{
		p =new Publisher(username);
	}
	
	public void publier(String message,String[] hashtags)
	{
		try {
			p.publier(message, hashtags);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	public void lancerLecture(String[] hashtags)
	{
		try {
			s.lancerLecture(hashtags);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void abonner(String hashtag)
	{
		s.abonner(hashtag);
	}
	
	public void desabonner(String hashtag)
	{
		s.desabonner(hashtag);
	}


}
