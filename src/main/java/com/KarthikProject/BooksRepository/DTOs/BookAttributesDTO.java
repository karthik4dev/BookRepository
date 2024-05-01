package com.KarthikProject.BooksRepository.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class BookAttributesDTO {
    private long bookID;
    private int bookPages;
    private int price;
    private int bookType;
    private int bookBind;
}
