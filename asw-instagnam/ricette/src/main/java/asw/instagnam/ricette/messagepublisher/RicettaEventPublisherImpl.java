package asw.instagnam.ricette.messagepublisher;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import asw.instagnam.common.api.event.DomainEvent;
import asw.instagnam.ricetteservice.api.event.RicettaCreatedEvent;


@Component 
public class RicettaEventPublisherImpl implements RicettaEventPublisher {

    private final Logger logger = Logger.getLogger(RicettaEventPublisherImpl.class.toString());
	
	@Value("${asw.kafka.channel.out}")
    private String channel;
	
	@Autowired
	private KafkaTemplate<String, DomainEvent> template;
	
	@Override
	public void publish(DomainEvent event) {
		logger.info("RICETTA PUBLISHING EVENT: " + ((RicettaCreatedEvent)event).getId().toString() + " " + ((RicettaCreatedEvent)event).getAutore() +" "+ ((RicettaCreatedEvent)event).getTitolo() + " ON CHANNEL: " + channel);
        template.send(channel, event);	
	}

}
