package com.KarthikProject.BooksRepository.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.KarthikProject.BooksRepository.Entities.Book;

@RestController
@RequestMapping(value = "books")
public class BookController {
	@PostMapping
	public boolean createBook(@RequestBody Book book) {
		if(book==null) {
			throw new NullPointerException("Book details are not available");
		}
		Book b1= new Book();
		b1.setBookNameString(book.getBookNameString());
		b1.setAuthor(book.getAuthor());
		b1.setIsbn(book.getIsbn());
		
		
		return true;
		
	}

}
