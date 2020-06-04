package asw.instagnam.ricetteseguite.domain;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@Service
public class RicetteService {

	@Autowired
	private RicetteRepository ricetteRepository;

	public Ricetta createRicetta(Long id, String autore, String titolo) {
		Ricetta ricetta = new Ricetta(id, autore, titolo);
		ricetta = ricetteRepository.save(ricetta);
		return ricetta;
	}

	public  Collection<Ricetta> getRicetteByAutore(String autore){
		return ricetteRepository.findAllByAutore(autore);
	}


}
