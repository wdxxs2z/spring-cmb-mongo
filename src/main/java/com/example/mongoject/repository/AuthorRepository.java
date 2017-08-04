package com.example.mongoject.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongoject.domain.Author;

public interface AuthorRepository extends MongoRepository<Author, String>{
	
	public List<Author> findByFirstName(String firstName);

}
