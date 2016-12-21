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
import net.hoyoung.util.HttpSessionUtil;

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
		if(!user.isMatchPassword(password)){
			return "redirect:/users/loginForm";
		}
		
		session.setAttribute(HttpSessionUtil.USER_SESSION_KEY, user);
		return "redirect:/users";
	}

	@PostMapping("")
	public String create(User user){
		System.out.println(user.toString());
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
	public String userUpdateForm(@PathVariable Long id, Model model, HttpSession session){
		if(!HttpSessionUtil.isLogin(session)){
			return "redirect:/";
		}
		User sessioUser = (User)HttpSessionUtil.getUserFromSessionUser(session);
		
		if(!id.equals(sessioUser.getId())){
			throw new IllegalStateException("You can't update.");
		}
		User user = userRepository.findOne(id);
		model.addAttribute("user", user);
		return "/user/updateForm";
	}
	
	@PostMapping("/{id}")
	public String userUpdate(@PathVariable Long id, User updatedUser, HttpSession session){
		if(!HttpSessionUtil.isLogin(session)){
			return "redirect:/user/loginForm";
		}
		User sessioUser = HttpSessionUtil.getUserFromSessionUser(session);
		
		if(!id.equals(sessioUser.getId())){
			throw new IllegalStateException("You can't update.");
		}
		User user = userRepository.findOne(id);
		user.update(updatedUser);
		userRepository.save(user);
		return "redirect:/users";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session){
		session.removeAttribute(HttpSessionUtil.USER_SESSION_KEY);
		return "redirect:/";
	}
}
