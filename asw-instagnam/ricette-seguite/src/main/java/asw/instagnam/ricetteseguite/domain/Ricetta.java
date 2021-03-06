package asw.instagnam.ricetteseguite.domain;

import lombok.*;

import javax.persistence.*;

/* Ricetta (in formato breve). */
@Entity
@Data
@NoArgsConstructor
public class Ricetta {

	@Id
	private Long id; 
	private String autore; 
	private String titolo;

	public Ricetta(Long id, String autore, String titolo) {
		this.id = id;
		this.autore = autore;
		this.titolo = titolo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
}
