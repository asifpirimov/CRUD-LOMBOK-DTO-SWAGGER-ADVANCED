package com.example.CRUDADVANCED5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BooksDTO> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public BooksDTO getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/create")
    public BooksDTO createBook(@RequestBody BooksDTO book) {
        return bookService.createBook(book);
    }

    @PutMapping("/update/{id}")
    public BooksDTO updateBook(@PathVariable Long id, @RequestBody BooksDTO book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }





}

