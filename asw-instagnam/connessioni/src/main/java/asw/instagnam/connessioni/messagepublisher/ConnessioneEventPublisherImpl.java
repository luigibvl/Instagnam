package asw.instagnam.connessioni.messagepublisher;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component 
public class ConnessioneEventPublisherImpl implements ConnessioneEventPublisher{

	  private final Logger logger = Logger.getLogger(ConnessioneEventPublisherImpl.class.toString());
		
	  	@Value("${asw.kafka.channel.out}")
	    private String channel;
		
		@Autowired
		private KafkaTemplate<String,Event> template;
		
//		@Override
//		public void publish() {
//			String event="connessione stupid event";
//			logger.info("PUBLISHING EVENT: " + event.toString() + " ON CHANNEL: " + channel);
//	        template.send(channel, event);	
//		}
		
		@Override
		public void publish(Event event) {
			logger.info("PUBLISHING EVENT: " + ((ConnessioneCreatedEvent)event).getFollower() +" "+((ConnessioneCreatedEvent)event).getFollowed() +" ON CHANNEL: " + channel);
	        template.send(channel, event);	
		}
		
}
