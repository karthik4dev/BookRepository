package com.KarthikProject.BooksRepository.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@RequiredArgsConstructor
@Data
@Table(name = "authors")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "author_id")
	public int id;
	
	private String authorName;
	
	private String email;
	/*Bi-Directional Mapping -  mapping done on both entities so both can control other entity*/
	@OneToMany(mappedBy = "author")
	private List<Book> books;


}
