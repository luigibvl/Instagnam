package asw.instagnam.ricetteseguite.messagelistener;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import asw.instagnam.ricetteseguite.domain.ConnessioneCreatedEvent;
import asw.instagnam.ricetteseguite.domain.RicettaCreatedEvent;

@Service 
public class ConsumerService {
	
    private final Logger logger = Logger.getLogger(ConsumerService.class.toString());

	//invocata ogni volta che si riceve un messaggio dal canale a cui si abbona
    public void onMessage(RicettaCreatedEvent event) {
		String logMessage = event.getAutore() +" "+ event.getTitolo()+" "+event.getPreparazione();
		logger.info(logMessage);
	}
    public void onMessageBeta(ConnessioneCreatedEvent event) {
		String logMessage = event.getFollower()+" "+ event.getFollowed();
		logger.info(logMessage);
	}
    
    public void onMessage(String event) {
		logger.info(event);
	}
}
