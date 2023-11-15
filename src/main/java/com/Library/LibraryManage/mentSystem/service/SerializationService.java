package com.Library.LibraryManage.mentSystem.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Library.LibraryManage.mentSystem.dto.Book;
import com.Library.LibraryManage.mentSystem.dto.User;
import com.Library.LibraryManage.mentSystem.repository.BookRepo;
import com.Library.LibraryManage.mentSystem.repository.UserRepo;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SerializationService {
	 @Autowired
	    private BookRepo bookRepository;

	    @Autowired
	    private UserRepo userRepository;

	    private final ObjectMapper objectMapper = new ObjectMapper();

	    private static final String BOOKS_FILE_PATH = "books.json";
	    private static final String USERS_FILE_PATH = "users.json";

	    public void serializeData() {
	        serializeBooks();
	        serializeUsers();
	    }

	    public void deserializeData() {
	        deserializeBooks();
	        deserializeUsers();
	    }

	    private void serializeBooks() {
	        try {
	            List<Book> books = bookRepository.findAll();
	            objectMapper.writeValue(new File(BOOKS_FILE_PATH), books);
	        } catch (IOException e) {
	            e.printStackTrace();
	            
	        }
	    }

	    private void deserializeBooks() {
	        try {
	            Book[] books = objectMapper.readValue(new File(BOOKS_FILE_PATH), Book[].class);
	            for (Book book : books) {
	                bookRepository.save(book);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	            
	        }
	    }

	    private void serializeUsers() {
	        try {
	            List<User> users = userRepository.findAll();
	            objectMapper.writeValue(new File(USERS_FILE_PATH), users);
	        } catch (IOException e) {
	            e.printStackTrace();
	            
	        }
	    }

	    private void deserializeUsers() {
	        try {
	            User[] users = objectMapper.readValue(new File(USERS_FILE_PATH), User[].class);
	            for (User user : users) {
	                userRepository.save(user);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	            
	        }
	    }
}
