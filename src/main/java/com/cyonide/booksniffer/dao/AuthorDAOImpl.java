package com.cyonide.booksniffer.dao;

import java.util.List;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.cyonide.booksniffer.entities.Author;

@Repository
public class AuthorDAOImpl implements AuthorDAO {
	
	private Author author;
	
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void addAuthor(final Author author) {
		hibernateTemplate.saveOrUpdate(author);
	}

	@Override
	public Author getAuthor(final int id) {
		hibernateTemplate.get(Author.class, id);		
		return author;
						
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public List<Author> listAuthor() {
		throw new NotImplementedException();
		
	}

}
