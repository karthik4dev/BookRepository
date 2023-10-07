package com.KarthikProject.BooksRepository.Repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.KarthikProject.BooksRepository.Entities.Book;
import java.util.List;



public interface BookRepositoryRepo extends CrudRepository<Book, Integer> {
	@Override
	public Iterable<Book> findAll() ;
	
	@Override
	public Optional<Book> findById(Integer id);
	
	public Book findByBookNameString(String bookNameString);
	public List<Book> findByIsbn(String isbn);

}
