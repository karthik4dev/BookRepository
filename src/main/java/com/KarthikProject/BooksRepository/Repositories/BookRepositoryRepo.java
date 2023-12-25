package com.KarthikProject.BooksRepository.Repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.KarthikProject.BooksRepository.Entities.Book;

import java.util.List;



public interface BookRepositoryRepo extends CrudRepository<Book, Integer> {
    Book findByBookNameString(String name);

    Book findByIsbn(String isbn);
}
