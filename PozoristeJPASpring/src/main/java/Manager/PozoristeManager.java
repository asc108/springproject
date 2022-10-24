package Manager;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import Util.JPAUtil;
import model.Glumi;
import model.Izvodjenje;
import model.Karta;
import model.Mesto;
import model.Posetilac;
import model.Predstava;
import model.Uloga;
import model.Zanr;

public class PozoristeManager {

	public Posetilac savePosetilac(String ime, String prezime) {
		try {
			EntityManager em = JPAUtil.getEntityManager();

			Posetilac p = new Posetilac();
			p.setIme(ime);
			p.setPrezime(prezime);

			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
			return p;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

	public List<Izvodjenje> getIzovdjenjes(String nazivPredstave) {
		EntityManager em = JPAUtil.getEntityManager();
		List<Izvodjenje> i = em.createQuery("select i from Izvodjenje i where i.predstava.naziv like :nazivPredstave",
				Izvodjenje.class).setParameter("nazivPredstave", nazivPredstave).getResultList();
		return i;
	}

	public List<Date> getDatumIzvodjenjaPredstave(String nazivPredstave) {
		EntityManager em = JPAUtil.getEntityManager();
		List<Date> datumiIzvodjenja = em
				.createQuery("select i.datum from Izvodjenje i where i.predstava.naziv " + "like :nazivPredstave",
						Date.class)
				.setParameter("nazivPredstave", nazivPredstave).getResultList();
		return datumiIzvodjenja;
	}

	public List<Mesto> prikaziSlobodnaMesta(String nazivPredstave, Date datumIzvodjenja) {
		EntityManager em = JPAUtil.getEntityManager();
		List<Mesto> slobodnaMesta = em
				.createQuery("select m from Mesto m inner join m.scena.izvodjenjes i where i.predstava.naziv "
						+ "like :nazivPredstave and i.datum like :datumIzvodjenja and not exists"
						+ "(select k.mesto from Karta k where k.mesto=m and k.izvodjenje=i)", Mesto.class)
				.setParameter("nazivPredstave", nazivPredstave).setParameter("datumIzvodjenja", datumIzvodjenja)
				.getResultList();
		return slobodnaMesta;
	}

	public Karta rezervacija(int idPosetilac, int idIzvodjenje, int idMesto) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			Posetilac p = em.find(Posetilac.class, idPosetilac);
			Izvodjenje i = em.find(Izvodjenje.class, idIzvodjenje);
			Mesto m = em.find(Mesto.class, idMesto);

			List<Karta> karte = em.createQuery(
					"select k from Karta k where k.mesto.idMesto = :idMesto and k.izvodjenje.idIzvodjenje = :idIzvodjenje")
					.setParameter("idMesto", idMesto).setParameter("idIzvodjenje", idIzvodjenje).getResultList();
			if (karte == null) {
				System.err.println("Rezervisano!");
				return null;
			} else {
				Karta k = new Karta();
				k.setPosetilac(p);
				k.setIzvodjenje(i);
				k.setMesto(m);
				k.setDatumRezervacije(new Date());

				em.getTransaction().begin();
				em.persist(k);
				em.getTransaction().commit();

				return k;
			}
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return null;
		}
	}
	public List<Zanr> getSviZanrovi() {
		EntityManager em = JPAUtil.getEntityManager();
		List<Zanr> zanrovi = em.createQuery("select z from Zanr z", Zanr.class).getResultList();
		return zanrovi;
	}
	
	public List<Predstava> getSvePredstave(int idZanr) {
		EntityManager em = JPAUtil.getEntityManager();
		List<Predstava> predstave = em.createQuery("select p from Predstava p inner join p.zanrPredstaves z where "
				+ "z.zanr.idZanr=:id", Predstava.class).setParameter("id", idZanr).getResultList();
		return predstave;
	}
	
	public List<Uloga> getSveUloge(int idPredst) {
		EntityManager em = JPAUtil.getEntityManager();
		List<Uloga> uloge = em.createQuery("select u from Uloga u where u.predstava.idPredstava=:id", Uloga.class)
				.setParameter("id", idPredst).getResultList();
		return uloge;
	}
	
	public List<Glumi> getSviGlumci(int idPredst) {
		EntityManager em = JPAUtil.getEntityManager();
		List<Glumi> glumi = em.createQuery("select gl from Glumi gl"
				+ " where gl.uloga.predstava.idPredstava=:id", Glumi.class).setParameter("id", idPredst).getResultList();
		return glumi;
	}
	
	public String naziv(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		Predstava p = em.find(Predstava.class, id);
		return p.getNaziv();
	}

}
