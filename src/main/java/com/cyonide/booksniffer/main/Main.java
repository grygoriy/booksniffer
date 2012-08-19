package com.cyonide.booksniffer.main;



import java.util.Set;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.cyonide.booksniffer.dao.AuthorDAOImpl;
import com.cyonide.booksniffer.dao.BookDAOImpl;
import com.cyonide.booksniffer.entities.Author;
import com.cyonide.booksniffer.entities.Book;


@SuppressWarnings("deprecation")
public class Main {
	
		
	
	public static void main(String[] args) {
		
		Resource resource = new FileSystemResource("src/main/resources/applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		
		Author author = new Author();
		Book book = new Book();
		
		
		author.setAuthorName("Mike");
		author.setAuthorLastName("Simson");
		
		book.setBookTitle("First Book");
		book.setIsbn("1897 FGTR");
			
		author.setBook((Set<Book>) book);
	//	book.getAuthor().add(author);
		
		AuthorDAOImpl authorDAOImpl = (AuthorDAOImpl) factory.getBean("authorDAOImpl");
		BookDAOImpl bookDAOImpl = (BookDAOImpl) factory.getBean("bookDAOImpl");
		
		bookDAOImpl.addBook(book);
		authorDAOImpl.addAuthor(author);
		
		Author empResult = authorDAOImpl.getAuthor(1);
		System.out.println(empResult);
		
		
		
	}


}
