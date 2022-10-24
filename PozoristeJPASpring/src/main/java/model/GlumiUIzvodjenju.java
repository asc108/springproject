package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the GlumiUIzvodjenju database table.
 * 
 */
@Entity
@NamedQuery(name="GlumiUIzvodjenju.findAll", query="SELECT g FROM GlumiUIzvodjenju g")
public class GlumiUIzvodjenju implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idGlumiUIzvodjenju;

	//bi-directional many-to-one association to Glumi
	@ManyToOne
	@JoinColumn(name="idGlumi")
	private Glumi glumi;

	//bi-directional many-to-one association to Izvodjenje
	@ManyToOne
	@JoinColumn(name="idIzvodjenje")
	private Izvodjenje izvodjenje;

	public GlumiUIzvodjenju() {
	}

	public int getIdGlumiUIzvodjenju() {
		return this.idGlumiUIzvodjenju;
	}

	public void setIdGlumiUIzvodjenju(int idGlumiUIzvodjenju) {
		this.idGlumiUIzvodjenju = idGlumiUIzvodjenju;
	}

	public Glumi getGlumi() {
		return this.glumi;
	}

	public void setGlumi(Glumi glumi) {
		this.glumi = glumi;
	}

	public Izvodjenje getIzvodjenje() {
		return this.izvodjenje;
	}

	public void setIzvodjenje(Izvodjenje izvodjenje) {
		this.izvodjenje = izvodjenje;
	}

}