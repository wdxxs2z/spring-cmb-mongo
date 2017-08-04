package com.example.mongoject.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongoject.domain.Book;

public interface BookRepository extends MongoRepository<Book, String>{
	
	public List<Book> findByName(String bookName);

}
