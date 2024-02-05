package com.KarthikProject.BooksRepository.RepoTests;


import com.KarthikProject.BooksRepository.Controllers.BookController;
import com.KarthikProject.BooksRepository.Services.BookService;
import com.KarthikProject.BooksRepository.Services.BookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
public class BookRepoTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean(BookServiceImpl.class)
    BookService bookService;

    @Autowired
    BookServiceImpl bookServiceImpl;

    @BeforeEach
    void setUp(){
        bookServiceImpl=new BookServiceImpl();
    }

    @WithMockUser("karthik")
    @Test
    void getBooksWithoutAuthenticationTest(){
        when(bookService.getBookByID(0)).thenReturn(bookServiceImpl.getBookByID(0));

        try {
            mockMvc.perform(get("/books/All").accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().is(401));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


}
