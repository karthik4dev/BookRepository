package com.KarthikProject.BooksRepository.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.KarthikProject.BooksRepository.Entities.Book;

@Service
public interface BookService {
	public List<Book> getAllBooks();
	public Book getBookByID(int id);
	public Book getBookByName(String name);
	public Book getBookByISBN(String isbn);
}
