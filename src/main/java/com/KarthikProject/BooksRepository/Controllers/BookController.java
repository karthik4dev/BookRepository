package com.KarthikProject.BooksRepository.Controllers;



import io.swagger.v3.oas.annotations.Operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.KarthikProject.BooksRepository.Entities.Book;
import com.KarthikProject.BooksRepository.Services.BookService;


@RestController
@RequestMapping(value = "books")
public class BookController {


	private BookService bookService;

	@Autowired
	private void setBookService(BookService bookService){
		this.bookService=bookService;
	}

//
//	public void setClientService(BookService bookService){
//		this.bookService=bookService;
//	}

	@Operation(summary = "Create a Book")
	@PostMapping("/createBook")
	void createBook(@RequestBody Book book){
		bookService.saveBook(book);
	}

	@Operation(summary = "Show All Books")
	@GetMapping("/All")
	List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	@SuppressWarnings("unchecked")
	@Operation(summary = "Show Book by ID")
	@GetMapping("/{id}")
	ResponseEntity<Optional<Book>> getBookByID(@PathVariable int id){
		Optional<Book> book =bookService.getBookByID(id);

		return ResponseEntity.ok(book);

	}
	
	
	
}
