package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Izvodjenje database table.
 * 
 */
@Entity
@NamedQuery(name="Izvodjenje.findAll", query="SELECT i FROM Izvodjenje i")
public class Izvodjenje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idIzvodjenje;

	@Temporal(TemporalType.DATE)
	private Date datum;

	//bi-directional many-to-one association to GlumiUIzvodjenju
	@OneToMany(mappedBy="izvodjenje")
	private List<GlumiUIzvodjenju> glumiUizvodjenjus;

	//bi-directional many-to-one association to Predstava
	@ManyToOne
	@JoinColumn(name="idPredstava")
	private Predstava predstava;

	//bi-directional many-to-one association to Scena
	@ManyToOne
	@JoinColumn(name="idScena")
	private Scena scena;

	//bi-directional many-to-one association to Karta
	@OneToMany(mappedBy="izvodjenje")
	private List<Karta> kartas;

	//bi-directional many-to-one association to Ocena
	@OneToMany(mappedBy="izvodjenje")
	private List<Ocena> ocenas;

	public Izvodjenje() {
	}

	public int getIdIzvodjenje() {
		return this.idIzvodjenje;
	}

	public void setIdIzvodjenje(int idIzvodjenje) {
		this.idIzvodjenje = idIzvodjenje;
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public List<GlumiUIzvodjenju> getGlumiUizvodjenjus() {
		return this.glumiUizvodjenjus;
	}

	public void setGlumiUizvodjenjus(List<GlumiUIzvodjenju> glumiUizvodjenjus) {
		this.glumiUizvodjenjus = glumiUizvodjenjus;
	}

	public GlumiUIzvodjenju addGlumiUizvodjenjus(GlumiUIzvodjenju glumiUizvodjenjus) {
		getGlumiUizvodjenjus().add(glumiUizvodjenjus);
		glumiUizvodjenjus.setIzvodjenje(this);

		return glumiUizvodjenjus;
	}

	public GlumiUIzvodjenju removeGlumiUizvodjenjus(GlumiUIzvodjenju glumiUizvodjenjus) {
		getGlumiUizvodjenjus().remove(glumiUizvodjenjus);
		glumiUizvodjenjus.setIzvodjenje(null);

		return glumiUizvodjenjus;
	}

	public Predstava getPredstava() {
		return this.predstava;
	}

	public void setPredstava(Predstava predstava) {
		this.predstava = predstava;
	}

	public Scena getScena() {
		return this.scena;
	}

	public void setScena(Scena scena) {
		this.scena = scena;
	}

	public List<Karta> getKartas() {
		return this.kartas;
	}

	public void setKartas(List<Karta> kartas) {
		this.kartas = kartas;
	}

	public Karta addKarta(Karta karta) {
		getKartas().add(karta);
		karta.setIzvodjenje(this);

		return karta;
	}

	public Karta removeKarta(Karta karta) {
		getKartas().remove(karta);
		karta.setIzvodjenje(null);

		return karta;
	}

	public List<Ocena> getOcenas() {
		return this.ocenas;
	}

	public void setOcenas(List<Ocena> ocenas) {
		this.ocenas = ocenas;
	}

	public Ocena addOcena(Ocena ocena) {
		getOcenas().add(ocena);
		ocena.setIzvodjenje(this);

		return ocena;
	}

	public Ocena removeOcena(Ocena ocena) {
		getOcenas().remove(ocena);
		ocena.setIzvodjenje(null);

		return ocena;
	}

}