package asw.instagnam.ricetteservice.api.event;

import asw.instagnam.common.api.event.DomainEvent; 

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//evento da pubblicare
@Data
@NoArgsConstructor
//@AllArgsConstructor
public class RicettaCreatedEvent implements DomainEvent {

	//private Long id; 
	private String autore;
	private String titolo;
	private String preparazione;

	public RicettaCreatedEvent(String autore, String titolo, String preparazione) {
		this.autore = autore;
		this.titolo = titolo;
		this.preparazione = preparazione;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getPreparazione() {
		return preparazione;
	}

	public void setPreparazione(String preparazione) {
		this.preparazione = preparazione;
	}

}
