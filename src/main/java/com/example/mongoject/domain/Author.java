package com.example.mongoject.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE)
@Document(collection="example_author")
public class Author {
	
	@JsonSerialize
	@JsonProperty("author_id")
	@Id
	private String authorId;
	
	@JsonSerialize
	@JsonProperty("author_firstname")
	private String firstName;
	
	@JsonSerialize
	@JsonProperty("author_lastname")
	private String lastName;
	
	@JsonSerialize
	@JsonProperty("author_address")
	private String address;

	public Author(String authorId, String firstName, String lastName, String address) {
		super();
		this.authorId = authorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}

	public String getAuthorId() {
		return authorId;
	}
	
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
