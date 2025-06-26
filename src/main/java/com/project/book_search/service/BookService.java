package com.project.book_search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.book_search.model.Book;
import com.project.book_search.repo.BookRepo;

@Service
public class BookService {

	@Autowired
	private BookRepo bookRepository;

	public List<Book> searchBooks(String keyword) {
		if (keyword == null || keyword.isEmpty()) {
			throw new IllegalArgumentException("Keyword must not be null or empty");
		} else {
			return bookRepository.searchBooks(keyword);
		}
	}
}
