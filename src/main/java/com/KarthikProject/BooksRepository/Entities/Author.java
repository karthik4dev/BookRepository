package com.KarthikProject.BooksRepository.Entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "author")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int authorId;
	
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public int getAuthorId() {
		return authorId;
	}
	
	private String authorName;
	
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	
	private String email;
	/*Bi-Directional Mapping -  mapping done on both entities so both can control other entity*/
	@OneToMany(mappedBy = "author")
	private List<Book> book;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
	
}
