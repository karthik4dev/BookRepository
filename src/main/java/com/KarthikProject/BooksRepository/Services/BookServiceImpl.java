package com.KarthikProject.BooksRepository.Services;



import java.util.*;

import com.KarthikProject.BooksRepository.BooksRepositoryApplication;
import com.KarthikProject.BooksRepository.DTOs.ApplicationDTO;
import com.KarthikProject.BooksRepository.DTOs.BookAttributesDTO;
import com.KarthikProject.BooksRepository.DTOs.BookRepositoryDTO;
import com.KarthikProject.BooksRepository.Entities.Author;
import com.KarthikProject.BooksRepository.Exception.BookNotFoundException;
import com.KarthikProject.BooksRepository.Repositories.AuthorRepositoryRepo;
//import com.karthikRepository.BookAttributes.DTOs.BookAttrDTO;
//import com.karthikRepository.BookAttributes.Exceptions.BookAttributesNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.KarthikProject.BooksRepository.Entities.Book;
import com.KarthikProject.BooksRepository.Repositories.BookRepositoryRepo;


@Service("BookServiceImpl")
public class BookServiceImpl implements BookService{
	@Autowired
    BookRepositoryRepo bookRepositoryRepo;

    @Autowired
    AuthorRepositoryRepo authorRepositoryRepo;

//	BooksRepositoryApplication.IBookAttr bookAttr;
	
	

	@Override
//	@Cacheable(value = "books",key = "#id")
	public Book getBookByID(int id) throws BookNotFoundException{
		Book book= bookRepositoryRepo.findById(id).orElseThrow(BookNotFoundException::new);
		BookRepositoryDTO bookRepositoryDTO = BookRepositoryDTO.builder()
				.id(book.getId())
				.isbn(book.getIsbn())
				.bookNameString(book.getBookNameString())
				.author(book.getAuthor())
				.build();
//		ResponseEntity<BookAttrDTO> bookAttributesDTO = bookAttr.getBookAttributes(id);
//		BookAttributesDTO bookAttrDTO = BookAttributesDTO.builder()
//				.bookBind(Objects.requireNonNull(bookAttributesDTO.getBody()).getBookBind())
//				.bookType(bookAttributesDTO.getBody().getBookType())
//				.bookPages(bookAttributesDTO.getBody().getBookPages())
//				.bookID(bookAttributesDTO.getBody().getBookID())
//				.bookPages(bookAttributesDTO.getBody().getBookPages())
//				.build();

//		ApplicationDTO applicationDTO = new ApplicationDTO(bookAttrDTO,bookRepositoryDTO);
		return book;
	}

	@Override
//	@Cacheable(value = "books",key = "#name")
	public Book getBookByName(String name) {
		// TODO Auto-generated method stub
		return (Book) bookRepositoryRepo.findByBookNameString(name);
	}

	@Override
	public Book getBookByISBN(String isbn) {
		return (Book) bookRepositoryRepo.findByIsbn(isbn);
	}

	@Override
//	@CachePut(value = "books", key = "$(book.id)")
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
//	@CacheEvict(value = "books",key="#id")
	public HttpStatus deleteBookById(int id) {

		this.bookRepositoryRepo.deleteById(id);
		return HttpStatus.GONE;
	}

	@Override
	public HttpStatus UpdateBookById(int id,Book book){

		Book givenBook=bookRepositoryRepo.findById(id).get();
		givenBook.setBookNameString(book.getBookNameString());
		givenBook.setIsbn(book.getIsbn());
		givenBook.setIsbn(book.getIsbn());
		givenBook.setAuthor(book.getAuthor());

		bookRepositoryRepo.save(givenBook);
		return HttpStatus.CREATED;
    }
}
