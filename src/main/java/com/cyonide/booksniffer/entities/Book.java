package com.cyonide.booksniffer.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="BOOKS")
public class Book {

	@Id
	@GeneratedValue
	@Column(name="BOOK_ID")
	private int bookId;
	
	@Column(name="BOOK_TITLE", length = 64)
	private String bookTitle;
	
	@Column(name="ISBN", length = 15)
	private String isbn;
	
	@ManyToMany(mappedBy="book")
	private Set<Author> author;
	
	/*@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinTable(name="Publisher_Book",
        joinColumns = @JoinColumn(name="BOOK_ID"),
        inverseJoinColumns = @JoinColumn(name="PUBLISHER_ID"))
	private Set<Publisher> publisher;
	*/

	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Set<Author> getAuthor() {
		return author;
	}
	public void setAuthor(Set<Author> author) {
		this.author = author;
	}
	/*public Set<Publisher> getPublisher() {
		return publisher;
	}
	public void setPublishers(Set<Publisher> publisher) {
		this.publisher = publisher;
	}*/

}
