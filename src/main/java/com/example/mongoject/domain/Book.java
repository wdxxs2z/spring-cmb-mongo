package com.example.mongoject.domain;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE)
@Document(collection="example_book")
public class Book {
	
	@JsonSerialize
	@JsonProperty("book_id")
	@Id
	private String bookId;
	
	@JsonSerialize
	@JsonProperty("book_name")
	private String name;
	
	@JsonSerialize
	@JsonProperty("book_price")
	private double price;
	
	@JsonSerialize
	@JsonProperty("book_publication_time")
	private Date publicationTime;
	
	@JsonSerialize
	@JsonProperty("book_authors")
	@DBRef
	private List<Author> authors;
	
	public Book(String bookId, String name, double price, Date publicationTime, List<Author> authors) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.price = price;
		this.publicationTime = publicationTime;
		this.authors = authors;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getPublicationTime() {
		return publicationTime;
	}

	public void setPublicationTime(Date publicationTime) {
		this.publicationTime = publicationTime;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
}
