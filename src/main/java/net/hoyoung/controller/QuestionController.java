package net.hoyoung.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		Question question = new Question(title, contents, sessionUser);
		questionRepository.save(question);
		return "redirect:/";
	}
	
	@GetMapping("/{id}")
	public String show(@PathVariable Long id, Model model){
		model.addAttribute("question", questionRepository.findOne(id));
		return "/qna/show";
	}
	
	@GetMapping("/{id}/form")
	public String getForm(@PathVariable Long id, Model model){
		model.addAttribute("question", questionRepository.findOne(id));
		return "/qna/updateForm";
	}
	
	@PutMapping("/{id}")
	public String update(@PathVariable Long id, String title, String contents, Model model, HttpSession session){
		try{
			Question question = questionRepository.findOne(id);
			hasPermission(session, question);
			question.update(title, contents);
			questionRepository.save(question);
			return "redirect:/";
		}catch(IllegalStateException e){
			model.addAttribute("errMessage", e.getMessage());
			return "/user/login";
		}
	}
	

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id, Model model, HttpSession session){
		try{
			Question question = questionRepository.findOne(id);
			hasPermission(session, question);
			questionRepository.delete(id);
			return "redirect:/";
		}catch(IllegalStateException e){
			model.addAttribute("errMessage", e.getMessage());
			return "/user/login";
		}
	}
	
	private void hasPermission(HttpSession session, Question question){
		if(!HttpSessionUtil.isLogin(session)){
			throw new IllegalStateException("로그인이 필요합니다.");
		}
		
		User loginUser = HttpSessionUtil.getUserFromSessionUser(session);
		if(!question.isSameUser(loginUser)){
			throw new IllegalStateException("자신이 쓴 글만 수정, 삭제 가능합니다. ");
		}
	}
}
