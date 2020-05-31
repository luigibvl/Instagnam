package asw.instagnam.ricette.messagepublisher;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component 
public class RicettaEventPublisherImpl implements RicettaEventPublisher {

    private final Logger logger = Logger.getLogger(RicettaEventPublisherImpl.class.toString());
	
	@Value("${asw.kafka.channel.out}")
    private String channel;
	
	@Autowired
	private KafkaTemplate<String, Event> template;
	
	@Override
	public void publish(Event event) {
		logger.info("PUBLISHING EVENT: " + ((RicettaCreatedEvent)event).getAutore().toString() +" "+ ((RicettaCreatedEvent)event).getTitolo().toString()+" "+((RicettaCreatedEvent)event).getPreparazione().toString()+ " ON CHANNEL: " + channel);
        template.send(channel, event);	
	}
	
//	@Autowired
//	private KafkaTemplate<String, String> template;
//	
//	@Override
//	public void publish() {
//		String event="ricetta stupid event";
//		logger.info("PUBLISHING EVENT: " +event.toString()+ " ON CHANNEL: " + channel);
//        template.send(channel, event);	
//	}

}
