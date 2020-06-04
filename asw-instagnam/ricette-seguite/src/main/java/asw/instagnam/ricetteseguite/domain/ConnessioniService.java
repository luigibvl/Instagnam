package asw.instagnam.ricetteseguite.domain;

import asw.instagnam.common.api.event.DomainEvent;
import asw.instagnam.connessioniservice.api.event.ConnessioneCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class  ConnessioniService {

	@Autowired
	private ConnessioniRepository connessioniRepository;

	/*
	piuttosto che avere un copia-incolla di codice che potrebbe impattare la modificabilità faccio riferimento
	al service asw.instagnam.connessioni.domain.ConnessioniService
	*/

	public Connessione createConnessione(Long id, String follower, String followed) {
		Connessione connessione = new Connessione(id, follower, followed);
		connessione = connessioniRepository.save(connessione);
		return connessione;
	}

	public Collection<Connessione> getConnessioniByFollowed(String followed) {
		Collection<Connessione> connessioni = connessioniRepository.findAllByFollowed(followed);
		return connessioni;
	}
}
