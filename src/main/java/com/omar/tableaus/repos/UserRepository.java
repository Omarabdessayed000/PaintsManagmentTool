package com.omar.tableaus.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omar.tableaus.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
