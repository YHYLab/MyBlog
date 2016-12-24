package net.hoyoung.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.hoyoung.domain.Question;
import net.hoyoung.domain.User;
import net.hoyoung.repository.QuestionRepository;
import net.hoyoung.util.HttpSessionUtil;

@Controller
@RequestMapping("/questions")
public class QuestionController {
	
	@Autowired
	QuestionRepository questionRepository;
	
	@GetMapping("/form")
	public String form(HttpSession session){
		if(!HttpSessionUtil.isLogin(session)){
			return "redirect:/users/loginForm";
		}
		return "/qna/form";
	}
	
	@PostMapping("/form")
	public String create(String title, String contents, HttpSession session){
		if(!HttpSessionUtil.isLogin(session)){
			return "redirect:/users/loginForm";
		}
		
		User sessionUser = HttpSessionUtil.getUserFromSessionUser(session);
		Question question = new Question(title, contents, sessionUser.getEmail());
		questionRepository.save(question);
		return "redirect:/";
	}
}
