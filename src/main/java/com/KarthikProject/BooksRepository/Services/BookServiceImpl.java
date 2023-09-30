package com.KarthikProject.BooksRepository.Services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KarthikProject.BooksRepository.Entities.Book;
import com.KarthikProject.BooksRepository.Repositories.BookRepository;

@Service("bookServiceImpl")
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookRepository bookRepository;
	
	List<Book> bookList= new ArrayList<>();
	@Override
	public List<Book> getAllBooks() {
		bookList.addAll(bookRepository.findAllBooks());
		return bookList;
	}

	@Override
	public Book getBookByID(int id) {
		return bookRepository.findByBookId(id);
		
	}

	@Override
	public Book getBookByName(String name) {
		// TODO Auto-generated method stub
		Book book=bookRepository.findByBookNameString(name);
		return book;
	}

	@Override
	public Book getBookByISBN(String isbn) {
		Book book = bookRepository.findByIsbn(isbn);
		return book;
	}

	@Override
	public void saveBook(Book book) {
		bookRepository.save(book);
	}

}
