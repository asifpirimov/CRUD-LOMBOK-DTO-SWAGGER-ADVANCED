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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookServiceImpl bookService;

    @Operation(summary = "Get all books", description = "Retrieve a list of all books in the library.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Books retrieved successfully"),
        @ApiResponse(responseCode = "404", description = "No books found")
    })
    @GetMapping
    public List<BooksDTO> getAllBooks() {
        return bookService.getAllBooks();
    }



    @Operation(summary = "Get book by ID", description = "Retrieve a book by its unique identifier.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Book found"),
        @ApiResponse(responseCode = "404", description = "Book not found")
    })
    @GetMapping("/{id}")
    public BooksDTO getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }



    @Operation(summary = "Create a new book", description = "Add a new book to the library.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Book created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid book data")
    })
    @PostMapping
    public BooksDTO createBook(@Valid @RequestBody BooksDTO book) {
        return bookService.createBook(book);
    }



    @Operation(summary = "Update a book", description = "Update the details of an existing book.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Book updated successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid book data"),
        @ApiResponse(responseCode = "404", description = "Book not found")
    })
    @PutMapping("/{id}")
    public BooksDTO updateBook(@PathVariable Long id, @Valid @RequestBody BooksDTO book) {
        return bookService.updateBook(id, book);
    }



    @Operation(summary = "Delete a book", description = "Delete a book from the library by ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Book deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Book not found")
    })
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
