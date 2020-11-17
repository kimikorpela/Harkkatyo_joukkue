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
	
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deletePelaaja(@PathVariable("id") Long pelaajaId, Model model) {
		repository.deleteById(pelaajaId);
		return "redirect:../pelaajalista";
	}

	@RequestMapping(value = "/modify/{id}")
	public String editPelaaja(@PathVariable("id") Long pelaajaId, Model model) {
		model.addAttribute("pelaaja", repository.findById(pelaajaId));
		model.addAttribute("pelipaikat", prepository.findAll());
		return "muokkkaapelaajaa";
	}

	@RequestMapping(value = "/pelaajalista/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Pelaaja> findPelaajaRest(@PathVariable("id") Long id) {
		return repository.findById(id);
	}

	@RequestMapping(value = "/lisaapelaaja")
	public String lisaaPelaaja(Model model) {
		model.addAttribute("pelaaja", new Pelaaja());
		model.addAttribute("pelipaikat", prepository.findAll());
		return "lisaapelaaja";
	}

	@RequestMapping(value = "/pelaajalista")
	public String pelaajaLista(Model model) {
		model.addAttribute("pelaajat", repository.findAll());
		return "pelaajalista";
	}

	@RequestMapping(value = "/pelaajat", method = RequestMethod.GET)
	public @ResponseBody List<Pelaaja> pelaajaListaRest() {
		return (List<Pelaaja>) repository.findAll();
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Pelaaja pelaaja) {
		repository.save(pelaaja);
		return "redirect:pelaajalista";
	}
}