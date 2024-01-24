package com.KarthikProject.BooksRepository.Services;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.KarthikProject.BooksRepository.Entities.Author;
import com.KarthikProject.BooksRepository.Exception.BookNotFoundException;
import com.KarthikProject.BooksRepository.Repositories.AuthorRepositoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.KarthikProject.BooksRepository.Entities.Book;
import com.KarthikProject.BooksRepository.Repositories.BookRepositoryRepo;


@Service("BookServiceImpl")
public class BookServiceImpl implements BookService{
	@Autowired
    BookRepositoryRepo bookRepositoryRepo;

    @Autowired
    AuthorRepositoryRepo authorRepositoryRepo;
	
	

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
		Author author=book.getAuthor();
		if(authorRepositoryRepo.existsById(author.getId())){
			author.add(book);
		}

		authorRepositoryRepo.save(author);
		bookRepositoryRepo.save(book);
		
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> booksList=new ArrayList<>();
		Iterator<Book> bookIterable = bookRepositoryRepo.findAll().iterator();
		while(bookIterable.hasNext())
		{
			booksList.add(bookIterable.next());
		}
		return booksList;
	}

	@Override
	public HttpStatus deleteBookById(int id) throws BookNotFoundException{
		if(!this.bookRepositoryRepo.existsById(id)){
			throw new BookNotFoundException("The given Book ID is not present");
		}
		this.bookRepositoryRepo.deleteById(id);
		return HttpStatus.GONE;
	}

	@Override
	public HttpStatus UpdateBookById(int id,Book book) throws BookNotFoundException {
		if(!this.bookRepositoryRepo.existsById(id)){
			throw new BookNotFoundException("The given Book ID is not present");
		}
		Book givenBook=bookRepositoryRepo.findById(id).get();
		givenBook.setBookNameString(book.getBookNameString());
		givenBook.setIsbn(book.getIsbn());
		givenBook.setIsbn(book.getIsbn());
		givenBook.setAuthor(book.getAuthor());

		bookRepositoryRepo.save(givenBook);
		return HttpStatus.CREATED;
    }
}
