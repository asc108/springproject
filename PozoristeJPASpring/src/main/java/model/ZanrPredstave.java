package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ZanrPredstave database table.
 * 
 */
@Entity
@NamedQuery(name="ZanrPredstave.findAll", query="SELECT z FROM ZanrPredstave z")
public class ZanrPredstave implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idZanrPredstave;

	//bi-directional many-to-one association to Predstava
	@ManyToOne
	@JoinColumn(name="idPredstava")
	private Predstava predstava;

	//bi-directional many-to-one association to Zanr
	@ManyToOne
	@JoinColumn(name="idZanr")
	private Zanr zanr;

	public ZanrPredstave() {
	}

	public int getIdZanrPredstave() {
		return this.idZanrPredstave;
	}

	public void setIdZanrPredstave(int idZanrPredstave) {
		this.idZanrPredstave = idZanrPredstave;
	}

	public Predstava getPredstava() {
		return this.predstava;
	}

	public void setPredstava(Predstava predstava) {
		this.predstava = predstava;
	}

	public Zanr getZanr() {
		return this.zanr;
	}

	public void setZanr(Zanr zanr) {
		this.zanr = zanr;
	}

}