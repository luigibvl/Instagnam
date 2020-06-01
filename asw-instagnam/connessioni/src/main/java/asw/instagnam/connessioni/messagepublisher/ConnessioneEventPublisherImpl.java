package asw.instagnam.connessioni.messagepublisher;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import asw.instagnam.common.api.event.DomainEvent;
import asw.instagnam.connessioniservice.api.event.ConnessioneCreatedEvent;

@Component 
public class ConnessioneEventPublisherImpl implements ConnessioneEventPublisher{

	  private final Logger logger = Logger.getLogger(ConnessioneEventPublisherImpl.class.toString());
		
	  	@Value("${asw.kafka.channel.out}")
	    private String channel;
		
		@Autowired
		private KafkaTemplate<String, DomainEvent> template;
		
		@Override
		public void publish(DomainEvent event) {
			logger.info("CONNESSIONI PUBLISHING EVENT: " + ((ConnessioneCreatedEvent)event).getFollower() +" "+((ConnessioneCreatedEvent)event).getFollowed() +" ON CHANNEL: " + channel);
	        template.send(channel, event);	
		}
		
}
