package com.project.book_search;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.project.book_search.model.Book;
import com.project.book_search.repo.BookRepo;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryTest {

	@Autowired
	private BookRepo bookRepository;

	@Test
	void testSearchBooks() {
		List<Book> books = bookRepository.searchBooks("algorithms");
		assertTrue(books.size() > 0);

//		for (Book book : books) {
//			System.out.println(">>> Book Title: " + book.getTitle());
//		}

	}
}
