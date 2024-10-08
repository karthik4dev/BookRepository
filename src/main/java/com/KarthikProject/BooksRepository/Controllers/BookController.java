package com.KarthikProject.BooksRepository.Controllers;



import com.KarthikProject.BooksRepository.DTOs.ApplicationDTO;
import com.KarthikProject.BooksRepository.Exception.BookNotFoundException;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	ResponseEntity<Book> getBookByID(@PathVariable int id) throws BookNotFoundException {
		Book book =bookService.getBookByID(id);

		return ResponseEntity.ok(book);

	}

	@Operation(summary = "To Update Book by ID")
	@PatchMapping("/updatebook/{id}")
	HttpStatus updateBookById(@PathVariable int id,@RequestBody Book book) throws BookNotFoundException {
		return this.bookService.UpdateBookById(id,book);
	}

	@Operation(summary = "To delete book by ID ")
	@DeleteMapping("/deletebook/{id}")
	HttpStatus deleteBookById(@PathVariable int id) throws BookNotFoundException {
		return bookService.deleteBookById(id);
	}
	
	
}
