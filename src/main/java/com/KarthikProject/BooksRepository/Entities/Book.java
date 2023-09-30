package com.KarthikProject.BooksRepository.Entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookId;
	
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getBookId() {
		return bookId;
	}
	
	private String bookNameString;
	private String isbn;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "authorID")
	private Author author;
	
	public String getBookNameString() {
		return bookNameString;
	}
	public void setBookNameString(String bookNameString) {
		this.bookNameString = bookNameString;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
}
