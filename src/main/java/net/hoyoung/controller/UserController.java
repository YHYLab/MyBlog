package net.hoyoung.controller;

import javax.servlet.http.HttpSession;

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
	
	@GetMapping("/loginForm")
	public String logrinForm(){
		return "/user/login";
	}
	
	@PostMapping("/login")
	public String login(String email, String password, HttpSession session){
		User user = userRepository.findByEmail(email);
		if(user == null){
			return "redirect:/users/loginForm";
		}
		if(!password.equals(user.getPassword())){
			return "redirect:/users/loginForm";
		}
		
		session.setAttribute("user", user);
		return "redirect:/users";
	}

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
