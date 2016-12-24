package net.hoyoung.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.hoyoung.repository.QuestionRepository;

@Controller
public class MainController {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@GetMapping("")
	public String index(Model model){
		model.addAttribute("questions", questionRepository.findAll());
		return "index";
	}
	

	@GetMapping("index.html")
	public String getIndex(Model model){
		model.addAttribute("questions", questionRepository.findAll());
		return "index";
	}
}
