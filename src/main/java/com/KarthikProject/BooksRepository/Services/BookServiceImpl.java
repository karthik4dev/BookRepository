package com.KarthikProject.BooksRepository.Services;

import java.util.ArrayList;
import java.util.List;

import com.KarthikProject.BooksRepository.Entities.Book;

public class BookServiceImpl implements BookService{
	List<Book> bookList= new ArrayList<>();
	@Override
	public List<Book> getAllBooks() {
		
	}

	@Override
	public Book getBookByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book getBookByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book getBookByISBN(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

}
