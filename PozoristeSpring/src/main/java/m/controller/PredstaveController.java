package m.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Izvodjenje;
import model.Karta;
import model.Mesto;
import model.Predstava;
import model.Reziser;
import model.Zanr;

@RequestMapping(value = "Predstave")
@Controller
public class PredstaveController {

	@Autowired
	m.repository.PredstavaRepository pr;
	@Autowired
	m.repository.ReziserRepository rr;
	@Autowired
	m.repository.ZanrRepository zr;
	@Autowired
	m.repository.ZanrPredstaveRepostitory zpr;
	@Autowired
	m.repository.IzvodjenjeRepository ir;
	@Autowired
	m.repository.MestoRepository mr;
	@Autowired
	m.repository.KartaRepository kr;

	@RequestMapping(value = "izlistajZanroveIRezisere", method = RequestMethod.GET)
	public String izlistajZanroveIRezisere(HttpServletRequest request) {
		List<Reziser> reziseri = rr.findAll();
		List<Zanr> zanrovi = zr.findAll();
		request.getSession().setAttribute("reziseri", reziseri);
		request.getSession().setAttribute("zanrovi", zanrovi);
		return "/Unos";

	}

	@RequestMapping(value = "sacuvajPredstavu", method = RequestMethod.POST)
	public String sacuvajPredstavu(String naziv, String opis, Integer trajanje, Integer idZanr, Integer idReziser,
			Model m) {
		Predstava p = new Predstava();
		p.setNaziv(naziv);
		p.setOpis(opis);
		p.setTrajanje(trajanje);
		Reziser r = rr.findById(idReziser).get();
		Zanr z = zr.findById(idZanr).get();
		p.setReziser(r);
		Predstava sacuvana = pr.save(p);
		m.addAttribute("p", sacuvana);
		return "/Unos";

	}

	@RequestMapping(value = "pretraziPredstave", method = RequestMethod.GET)
	public String pretraziPredstave(String naziv,Model m) {
		Predstava p = pr.findByNaziv(naziv);
		List<Izvodjenje> izvodjenja = ir.findByPredstava(p);
		m.addAttribute("izvodjenja", izvodjenja);
		m.addAttribute("predstava", p);
		return "/pretraga";
		
	}
	@RequestMapping(value="Rezervisanje", method=RequestMethod.GET)
	public String dovuciMesta(Integer idIzvodjenja, Model m, HttpServletRequest request) {
		List<Mesto> slobodnaMesta = mr.slobodnaMesta(idIzvodjenja);
		request.getSession().setAttribute("mesta", slobodnaMesta);
		Izvodjenje i = ir.findById(idIzvodjenja).get();
		request.getSession().setAttribute("izvodjenje", i);
		return "/Rezervacija";
	}
	@ModelAttribute("karta")
	public Karta napraviKartu() {
		return new Karta();
	}
	@RequestMapping(value="sacuvajRezervaciju", method=RequestMethod.POST) 
	public String sacuvajRezervaciju(@ModelAttribute("karta") Karta k, HttpServletRequest request, Model m)	{
		Izvodjenje i = (Izvodjenje)request.getSession().getAttribute("izvodjenje");
		k.setIzvodjenje(i);
		Karta karta = kr.save(k);
		m.addAttribute("karta", karta);
		m.addAttribute("uspesnaRezervacija", true);
		return "/Rezervacija";
	}
}
