package asw.instagnam.ricetteseguite.messagelistener;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import asw.instagnam.common.api.event.DomainEvent;
import asw.instagnam.connessioniservice.api.event.ConnessioneCreatedEvent;
import asw.instagnam.ricetteservice.api.event.RicettaCreatedEvent;

@Service 
public class ConsumerService {
	
    private final Logger logger = Logger.getLogger(ConsumerService.class.toString());

	//invocata ogni volta che si riceve un messaggio dal canale a cui si abbona    
    public void onMessage(DomainEvent event) {
    	if (event.getClass().equals(ConnessioneCreatedEvent.class)) {
    		logger.info("CONNESSIONE RECEIVED");
    		String logMessage = ((ConnessioneCreatedEvent) event).getFollower()+" "+ ((ConnessioneCreatedEvent) event).getFollowed();
    		logger.info(logMessage);
    	}
        else if(event.getClass().equals(RicettaCreatedEvent.class)) {
        	logger.info("RICETTA RECEIVED");
    		String logMessage = ((RicettaCreatedEvent) event).getAutore() +" "+ ((RicettaCreatedEvent) event).getTitolo()+" "+((RicettaCreatedEvent) event).getPreparazione();
    		logger.info(logMessage);
        }
	}
    
}
