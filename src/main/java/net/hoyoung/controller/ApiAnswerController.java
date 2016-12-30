package net.hoyoung.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.hoyoung.domain.Answer;
import net.hoyoung.domain.Question;
import net.hoyoung.domain.User;
import net.hoyoung.repository.AnswerRepository;
import net.hoyoung.repository.QuestionRepository;
import net.hoyoung.util.HttpSessionUtil;

@RestController
@RequestMapping("/api/questions/{questionId}/answers")
public class ApiAnswerController {
	
	@Autowired
	QuestionRepository questionRepository;
	
	@Autowired
	AnswerRepository answerRepository;

	@PostMapping("")
	public Answer create(@PathVariable Long questionId, String contents, HttpSession session){
		
		if(!HttpSessionUtil.isLogin(session)){
			return null;
		}
		User user = HttpSessionUtil.getUserFromSessionUser(session);
		Question question = questionRepository.findOne(questionId);
		Answer answer = new Answer(question, contents, user);
		return answerRepository.save(answer);
	}
	
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable Long questionId, @PathVariable Long id, HttpSession session){
		if( !HttpSessionUtil.isLogin(session)){
			return Result.fail("로그인해야 합니다.");
		}
		Answer answer = answerRepository.findOne(id);
		User user = HttpSessionUtil.getUserFromSessionUser(session);
		if(answer.equals(user)){
			return Result.fail("자신의 글만 삭제 할 수 있습니다.");
		}
		answerRepository.delete(answer);
		return Result.ok();
	}
}
