package com.example.mongoject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.example.mongoject.domain.Author;
import com.example.mongoject.domain.Book;
import com.example.mongoject.repository.AuthorRepository;
import com.example.mongoject.repository.BookRepository;

@Component
public class MongoTest {
	
	@Autowired
	private BookRepository bookReopsitory;
	
	@Autowired
	private AuthorRepository authorRepository;

	public BookRepository getBookReopsitory() {
		return bookReopsitory;
	}

	public void setBookReopsitory(BookRepository bookReopsitory) {
		this.bookReopsitory = bookReopsitory;
	}

	public AuthorRepository getAuthorRepository() {
		return authorRepository;
	}

	public void setAuthorRepository(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	@Test
	public void test(){
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("mongodb.xml");
		ctx.start();
		
		MongoTest mongoTest = (MongoTest)ctx.getBean("mongoTest");
		
		BookRepository bp = mongoTest.getBookReopsitory();
		AuthorRepository ap = mongoTest.getAuthorRepository();
		
		Author lily = new Author("adecf4b0-163e-4393-8fb8-79bec83f77fa", 
				"lily", "joo", "New York");
		Author keven = new Author("9517633a-7700-4838-adea-9eba3f1191fd", 
				"keven", "su", "Boston");
		Author lin = new Author("t417633a-7700-4838-adea-9eba3f119123", 
				"lin", "yuhao", "Beijing");
		
		ap.insert(lin);
		List<Author> authors = new ArrayList<Author>();		
		authors.add(lily);
		authors.add(keven);
		ap.insert(authors);
		
		Book b1 = new Book("53348adf-ae23-480e-8185-f2cb809bcaa5", 
				"example_1", 36.60, new Date(2015, 6, 12), authors);
		Book b2 = new Book("3t348adf-ae23-480e-8185-f2cb809bcrr2", 
				"example_2", 33.10, new Date(2011, 2, 1), Arrays.asList(lin));
		bp.insert(b1);
		bp.insert(b2);
		
		System.out.println(bp.findAll().get(0).getAuthors().get(0).getFirstName());
	}

}
