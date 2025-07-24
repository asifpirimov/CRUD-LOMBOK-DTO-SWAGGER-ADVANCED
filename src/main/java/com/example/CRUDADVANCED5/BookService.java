package com.example.CRUDADVANCED5;

import java.util.List;

public interface BookService {
    BooksDTO createBook(BooksDTO bookDTO);
    BooksDTO getBookById(Long id);
    List<BooksDTO> getAllBooks();
    BooksDTO updateBook(Long id, BooksDTO bookDTO);
    void deleteBook(Long id);
    // Additional methods can be added here as needed

}
