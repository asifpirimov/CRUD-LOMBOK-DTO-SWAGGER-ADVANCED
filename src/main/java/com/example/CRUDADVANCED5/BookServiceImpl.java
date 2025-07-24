package com.example.CRUDADVANCED5;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<BooksDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }
    @Override
    public BooksDTO getBookById(Long id) {
        Books book = bookRepository.findById(id)
            .orElseThrow(() -> new BookNotFoundException(id));
        return bookMapper.toDTO(book);
    }

    @Override
    public BooksDTO createBook(BooksDTO bookDTO) {
        Books book = bookMapper.toEntity(bookDTO);
        Books savedBook = bookRepository.save(book);
        return bookMapper.toDTO(savedBook);
    }

    @Override
    public BooksDTO updateBook(Long id, BooksDTO bookDTO) {
        Books book = bookRepository.findById(id)
            .orElseThrow(() -> new BookNotFoundException(id));
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setDescription(bookDTO.getDescription());
        Books updatedBook = bookRepository.save(book);
        return bookMapper.toDTO(updatedBook);
    }

    @Override
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException(id);
        }
        bookRepository.deleteById(id);
    }
}
