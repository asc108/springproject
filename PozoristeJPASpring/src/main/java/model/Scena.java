package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Scena database table.
 * 
 */
@Entity
@NamedQuery(name="Scena.findAll", query="SELECT s FROM Scena s")
public class Scena implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idScena;

	private String naziv;

	//bi-directional many-to-one association to Izvodjenje
	@OneToMany(mappedBy="scena")
	private List<Izvodjenje> izvodjenjes;

	//bi-directional many-to-one association to Mesto
	@OneToMany(mappedBy="scena")
	private List<Mesto> mestos;

	public Scena() {
	}

	public int getIdScena() {
		return this.idScena;
	}

	public void setIdScena(int idScena) {
		this.idScena = idScena;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Izvodjenje> getIzvodjenjes() {
		return this.izvodjenjes;
	}

	public void setIzvodjenjes(List<Izvodjenje> izvodjenjes) {
		this.izvodjenjes = izvodjenjes;
	}

	public Izvodjenje addIzvodjenje(Izvodjenje izvodjenje) {
		getIzvodjenjes().add(izvodjenje);
		izvodjenje.setScena(this);

		return izvodjenje;
	}

	public Izvodjenje removeIzvodjenje(Izvodjenje izvodjenje) {
		getIzvodjenjes().remove(izvodjenje);
		izvodjenje.setScena(null);

		return izvodjenje;
	}

	public List<Mesto> getMestos() {
		return this.mestos;
	}

	public void setMestos(List<Mesto> mestos) {
		this.mestos = mestos;
	}

	public Mesto addMesto(Mesto mesto) {
		getMestos().add(mesto);
		mesto.setScena(this);

		return mesto;
	}

	public Mesto removeMesto(Mesto mesto) {
		getMestos().remove(mesto);
		mesto.setScena(null);

		return mesto;
	}

}