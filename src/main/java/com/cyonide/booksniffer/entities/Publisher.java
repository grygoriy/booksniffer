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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*@Entity
@Table(name="PUBLISHERS")*/
public class Publisher {

	/*@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="PUBLISHER_ID")
	private int publisherId;
	
	@Column(name="PUBLISHER_TITLE", length = 64)
	private String publisherTitle;
	
	@OneToMany( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinTable(name="Publisher_Book",
        joinColumns = @JoinColumn(name="PUBLISHER_ID"),
        inverseJoinColumns = @JoinColumn(name="BOOK_ID"))
	private Set<Book> books;
	
	public int getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}
	public String getPublisherTitle() {
		return publisherTitle;
	}
	public void setPublisherTitle(String publisherTitle) {
		this.publisherTitle = publisherTitle;
	}
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}*/
	
}
