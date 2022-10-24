package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Ocena database table.
 * 
 */
@Entity
@NamedQuery(name="Ocena.findAll", query="SELECT o FROM Ocena o")
public class Ocena implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOcena;

	private String komentar;

	private String ocena;

	//bi-directional many-to-one association to Izvodjenje
	@ManyToOne
	@JoinColumn(name="idIzvodjenje")
	private Izvodjenje izvodjenje;

	//bi-directional many-to-one association to Posetilac
	@ManyToOne
	@JoinColumn(name="idPosetilac")
	private Posetilac posetilac;

	public Ocena() {
	}

	public int getIdOcena() {
		return this.idOcena;
	}

	public void setIdOcena(int idOcena) {
		this.idOcena = idOcena;
	}

	public String getKomentar() {
		return this.komentar;
	}

	public void setKomentar(String komentar) {
		this.komentar = komentar;
	}

	public String getOcena() {
		return this.ocena;
	}

	public void setOcena(String ocena) {
		this.ocena = ocena;
	}

	public Izvodjenje getIzvodjenje() {
		return this.izvodjenje;
	}

	public void setIzvodjenje(Izvodjenje izvodjenje) {
		this.izvodjenje = izvodjenje;
	}

	public Posetilac getPosetilac() {
		return this.posetilac;
	}

	public void setPosetilac(Posetilac posetilac) {
		this.posetilac = posetilac;
	}

}