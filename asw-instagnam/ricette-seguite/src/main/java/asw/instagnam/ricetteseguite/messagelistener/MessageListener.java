package asw.instagnam.ricetteseguite.messagelistener;

import java.util.logging.Logger;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import asw.instagnam.common.api.event.DomainEvent;
import asw.instagnam.connessioniservice.api.event.ConnessioneCreatedEvent;
import asw.instagnam.ricetteservice.api.event.RicettaCreatedEvent;




@Component 
public class MessageListener {
	
    private final Logger logger = Logger.getLogger(MessageListener.class.toString());
	
    @Autowired
    private ConsumerService consumerService;
    
    @Value("${asw.kafka.channel.in}")
	private String channel;

	@Value("${asw.kafka.groupid}")
	private String groupId;
    
    @KafkaListener(topics = "${asw.kafka.channel.in}", groupId="${asw.kafka.groupid}")
    public void listen(ConsumerRecord<String, DomainEvent> record) throws Exception {
        logger.info("MESSAGE LISTENER: EVENT RECEIVED");
        consumerService.onMessage(record.value());
    }

}

