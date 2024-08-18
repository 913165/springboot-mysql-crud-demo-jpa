package org.example.pbooksapp001.repository;

import org.example.pbooksapp001.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void testSaveBook() {
        // given
        Book book = new Book("Test Title", "Test ISBN", new Date(), "Test Author");
        // when
        Book savedBook = bookRepository.save(book);
        // then
        Book foundBook = bookRepository.findById(savedBook.getId()).orElse(null);
        assertNotNull(foundBook);
        assertEquals(savedBook.getTitle(), foundBook.getTitle());
        assertEquals(savedBook.getIsbn(), foundBook.getIsbn());
        assertEquals(savedBook.getPublicationDate(), foundBook.getPublicationDate());
        assertEquals(savedBook.getAuthorName(), foundBook.getAuthorName());
    }

    @Test
    void testDeleteBook() {
        // given
        Book book = new Book("Test Title", "Test ISBN", new Date(), "Test Author");
        Book savedBook = bookRepository.save(book);
        // when
        bookRepository.deleteById(savedBook.getId());
        // then
        Book foundBook = bookRepository.findById(savedBook.getId()).orElse(null);
        assertNull(foundBook);
    }

    @Test
    void testUpdateBook() {
        // given
        Book book = new Book("Test Title", "Test ISBN", new Date(), "Test Author");
        Book savedBook = bookRepository.save(book);
        // when
        savedBook.setTitle("Updated Title");
        savedBook.setIsbn("Updated ISBN");
        savedBook.setPublicationDate(new Date());
        savedBook.setAuthorName("Updated Author");
        bookRepository.save(savedBook);
        // then
        Book foundBook = bookRepository.findById(savedBook.getId()).orElse(null);
        assertNotNull(foundBook);
        assertEquals(savedBook.getTitle(), foundBook.getTitle());
        assertEquals(savedBook.getIsbn(), foundBook.getIsbn());
        assertEquals(savedBook.getPublicationDate(), foundBook.getPublicationDate());
        assertEquals(savedBook.getAuthorName(), foundBook.getAuthorName());
    }

    @Test
    void testFindAllBooks() {
        // given
        Book book1 = new Book("Test Title 1", "Test ISBN 1", new Date(), "Test Author 1");
        Book book2 = new Book("Test Title 2", "Test ISBN 2", new Date(), "Test Author 2");
        bookRepository.save(book1);
        bookRepository.save(book2);
        // when
        Iterable<Book> books = bookRepository.findAll();
        // then
        assertNotNull(books);
        assertEquals(2, ((List<Book>) books).size());
    }

    @Test
    void testFindBookById() {
        // given
        Book book = new Book("Test Title", "Test ISBN", new Date(), "Test Author");
        Book savedBook = bookRepository.save(book);
        // when
        Book foundBook = bookRepository.findById(savedBook.getId()).orElse(null);
        // then
        assertNotNull(foundBook);
        assertEquals(savedBook.getTitle(), foundBook.getTitle());
        assertEquals(savedBook.getIsbn(), foundBook.getIsbn());
        assertEquals(savedBook.getPublicationDate(), foundBook.getPublicationDate());
        assertEquals(savedBook.getAuthorName(), foundBook.getAuthorName());
    }
}