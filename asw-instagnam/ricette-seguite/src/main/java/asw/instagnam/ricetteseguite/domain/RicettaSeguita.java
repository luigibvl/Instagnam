package asw.instagnam.ricetteseguite.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class RicettaSeguita {

    @Id
    @GeneratedValue
    private Long id;
    private Long idRicetta;
    private String follower;
    private String autore;
    private String titolo;

    public RicettaSeguita(Long idRicetta, String follower, String autore, String titolo) {
        this.idRicetta = idRicetta;
        this.follower = follower;
        this.autore = autore;
        this.titolo = titolo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getIdRicetta() {
        return idRicetta;
    }

    public void setIdRicetta(Long idRicetta) {
        this.idRicetta = idRicetta;
    }

    public String getFollower() {
        return follower;
    }

    public void setFollower(String follower) {
        this.follower = follower;
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
