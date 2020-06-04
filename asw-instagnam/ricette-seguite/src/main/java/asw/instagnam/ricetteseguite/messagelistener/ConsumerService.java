package asw.instagnam.ricetteseguite.messagelistener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

import asw.instagnam.ricetteseguite.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asw.instagnam.common.api.event.DomainEvent;
import asw.instagnam.connessioniservice.api.event.ConnessioneCreatedEvent;
import asw.instagnam.ricetteservice.api.event.RicettaCreatedEvent;

@Service 
public class ConsumerService {

	@Autowired
	private RicetteSeguiteService ricetteSeguiteService;

    @Autowired
	private ConnessioniService connessioniService;

    @Autowired
	private RicetteService ricetteService;

    private final Logger logger = Logger.getLogger(ConsumerService.class.toString());


	//invocata ogni volta che si riceve un messaggio dal canale a cui si abbona    
    public void onMessage(DomainEvent event) {
    	if (event.getClass().equals(ConnessioneCreatedEvent.class)) {
    		logger.info("CONNESSIONE RECEIVED");
			Long id = ((ConnessioneCreatedEvent) event).getId();
    		String follower = ((ConnessioneCreatedEvent) event).getFollower();
    		String followed = ((ConnessioneCreatedEvent) event).getFollowed();

    		/*String logMessage = follower +" "+ followed;
			logger.info(logMessage);*/

			//salvo la connessione nella tabella connessioni
			logger.info(connessioniService.createConnessione(id,follower,followed).toString());
			//nuova connessione = collezione di nuove ricette seguite
			//devo caricare tutte le ricette seguite da followed di followed
			Collection<Ricetta> ricetteByFollowed = ricetteService.getRicetteByAutore(followed);
			Collection<RicettaSeguita> ricetteSeguite = new ArrayList<>();
			for (Ricetta ricetta : ricetteByFollowed) {
				RicettaSeguita ricettaSeguita = new RicettaSeguita(ricetta.getId(), follower, ricetta.getAutore(), ricetta.getTitolo());
				ricetteSeguite.add(ricettaSeguita);
				logger.info(ricettaSeguita.toString());
			}
			ricetteSeguiteService.createRicetteSeguite(ricetteSeguite);
    	}
        else if(event.getClass().equals(RicettaCreatedEvent.class)) {
        	logger.info("RICETTA RECEIVED");
        	Long id = ((RicettaCreatedEvent) event).getId();
        	String autore = ((RicettaCreatedEvent) event).getAutore();
        	String titolo = ((RicettaCreatedEvent) event).getTitolo();

        	//salvo la ricetta nella tabella ricette
			logger.info(ricetteService.createRicetta(id, autore, titolo).toString());

			//nuova ricetta = aggiornare le ricette seguite di tutti i follower dell'autore della ricetta
			Collection<Connessione> connessioniByFollowedAutore = connessioniService.getConnessioniByFollowed(autore);
			Collection<RicettaSeguita> ricetteSeguite = new ArrayList<>();
			for (Connessione connessione : connessioniByFollowedAutore) {
				RicettaSeguita ricettaSeguita = new RicettaSeguita(id, connessione.getFollower(), autore, titolo);
				ricetteSeguite.add(ricettaSeguita);
				logger.info(ricettaSeguita.toString());
			}
			ricetteSeguiteService.createRicetteSeguite(ricetteSeguite);
        }
	}
    
}
