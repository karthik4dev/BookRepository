package com.KarthikProject.BooksRepository.RepoTests;


import com.KarthikProject.BooksRepository.Controllers.BookController;
import com.KarthikProject.BooksRepository.Services.BookService;
import com.KarthikProject.BooksRepository.Services.BookServiceImpl;
import org.apache.tomcat.util.http.parser.Authorization;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.ResponseEntity.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
public class BookRepoTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean(BookServiceImpl.class)
    BookService bookService;

    @Test
    void getBooksWithoutAuthenticationTest(){
        try {
            mockMvc.perform(get("/books/All").accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().is(401));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


}
