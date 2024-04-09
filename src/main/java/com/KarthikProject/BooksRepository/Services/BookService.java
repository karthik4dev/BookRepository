package com.KarthikProject.BooksRepository.Services;


import java.util.List;

import com.KarthikProject.BooksRepository.DTOs.ApplicationDTO;
import com.KarthikProject.BooksRepository.Exception.BookNotFoundException;
//import com.karthikRepository.BookAttributes.Exceptions.BookAttributesNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.KarthikProject.BooksRepository.Entities.Book;

@Service
public interface BookService {
	public Book getBookByID(int id) throws BookNotFoundException;
	public Book getBookByName(String name);
	public Book getBookByISBN(String isbn);
	public void saveBook(Book book);
	public List<Book> getAllBooks();

	public HttpStatus deleteBookById(int id);
	public HttpStatus UpdateBookById(int id,Book book);
}
