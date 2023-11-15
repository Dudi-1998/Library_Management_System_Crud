package com.Library.LibraryManage.mentSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Library.LibraryManage.mentSystem.dto.Book;
import com.Library.LibraryManage.mentSystem.repository.BookRepo;

@Service
public class BookService {
	
	@Autowired
	BookRepo bookRepository;;
	
	  // Create
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    // Read
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    // Update
    public void updateBook(Long id, Book updatedBook) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book existingBook = optionalBook.get();
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            // Update other fields as needed
            bookRepository.save(existingBook);
        } else {
            // Handle the case where the book with the given id is not found
        }
    }

    // Delete
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    // Search
    public List<Book> searchBooks(String keyword) {
        return bookRepository.findByTitleContainingOrAuthorContaining(keyword, keyword);
    }


}
