package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Mesto database table.
 * 
 */
@Entity
@NamedQuery(name="Mesto.findAll", query="SELECT m FROM Mesto m")
public class Mesto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMesto;

	private int broj;

	private int red;

	private String sekcija;

	//bi-directional many-to-one association to Karta
	@OneToMany(mappedBy="mesto")
	private List<Karta> kartas;

	//bi-directional many-to-one association to Scena
	@ManyToOne
	@JoinColumn(name="idScena")
	private Scena scena;

	public Mesto() {
	}

	public int getIdMesto() {
		return this.idMesto;
	}

	public void setIdMesto(int idMesto) {
		this.idMesto = idMesto;
	}

	public int getBroj() {
		return this.broj;
	}

	public void setBroj(int broj) {
		this.broj = broj;
	}

	public int getRed() {
		return this.red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public String getSekcija() {
		return this.sekcija;
	}

	public void setSekcija(String sekcija) {
		this.sekcija = sekcija;
	}

	public List<Karta> getKartas() {
		return this.kartas;
	}

	public void setKartas(List<Karta> kartas) {
		this.kartas = kartas;
	}

	public Karta addKarta(Karta karta) {
		getKartas().add(karta);
		karta.setMesto(this);

		return karta;
	}

	public Karta removeKarta(Karta karta) {
		getKartas().remove(karta);
		karta.setMesto(null);

		return karta;
	}

	public Scena getScena() {
		return this.scena;
	}

	public void setScena(Scena scena) {
		this.scena = scena;
	}

}