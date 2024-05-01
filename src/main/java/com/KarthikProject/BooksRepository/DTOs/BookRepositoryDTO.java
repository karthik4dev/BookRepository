package com.KarthikProject.BooksRepository.DTOs;

import com.KarthikProject.BooksRepository.Entities.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class BookRepositoryDTO {
    private int id;
    private String bookNameString;
    private String isbn;
    private Author author;
}
