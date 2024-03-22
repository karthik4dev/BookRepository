package com.karthikRepository.BookAttributes.DTOs;

import com.karthikRepository.BookAttributes.Entity.Enums.Bind;
import com.karthikRepository.BookAttributes.Entity.Enums.BookType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class BookAttrDTO {
    private long bookID;
    private int bookPages;
    private int price;
    private int bookType;
    private int bookBind;
}
