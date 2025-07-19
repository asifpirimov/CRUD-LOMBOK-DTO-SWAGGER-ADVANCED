package com.example.CRUDADVANCED5;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<BooksDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(book -> modelMapper.map(book, BooksDTO.class))
                .collect(Collectors.toList());
    }

    public BooksDTO getBookById(Long id) {
        Books book = bookRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
        return modelMapper.map(book, BooksDTO.class);
    }

    public BooksDTO createBook(BooksDTO bookDTO) {
        Books book = modelMapper.map(bookDTO, Books.class);
        Books saved = bookRepository.save(book);
        return modelMapper.map(saved, BooksDTO.class);
    }

    public BooksDTO updateBook(Long id, BooksDTO bookDTO) {
    Books book = bookRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));

    book.setTitle(bookDTO.getTitle());
    book.setAuthor(bookDTO.getAuthor());
    book.setDescription(bookDTO.getDescription());

    Books updated = bookRepository.save(book);
    return modelMapper.map(updated, BooksDTO.class);
}


    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Book not found with id: " + id);
        }
        bookRepository.deleteById(id);
    }
}
