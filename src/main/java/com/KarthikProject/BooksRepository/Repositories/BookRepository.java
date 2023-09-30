package com.KarthikProject.BooksRepository.Repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.KarthikProject.BooksRepository.Entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
	default List<Book> findAllBooks() {
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
	Book findByBookId(int id);

}

