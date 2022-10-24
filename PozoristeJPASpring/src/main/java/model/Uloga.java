package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Uloga database table.
 * 
 */
@Entity
@NamedQuery(name="Uloga.findAll", query="SELECT u FROM Uloga u")
public class Uloga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUloga;

	private String naziv;

	//bi-directional many-to-one association to Glumi
	@OneToMany(mappedBy="uloga")
	private List<Glumi> glumis;

	//bi-directional many-to-one association to Predstava
	@ManyToOne
	@JoinColumn(name="idPredstava")
	private Predstava predstava;

	public Uloga() {
	}

	public int getIdUloga() {
		return this.idUloga;
	}

	public void setIdUloga(int idUloga) {
		this.idUloga = idUloga;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Glumi> getGlumis() {
		return this.glumis;
	}

	public void setGlumis(List<Glumi> glumis) {
		this.glumis = glumis;
	}

	public Glumi addGlumi(Glumi glumi) {
		getGlumis().add(glumi);
		glumi.setUloga(this);

		return glumi;
	}

	public Glumi removeGlumi(Glumi glumi) {
		getGlumis().remove(glumi);
		glumi.setUloga(null);

		return glumi;
	}

	public Predstava getPredstava() {
		return this.predstava;
	}

	public void setPredstava(Predstava predstava) {
		this.predstava = predstava;
	}

}