package com.KarthikProject.BooksRepository.Entities;

import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "authors")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
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

	public void add(Book book){
		if(books == null){
			books=new ArrayList<Book>();
		}
		books.add(book);
	}

}
