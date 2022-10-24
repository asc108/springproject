package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Reziser database table.
 * 
 */
@Entity
@NamedQuery(name="Reziser.findAll", query="SELECT r FROM Reziser r")
public class Reziser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idReziser;

	private String ime;

	private String prezime;

	//bi-directional many-to-one association to Predstava
	@OneToMany(mappedBy="reziser")
	private List<Predstava> predstavas;

	public Reziser() {
	}

	public int getIdReziser() {
		return this.idReziser;
	}

	public void setIdReziser(int idReziser) {
		this.idReziser = idReziser;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public List<Predstava> getPredstavas() {
		return this.predstavas;
	}

	public void setPredstavas(List<Predstava> predstavas) {
		this.predstavas = predstavas;
	}

	public Predstava addPredstava(Predstava predstava) {
		getPredstavas().add(predstava);
		predstava.setReziser(this);

		return predstava;
	}

	public Predstava removePredstava(Predstava predstava) {
		getPredstavas().remove(predstava);
		predstava.setReziser(null);

		return predstava;
	}

}