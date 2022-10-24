package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Omiljene database table.
 * 
 */
@Entity
@NamedQuery(name="Omiljene.findAll", query="SELECT o FROM Omiljene o")
public class Omiljene implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOmiljene;

	//bi-directional many-to-one association to Posetilac
	@ManyToOne
	@JoinColumn(name="idPosetilac")
	private Posetilac posetilac;

	//bi-directional many-to-one association to Predstava
	@ManyToOne
	@JoinColumn(name="idPredstava")
	private Predstava predstava;

	public Omiljene() {
	}

	public int getIdOmiljene() {
		return this.idOmiljene;
	}

	public void setIdOmiljene(int idOmiljene) {
		this.idOmiljene = idOmiljene;
	}

	public Posetilac getPosetilac() {
		return this.posetilac;
	}

	public void setPosetilac(Posetilac posetilac) {
		this.posetilac = posetilac;
	}

	public Predstava getPredstava() {
		return this.predstava;
	}

	public void setPredstava(Predstava predstava) {
		this.predstava = predstava;
	}

}