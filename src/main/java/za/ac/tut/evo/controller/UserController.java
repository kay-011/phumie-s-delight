package za.ac.tut.evo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import za.ac.tut.evo.model.User;
import za.ac.tut.evo.service.UserService;

@Controller
@ComponentScan(basePackages = "za.ac.tut.evo.controller,"+"za.ac.tut.evo.service")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/register")
	public String showRegistrationForm() {
		return "account";
	}
	
	@PostMapping("/register")
	public String addUser(@RequestParam("username") String username, @RequestParam("email") String email, @RequestParam("password") String password) {
		User user = new User(username, email, password);
		userService.createUser(user);
		return "/account";
	}
	
	@GetMapping("/account")
	public String showWelcomePage() {
		return "redirect:/welcome";
	}
	
} 
