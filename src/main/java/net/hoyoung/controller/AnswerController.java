package net.hoyoung.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.hoyoung.domain.Answer;
import net.hoyoung.domain.Question;
import net.hoyoung.domain.User;
import net.hoyoung.repository.AnswerRepository;
import net.hoyoung.repository.QuestionRepository;
import net.hoyoung.util.HttpSessionUtil;

@Controller
@RequestMapping("/questions/{questionId}/answers")
public class AnswerController {
	
	@Autowired
	QuestionRepository questionRepository;
	
	@Autowired
	AnswerRepository answerRepository;

	@PostMapping("")
	public String create(@PathVariable Long questionId, String contents, HttpSession session){
		
		if(!HttpSessionUtil.isLogin(session)){
			return "/users/loginForm";
		}
		User user = HttpSessionUtil.getUserFromSessionUser(session);
		Question question = questionRepository.findOne(questionId);
		Answer answer = new Answer(question, contents, user);
		answerRepository.save(answer);
		return String.format("redirect:/questions/%d", questionId);
	}
}
