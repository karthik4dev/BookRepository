package com.karthikRepository.BookAttributes.Entity;

import com.karthikRepository.BookAttributes.Entity.Enums.Bind;
import com.karthikRepository.BookAttributes.Entity.Enums.BookType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class BookAttributes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookID;
    private int bookPages;
    private int price;
    private BookType bookType;
    private Bind bookBind;
}
