package com.cyonide.booksniffer.dao;

import com.cyonide.booksniffer.entities.Author;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    @SuppressWarnings("unchecked")
	public List<Author> listAuthor() {
		return hibernateTemplate.findByCriteria(DetachedCriteria.forClass(Author.class));
		
	}

}
