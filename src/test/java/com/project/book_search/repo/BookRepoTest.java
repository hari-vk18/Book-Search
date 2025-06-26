package com.project.book_search.repo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.book_search.model.Book;

import jakarta.transaction.Transactional;

@Transactional
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepoTest {

    @Autowired
    private BookRepo bookRepo;

    @Test
    void testSearchBooks() {
        List<Book> books = bookRepo.searchBooks("algorithms");
        assertTrue(books.size() > 0, "Expected to find books related to 'algorithms'");
        books.forEach(book -> {
            System.out.println("Found book: " + book.getTitle() + " with ID: " + book.getBookId());
        });
    }
}
