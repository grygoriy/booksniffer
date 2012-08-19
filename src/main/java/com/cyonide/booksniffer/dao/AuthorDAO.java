package com.cyonide.booksniffer.dao;

import java.util.List;

import com.cyonide.booksniffer.entities.Author;

public interface AuthorDAO {
	
	public void addAuthor(Author author);
	public List<Author> listAuthor();
	public Author getAuthor(int id);
}
