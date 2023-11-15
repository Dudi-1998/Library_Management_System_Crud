package com.Library.LibraryManage.mentSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Library.LibraryManage.mentSystem.dto.User;
import com.Library.LibraryManage.mentSystem.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepository;
	
	 // Create (save) a new user
    public void saveUser(User user) {
        userRepository.save(user);
    }

    // Read (get) a user by ID
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // Read (get) a user by username
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Read (get) all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Update an existing user
    public void updateUser(Long id, User updatedUser) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            // Update user properties as needed
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setPassword(updatedUser.getPassword());
            // Update other properties as needed
            userRepository.save(existingUser);
        }
    }

    // Delete a user by ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
