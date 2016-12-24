package net.hoyoung.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.hoyoung.domain.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
