package com.cyonide.booksniffer.dao;

import java.util.List;

import com.cyonide.booksniffer.entities.Book;

public interface BookDAO {

	public void addBook(Book book);
	public void removeBook(Book book);
	public List<Book> listBook();
	public Book getBook(int id);
}
