package com.example.CRUDADVANCED5;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*DTO - Data Transfer Object
There are some data types like passwords, adresses that shouldn't be sent to the frontend.
DTO is for sending only necessary data. */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BooksDTO {
    @NotBlank(message = "Title cannot be blank")
    private String title;
    @NotBlank(message = "Author cannot be blank")
    private String author;
    private String description;
}
