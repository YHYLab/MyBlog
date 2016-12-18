package net.hoyoung.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.hoyoung.domain.User;
import net.hoyoung.repository.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	@PostMapping("")
	public String create(User user){
		System.out.println("name : " + user.getName() + ", email : " + user.getEmail() + ", password : " + user.getPassword());
		userRepository.save(user);
		return "redirect:/users";
	}
	
	@GetMapping("")
	public String getList(Model model){
		model.addAttribute("users", userRepository.findAll());
		return "/user/list";
	}
	
	@GetMapping("/form")
	public String userFrom(){
		return "/user/form";
	}
	
	@GetMapping("/{id}/form")
	public String userUpdateForm(@PathVariable Long id, Model model){
		User user = userRepository.findOne(id);
		model.addAttribute("user", user);
		return "/user/updateForm";
	}
	
	@PostMapping("/{id}")
	public String userUpdate(@PathVariable Long id, User updateUser){
		User user = userRepository.findOne(id);
		user.update(updateUser);
		userRepository.save(user);
		return "redirect:/users";
	}
}
