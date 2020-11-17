package harkka.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import harkka.model.Pelaaja;
import harkka.model.PelaajaRepo;
import harkka.model.PelipaikkaRepo;

@Controller
public class PelaajaController {

	@Autowired
	private PelaajaRepo repository;

	@Autowired
	private PelipaikkaRepo prepository;

	// Sisäänkirjautuminen
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	// Pelaajan poisto admin oikeuksilla
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deletePelaaja(@PathVariable("id") Long pelaajaId, Model model) {
		repository.deleteById(pelaajaId);
		return "redirect:../pelaajalista";
	}

	// Pelaajan muokkaus
	@RequestMapping(value = "/modify/{id}")
	public String editPelaaja(@PathVariable("id") Long pelaajaId, Model model) {
		model.addAttribute("pelaaja", repository.findById(pelaajaId));
		model.addAttribute("pelipaikat", prepository.findAll());
		return "muokkaapelaajaa";
	}

	// Pelaajan haku RESTful servicellä
	@RequestMapping(value = "/pelaajalista/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Pelaaja> findPelaajaRest(@PathVariable("id") Long id) {
		return repository.findById(id);
	}

	// Pelaajan lisäys
	@RequestMapping(value = "/lisaapelaaja")
	public String lisaaPelaaja(Model model) {
		model.addAttribute("pelaaja", new Pelaaja());
		model.addAttribute("pelipaikat", prepository.findAll());
		return "lisaapelaaja";
	}

	// Näytä kaikki pelaajat
	@RequestMapping(value = "/pelaajalista", method = RequestMethod.GET)
	public String pelaajaLista(Model model) {
		model.addAttribute("pelaajat", repository.findAll());
		return "pelaajalista";
	}

	// Kaikkien pelaajien haku RESTful servicellä
	@RequestMapping(value = "/pelaajat", method = RequestMethod.GET)
	public @ResponseBody List<Pelaaja> pelaajaListaRest() {
		return (List<Pelaaja>) repository.findAll();
	}

	// Pelaajan tallennus
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Pelaaja pelaaja) {
		repository.save(pelaaja);
		return "redirect:pelaajalista";
	}
}