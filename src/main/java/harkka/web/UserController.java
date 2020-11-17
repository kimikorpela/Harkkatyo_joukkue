package harkka.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

import harkka.model.SignupForm;
import harkka.model.User;
import harkka.model.UserRepo;

@Controller
public class UserController {
	@Autowired
	private UserRepo repository;
	
	// Kirjautuminen
	@RequestMapping("/")
	public String login() {
		return "login";
	}
	@GetMapping("/")
	public String showHome(User user) {
		return "signup";
	}
	
	@GetMapping("/signup")
	public String showRegistrationForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "signup";
	}
	
	@PostMapping("/saveuser")
	public String saveUser(@ModelAttribute User user, Model model) {
		repository.save(user);
		model.addAttribute("users", repository.findAll());
		return "login";
	}
	
}