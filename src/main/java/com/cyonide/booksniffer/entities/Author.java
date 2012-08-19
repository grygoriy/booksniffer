package com.cyonide.booksniffer.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="AUTHORS")
public class Author {
	
	@Id
	@Column(name="AUTHOR_ID")
	@GeneratedValue
	private int authorId;
	
	@Column(name="AUTHOR_NAME", length = 64)
	private String authorName;
	
	@Column(name="AUTHOR_LAST_NAME", length = 64)
	private String authorLastName;
	
	@ManyToMany
	private Set<Book> book;
	
	
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getAuthorLastName() {
		return authorLastName;
	}
	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}
	public Set<Book> getBook() {
		return book;
	}
	public void setBook(Set<Book> book) {
		this.book = book;
	}

	
	

}
