package com.project.book_search.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.book_search.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

	@Query(value = "SELECT * FROM books WHERE MATCH(title, description, isbn) AGAINST (:searchTerm IN NATURAL LANGUAGE MODE)", nativeQuery = true)
	List<Book> searchBooks(@Param("searchTerm") String searchTerm);

}
