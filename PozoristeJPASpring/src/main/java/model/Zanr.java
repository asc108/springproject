package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Zanr database table.
 * 
 */
@Entity
@NamedQuery(name="Zanr.findAll", query="SELECT z FROM Zanr z")
public class Zanr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idZanr;

	private String naziv;

	//bi-directional many-to-one association to ZanrPredstave
	@OneToMany(mappedBy="zanr")
	private List<ZanrPredstave> zanrPredstaves;

	public Zanr() {
	}

	public int getIdZanr() {
		return this.idZanr;
	}

	public void setIdZanr(int idZanr) {
		this.idZanr = idZanr;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<ZanrPredstave> getZanrPredstaves() {
		return this.zanrPredstaves;
	}

	public void setZanrPredstaves(List<ZanrPredstave> zanrPredstaves) {
		this.zanrPredstaves = zanrPredstaves;
	}

	public ZanrPredstave addZanrPredstave(ZanrPredstave zanrPredstave) {
		getZanrPredstaves().add(zanrPredstave);
		zanrPredstave.setZanr(this);

		return zanrPredstave;
	}

	public ZanrPredstave removeZanrPredstave(ZanrPredstave zanrPredstave) {
		getZanrPredstaves().remove(zanrPredstave);
		zanrPredstave.setZanr(null);

		return zanrPredstave;
	}

}