package net.hoyoung.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import net.hoyoung.domain.User;
import net.hoyoung.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	@PostMapping("/create")
	public String create(User user){
		System.out.println("name : " + user.getName() + ", email : " + user.getEmail() + ", password : " + user.getPassword());
		//users.add(user);
		userRepository.save(user);
		return "redirect:/list";
	}
	
	@GetMapping("/list")
	public String getList(Model model){
		model.addAttribute("users", userRepository.findAll());
		return "list";
	}
}
