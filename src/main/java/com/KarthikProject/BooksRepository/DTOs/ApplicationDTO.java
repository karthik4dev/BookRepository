package com.KarthikProject.BooksRepository.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor
public class ApplicationDTO {
    private BookAttributesDTO bookAttributesDTO;
    private  BookRepositoryDTO bookRepositoryDTO;
}
