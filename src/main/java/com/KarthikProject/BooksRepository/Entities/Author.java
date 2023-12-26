package com.KarthikProject.BooksRepository.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
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
	@JsonManagedReference
	private List<Book> books;


}
