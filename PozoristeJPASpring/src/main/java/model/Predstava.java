package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Predstava database table.
 * 
 */
@Entity
@NamedQuery(name="Predstava.findAll", query="SELECT p FROM Predstava p")
public class Predstava implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPredstava;

	private String naziv;

	private String opis;

	private int trajanje;

	//bi-directional many-to-one association to Izvodjenje
	@OneToMany(mappedBy="predstava")
	private List<Izvodjenje> izvodjenjes;

	//bi-directional many-to-one association to Omiljene
	@OneToMany(mappedBy="predstava")
	private List<Omiljene> omiljenes;

	//bi-directional many-to-one association to Reziser
	@ManyToOne
	@JoinColumn(name="idReziser")
	private Reziser reziser;

	//bi-directional many-to-one association to Uloga
	@OneToMany(mappedBy="predstava")
	private List<Uloga> ulogas;

	//bi-directional many-to-one association to ZanrPredstave
	@OneToMany(mappedBy="predstava")
	private List<ZanrPredstave> zanrPredstaves;

	public Predstava() {
	}

	public int getIdPredstava() {
		return this.idPredstava;
	}

	public void setIdPredstava(int idPredstava) {
		this.idPredstava = idPredstava;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public int getTrajanje() {
		return this.trajanje;
	}

	public void setTrajanje(int trajanje) {
		this.trajanje = trajanje;
	}

	public List<Izvodjenje> getIzvodjenjes() {
		return this.izvodjenjes;
	}

	public void setIzvodjenjes(List<Izvodjenje> izvodjenjes) {
		this.izvodjenjes = izvodjenjes;
	}

	public Izvodjenje addIzvodjenje(Izvodjenje izvodjenje) {
		getIzvodjenjes().add(izvodjenje);
		izvodjenje.setPredstava(this);

		return izvodjenje;
	}

	public Izvodjenje removeIzvodjenje(Izvodjenje izvodjenje) {
		getIzvodjenjes().remove(izvodjenje);
		izvodjenje.setPredstava(null);

		return izvodjenje;
	}

	public List<Omiljene> getOmiljenes() {
		return this.omiljenes;
	}

	public void setOmiljenes(List<Omiljene> omiljenes) {
		this.omiljenes = omiljenes;
	}

	public Omiljene addOmiljene(Omiljene omiljene) {
		getOmiljenes().add(omiljene);
		omiljene.setPredstava(this);

		return omiljene;
	}

	public Omiljene removeOmiljene(Omiljene omiljene) {
		getOmiljenes().remove(omiljene);
		omiljene.setPredstava(null);

		return omiljene;
	}

	public Reziser getReziser() {
		return this.reziser;
	}

	public void setReziser(Reziser reziser) {
		this.reziser = reziser;
	}

	public List<Uloga> getUlogas() {
		return this.ulogas;
	}

	public void setUlogas(List<Uloga> ulogas) {
		this.ulogas = ulogas;
	}

	public Uloga addUloga(Uloga uloga) {
		getUlogas().add(uloga);
		uloga.setPredstava(this);

		return uloga;
	}

	public Uloga removeUloga(Uloga uloga) {
		getUlogas().remove(uloga);
		uloga.setPredstava(null);

		return uloga;
	}

	public List<ZanrPredstave> getZanrPredstaves() {
		return this.zanrPredstaves;
	}

	public void setZanrPredstaves(List<ZanrPredstave> zanrPredstaves) {
		this.zanrPredstaves = zanrPredstaves;
	}

	public ZanrPredstave addZanrPredstave(ZanrPredstave zanrPredstave) {
		getZanrPredstaves().add(zanrPredstave);
		zanrPredstave.setPredstava(this);

		return zanrPredstave;
	}

	public ZanrPredstave removeZanrPredstave(ZanrPredstave zanrPredstave) {
		getZanrPredstaves().remove(zanrPredstave);
		zanrPredstave.setPredstava(null);

		return zanrPredstave;
	}

}