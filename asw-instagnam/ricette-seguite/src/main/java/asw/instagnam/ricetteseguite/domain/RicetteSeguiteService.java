package asw.instagnam.ricetteseguite.domain;

import asw.instagnam.common.api.event.DomainEvent;
import asw.instagnam.connessioniservice.api.event.ConnessioneCreatedEvent;
import asw.instagnam.ricetteservice.api.event.RicettaCreatedEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@Service
public class RicetteSeguiteService {
	@Autowired
	RicetteSeguiteRepository ricetteSeguiteRepository;

	/* Trova le ricette (in formato breve) degli utenti seguiti da utente. */
	public Collection<RicettaSeguita> getRicetteSeguite(String utente) {
		return ricetteSeguiteRepository.findAllByFollower(utente);
	}

	public void createRicetteSeguite(Collection<RicettaSeguita> ricetteSeguite){
		ricetteSeguiteRepository.saveAll(ricetteSeguite);
	}



}
