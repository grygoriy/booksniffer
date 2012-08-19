package com.cyonide.booksniffer.dao;

import java.util.List;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.cyonide.booksniffer.entities.Book;

@Repository
public class BookDAOImpl implements BookDAO {
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void addBook(final Book book) {
		hibernateTemplate.saveOrUpdate(book);
	}

	@Override
	public void removeBook(final Book book) {
		hibernateTemplate.delete(book);
	}

	@Override
	public List<Book> listBook() {
		throw new NotImplementedException();
	}

	@Override
	public Book getBook(final int id) {
		return hibernateTemplate.get(Book.class, id);
	
	}
}