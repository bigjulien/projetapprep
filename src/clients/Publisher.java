package clients;

import java.util.Hashtable;


import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * Publisher
 * @author Julien Le Van Suu
 *
 */
public class Publisher{

    private javax.jms.Connection connect = null;
    private javax.jms.Session sendSession = null;
    private javax.jms.MessageProducer sender = null;
    private javax.jms.Queue queue = null;
    InitialContext context = null;
    String username;
    
    /**
     * On a besoin de savoir qui publie d'ou le username
     * @param username
     */
    public Publisher(String username)
    {
    	try {
			configurer();
		} catch (JMSException e) {
			e.printStackTrace();
		}
    	this.username = username;
    }
    
    /**
     * La configuration du publisher
     * @throws JMSException
     */
    private void configurer() throws JMSException {
        
        try
        {	// Create a connection
        	// Si le producteur et le consommateur étaient codés séparément, ils auraient eu ce même bout de code
            
        	Hashtable properties = new Hashtable();
        	properties.put(Context.INITIAL_CONTEXT_FACTORY, 
        	    "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        	properties.put(Context.PROVIDER_URL, "tcp://localhost:61616");

        	context = new InitialContext(properties);

        	javax.jms.ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
        	connect = factory.createConnection();
        	sendSession = connect.createSession(false, javax.jms.Session.AUTO_ACKNOWLEDGE);
            //connect.start(); // on peut activer la connection. 
        } catch (javax.jms.JMSException jmse){
            jmse.printStackTrace();
        } catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
 
   /**
    * Publier un message avec des hashtags
    * @param message
    * @param hashtags
    * @throws JMSException
    */
    public void publier(String message,String[] hashtags) throws JMSException{
    	TextMessage mess = sendSession.createTextMessage(message);
    	//On donne l'utilisateur
    	mess.setStringProperty("@", username);
    	//Si on plus de un hashtags cela peut générer des duplicatas
    	if( hashtags.length > 1)
    	{
    		mess.setBooleanProperty("duplica", true);
    	}
    	else
    	{
    		mess.setBooleanProperty("duplica", false);
    	}
    	
    	Topic topic;
    	for (int i = 0; i < hashtags.length; i++) {
    		
    		try {
    			//Le topic(hashTag) existe déja, il suffit de publier dedans
				topic = (Topic) context.lookup("dynamicTopics/"+hashtags[i]);
			} catch (Exception e) {
				//Si le topic n'existe pas, on le crée
				topic = sendSession.createTopic(hashtags[i]);
			}
    		// On met le  hashtag en property ce qui est un non sens mais je n'ai pas trouvé comment récupérer dans le subscriber
    		// le topic par lequel passe le message
    		mess.setStringProperty("#", topic.getTopicName());
    		sender = sendSession.createProducer(topic);
    		sender.send(mess); // equivaut à publier dans le topic
    	}
    }    
}
