package com.KarthikProject.BooksRepository.Repositories;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.KarthikProject.BooksRepository.Entities.Book;
import java.util.List;


public interface BookRepository extends CrudRepository<Book, Integer> {
	@Override
	default Optional<Book> findById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
	
	@Override
	default Iterable<Book> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	default <S extends Book> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}
	Book findByBookNameString(String bookNameString);
	Book findByIsbn(String isbn);
	
}

