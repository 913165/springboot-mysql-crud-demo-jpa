package org.example.pbooksapp001.controller;

import org.example.pbooksapp001.model.Book;
import org.example.pbooksapp001.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    // get all books with endpoint /books
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // get book by id with endpoint /books/{id}
    @GetMapping("/books/{id}")
    public String getBookById(Long id) {
        return bookService.getBookById(id).toString();
    }

    // add book with endpoint /books
    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    // update book with endpoint /books
    @PutMapping("/books")
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    // delete book with endpoint /books/{id}
    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
