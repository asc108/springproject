package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Glumi database table.
 * 
 */
@Entity
@NamedQuery(name="Glumi.findAll", query="SELECT g FROM Glumi g")
public class Glumi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idGlumi;

	//bi-directional many-to-one association to Glumac
	@ManyToOne
	@JoinColumn(name="idGlumac")
	private Glumac glumac;

	//bi-directional many-to-one association to Uloga
	@ManyToOne
	@JoinColumn(name="idUloga")
	private Uloga uloga;

	//bi-directional many-to-one association to GlumiUIzvodjenju
	@OneToMany(mappedBy="glumi")
	private List<GlumiUIzvodjenju> glumiUizvodjenjus;

	public Glumi() {
	}

	public int getIdGlumi() {
		return this.idGlumi;
	}

	public void setIdGlumi(int idGlumi) {
		this.idGlumi = idGlumi;
	}

	public Glumac getGlumac() {
		return this.glumac;
	}

	public void setGlumac(Glumac glumac) {
		this.glumac = glumac;
	}

	public Uloga getUloga() {
		return this.uloga;
	}

	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}

	public List<GlumiUIzvodjenju> getGlumiUizvodjenjus() {
		return this.glumiUizvodjenjus;
	}

	public void setGlumiUizvodjenjus(List<GlumiUIzvodjenju> glumiUizvodjenjus) {
		this.glumiUizvodjenjus = glumiUizvodjenjus;
	}

	public GlumiUIzvodjenju addGlumiUizvodjenjus(GlumiUIzvodjenju glumiUizvodjenjus) {
		getGlumiUizvodjenjus().add(glumiUizvodjenjus);
		glumiUizvodjenjus.setGlumi(this);

		return glumiUizvodjenjus;
	}

	public GlumiUIzvodjenju removeGlumiUizvodjenjus(GlumiUIzvodjenju glumiUizvodjenjus) {
		getGlumiUizvodjenjus().remove(glumiUizvodjenjus);
		glumiUizvodjenjus.setGlumi(null);

		return glumiUizvodjenjus;
	}

}