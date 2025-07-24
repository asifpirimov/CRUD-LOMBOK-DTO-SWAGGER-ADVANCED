package com.example.CRUDADVANCED5;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*DTO - Data Transfer Object*/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BooksDTO {
    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotBlank(message = "Author cannot be blank")
    private String author;

    private String description;
}
