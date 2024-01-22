package com.KarthikProject.BooksRepository.Repositories;

import com.KarthikProject.BooksRepository.Entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepositoryRepo extends JpaRepository<Author, Integer> {
}
