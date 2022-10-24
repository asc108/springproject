package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Glumac database table.
 * 
 */
@Entity
@NamedQuery(name="Glumac.findAll", query="SELECT g FROM Glumac g")
public class Glumac implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idGlumac;

	private String ime;

	private String prezime;

	//bi-directional many-to-one association to Glumi
	@OneToMany(mappedBy="glumac")
	private List<Glumi> glumis;

	public Glumac() {
	}

	public int getIdGlumac() {
		return this.idGlumac;
	}

	public void setIdGlumac(int idGlumac) {
		this.idGlumac = idGlumac;
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

	public List<Glumi> getGlumis() {
		return this.glumis;
	}

	public void setGlumis(List<Glumi> glumis) {
		this.glumis = glumis;
	}

	public Glumi addGlumi(Glumi glumi) {
		getGlumis().add(glumi);
		glumi.setGlumac(this);

		return glumi;
	}

	public Glumi removeGlumi(Glumi glumi) {
		getGlumis().remove(glumi);
		glumi.setGlumac(null);

		return glumi;
	}

}