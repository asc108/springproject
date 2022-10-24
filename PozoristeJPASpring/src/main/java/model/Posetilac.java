package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Posetilac database table.
 * 
 */
@Entity
@NamedQuery(name="Posetilac.findAll", query="SELECT p FROM Posetilac p")
public class Posetilac implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPosetilac;

	private String email;

	private String ime;

	private String password;

	private String prezime;

	private String username;

	//bi-directional many-to-one association to Karta
	@OneToMany(mappedBy="posetilac")
	private List<Karta> kartas;

	//bi-directional many-to-one association to Ocena
	@OneToMany(mappedBy="posetilac")
	private List<Ocena> ocenas;

	//bi-directional many-to-one association to Omiljene
	@OneToMany(mappedBy="posetilac")
	private List<Omiljene> omiljenes;

	public Posetilac() {
	}

	public int getIdPosetilac() {
		return this.idPosetilac;
	}

	public void setIdPosetilac(int idPosetilac) {
		this.idPosetilac = idPosetilac;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Karta> getKartas() {
		return this.kartas;
	}

	public void setKartas(List<Karta> kartas) {
		this.kartas = kartas;
	}

	public Karta addKarta(Karta karta) {
		getKartas().add(karta);
		karta.setPosetilac(this);

		return karta;
	}

	public Karta removeKarta(Karta karta) {
		getKartas().remove(karta);
		karta.setPosetilac(null);

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
		ocena.setPosetilac(this);

		return ocena;
	}

	public Ocena removeOcena(Ocena ocena) {
		getOcenas().remove(ocena);
		ocena.setPosetilac(null);

		return ocena;
	}

	public List<Omiljene> getOmiljenes() {
		return this.omiljenes;
	}

	public void setOmiljenes(List<Omiljene> omiljenes) {
		this.omiljenes = omiljenes;
	}

	public Omiljene addOmiljene(Omiljene omiljene) {
		getOmiljenes().add(omiljene);
		omiljene.setPosetilac(this);

		return omiljene;
	}

	public Omiljene removeOmiljene(Omiljene omiljene) {
		getOmiljenes().remove(omiljene);
		omiljene.setPosetilac(null);

		return omiljene;
	}

}