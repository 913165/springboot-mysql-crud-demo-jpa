package org.example.pbooksapp001.repository;

import org.example.pbooksapp001.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.boot.jdbc.EmbeddedDatabaseConnection.H2;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void saveBook() {
        // Arrange
        Book book = new Book("Test Title", "Test ISBN", new Date(), "Test Author");
        // Act
        Book savedBook = bookRepository.save(book);
        // Assert
        assertNotNull(savedBook);
        assertEquals(book.getTitle(), savedBook.getTitle());
        assertEquals(book.getIsbn(), savedBook.getIsbn());
        assertEquals(book.getPublicationDate(), savedBook.getPublicationDate());
        assertEquals(book.getAuthorName(), savedBook.getAuthorName());
    }

    @Test
    void findBookById() {
        // Arrange
        Book book = new Book("Test Title", "Test ISBN", new Date(), "Test Author");
        Book savedBook = bookRepository.save(book);
        // Act
        Book foundBook = bookRepository.findById(savedBook.getId()).orElse(null);
        // Assert
        assertNotNull(foundBook);
        assertEquals(savedBook.getId(), foundBook.getId());
        assertEquals(savedBook.getTitle(), foundBook.getTitle());
        assertEquals(savedBook.getIsbn(), foundBook.getIsbn());
        assertEquals(savedBook.getPublicationDate(), foundBook.getPublicationDate());
        assertEquals(savedBook.getAuthorName(), foundBook.getAuthorName());
    }

    // find all
    @Test
    void findAllBooks() {
        // Arrange
        Book book1 = new Book("Test Title 1", "Test ISBN 1", new Date(), "Test Author 1");
        Book book2 = new Book("Test Title 2", "Test ISBN 2", new Date(), "Test Author 2");
        bookRepository.save(book1);
        bookRepository.save(book2);
        // Act
        Iterable<Book> books = bookRepository.findAll();
        // Assert
        assertNotNull(books);
        assertEquals(2, ((List<Book>) books).size());
    }

    // update book

    @Test
    void updateBook() {
        // Arrange
        Book book = new Book("Test Title", "Test ISBN", new Date(), "Test Author");
        Book savedBook = bookRepository.save(book);
        savedBook.setTitle("Updated Title");
        savedBook.setIsbn("Updated ISBN");
        savedBook.setPublicationDate(new Date());
        savedBook.setAuthorName("Updated Author");
        // Act
        Book updatedBook = bookRepository.save(savedBook);
        // Assert
        assertNotNull(updatedBook);
        assertEquals(savedBook.getId(), updatedBook.getId());
        assertEquals(savedBook.getTitle(), updatedBook.getTitle());
        assertEquals(savedBook.getIsbn(), updatedBook.getIsbn());
        assertEquals(savedBook.getPublicationDate(), updatedBook.getPublicationDate());
        assertEquals(savedBook.getAuthorName(), updatedBook.getAuthorName());
    }
    // delete book
    @Test
    void deleteBook() {
        // Arrange
        Book book = new Book("Test Title", "Test ISBN", new Date(), "Test Author");
        Book savedBook = bookRepository.save(book);
        // Act
        bookRepository.deleteById(savedBook.getId());
        // Assert
        Book deletedBook = bookRepository.findById(savedBook.getId()).orElse(null);
        assertEquals(null, deletedBook);
    }
}