package net.hoyoung.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.hoyoung.domain.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long>{

}
