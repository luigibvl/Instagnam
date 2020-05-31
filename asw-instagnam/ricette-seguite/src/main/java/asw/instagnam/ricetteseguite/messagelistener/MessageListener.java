package asw.instagnam.ricetteseguite.messagelistener;

import java.util.logging.Logger;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import asw.instagnam.ricetteseguite.domain.ConnessioneCreatedEvent;
import asw.instagnam.ricetteseguite.domain.Event;
import asw.instagnam.ricetteseguite.domain.RicettaCreatedEvent;




@Component 
public class MessageListener {
	
    private final Logger logger = Logger.getLogger(MessageListener.class.toString());
	
    @Autowired
    private ConsumerService consumerService;
    
    @KafkaListener(topics = {"${asw.kafka.channel.alpha}","${asw.kafka.channel.beta}"})//, groupId="${asw.kafka.groupid}")
    public void listen(ConsumerRecord<String, Event> record) throws Exception {
        logger.info("Ricette-seguite MESSAGE LISTENER: " + record.toString());
        Event event = record.value();
        if (event.getClass().equals(ConnessioneCreatedEvent.class))
        	consumerService.onMessageBeta((ConnessioneCreatedEvent)event);
        else if(event.getClass().equals(RicettaCreatedEvent.class))
        	consumerService.onMessage((RicettaCreatedEvent)event); 
    }
    
//    @KafkaListener(topics = {"${asw.kafka.channel.alpha}"})//, groupId="${asw.kafka.groupid}")
//    public void listen(ConsumerRecord<String, RicettaCreatedEvent> record) throws Exception {
//        logger.info("Ricette-seguite MESSAGE LISTENER: " + record.toString());
//        RicettaCreatedEvent message = record.value();
//        consumerService.onMessage(message); 
//
//    }
//    
//    @KafkaListener(topics = {"${asw.kafka.channel.beta}"})//, groupId="${asw.kafka.groupid}")
//    public void listenToChannelBeta(ConsumerRecord<String, ConnessioneCreatedEvent> record) throws Exception {
//        logger.info("Ricette-seguite MESSAGE LISTENER: " + record.toString());
//        ConnessioneCreatedEvent message = record.value();
//        consumerService.onMessageBeta(message); 
//    }


}

