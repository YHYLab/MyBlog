package net.hoyoung.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.hoyoung.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);

}
