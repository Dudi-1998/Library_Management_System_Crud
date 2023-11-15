package com.Library.LibraryManage.mentSystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Library.LibraryManage.mentSystem.dto.User;

public interface UserRepo extends JpaRepository<User, Long>{

	List<User> findByUsernameContaining(String keyword);
	
	User findByUsername(String username);
	
}
