package com.project.book_search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.book_search.model.Book;
import com.project.book_search.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/search")
	public ResponseEntity<List<Book>> searchBooks(@RequestParam String keyword) {
		if (keyword == null || keyword.isEmpty()) {
			return ResponseEntity.badRequest().body(null);
		}
		List<Book> books = bookService.searchBooks(keyword);
		return ResponseEntity.ok(books);
	}

}
