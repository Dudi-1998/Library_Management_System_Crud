package com.Library.LibraryManage.mentSystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Library.LibraryManage.mentSystem.dto.Book;

public interface BookRepo extends JpaRepository<Book, Long> {
	 List<Book> findByTitleContainingOrAuthorContaining(String keyword1, String keyword2);

	    Optional<Book> findByTitle(String title);

}
