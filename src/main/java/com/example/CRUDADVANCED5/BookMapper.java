package com.example.CRUDADVANCED5;

import org.springframework.context.annotation.Configuration;

/*Converts DTOs <-> Entities */
@Configuration
public class BookMapper {
    public BooksDTO toDTO(Books book) {
        return BooksDTO.builder()
                .title(book.getTitle())
                .author(book.getAuthor())
                .description(book.getDescription())
                .build();
    }

    public Books toEntity(BooksDTO bookDTO) {
        return Books.builder()
                .title(bookDTO.getTitle())
                .author(bookDTO.getAuthor())
                .description(bookDTO.getDescription())
                .build();
    }
}
