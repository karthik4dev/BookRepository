package com.KarthikProject.BooksRepository.Services;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KarthikProject.BooksRepository.Entities.Book;
import com.KarthikProject.BooksRepository.Repositories.BookRepositoryRepo;



@Service("BookServiceImpl")
public class BookServiceImpl implements BookService{
	@Autowired
    BookRepositoryRepo bookRepositoryRepo;
	
	
	

	@Override
	public Optional<Book> getBookByID(int id) {
		return bookRepositoryRepo.findById(id);
		
	}

	@Override
	public Book getBookByName(String name) {
		// TODO Auto-generated method stub
		return (Book) bookRepositoryRepo.findByBookNameString(name);
	}

	@Override
	public Book getBookByISBN(String isbn) {
		return (Book) bookRepositoryRepo.findByIsbn(isbn);
	}

	@Override
	public void saveBook(Book book) {
		bookRepositoryRepo.save(book);
		
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> booksList=new ArrayList<>();
		Iterator<Book> bookIterable = bookRepositoryRepo.findAll().iterator();
		while(bookIterable.hasNext()!=false)
		{
			booksList.add(bookIterable.next());
		}
		return booksList;
	}

}
