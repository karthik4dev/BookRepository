package com.KarthikProject.BooksRepository.Services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.KarthikProject.BooksRepository.Entities.Book;

@Service
public interface BookService {
	public Optional<Book> getBookByID(int id);
	public Book getBookByName(String name);
	public Book getBookByISBN(String isbn);
	public void saveBook(Book book);
	public List<Book> getAllBooks();
}
