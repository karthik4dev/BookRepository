package com.KarthikProject.BooksRepository.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.KarthikProject.BooksRepository.Entities.Book;
import com.KarthikProject.BooksRepository.Services.BookService;


@RestController
@RequestMapping(value = "books")
public class BookController {
	@Qualifier("bookServiceImpl")
	@Autowired
	BookService bookService;
	
	@PostMapping("/createBook")
	void createBook(@RequestBody Book book){
		bookService.saveBook(book);
		
	}
	
	@GetMapping("/All")
	List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/{id}")
	ResponseEntity<Optional<Book>> getBookByID(@RequestParam int id){
		Optional<Book> book=bookService.getBookByID(id);
		if(book.equals(null)) {
			return (ResponseEntity<Optional<Book>>) ResponseEntity.notFound();
		}
		return ResponseEntity.ok(book);
	}
	
	
	
}
