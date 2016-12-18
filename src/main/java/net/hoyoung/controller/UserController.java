package net.hoyoung.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import net.hoyoung.model.User;

@Controller
public class UserController {
	private List<User> users = new ArrayList<>();

	@PostMapping("/create")
	public String create(User user){
		System.out.println("name : " + user.getName() + ", email : " + user.getEmail() + ", password : " + user.getPassword());
		users.add(user);
		return "redirect:/list";
	}
	
	@GetMapping("/list")
	public String getList(Model model){
		model.addAttribute("users", users);
		return "list";
	}
}
