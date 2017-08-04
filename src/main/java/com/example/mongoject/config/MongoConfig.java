package com.example.mongoject.config;

import java.net.UnknownHostException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
@EnableMongoRepositories(basePackages = "com.example.mongoject.repository")
public class MongoConfig {

	@Value("${mongodb.host:127.0.0.1}")
	//@Value("${MONGODB_HOST}")
	private String host;

	@Value("${mongodb.port:27017}")
	//@Value("${MONGODB_PORT}")
	private int port;

	@Value("${mongodb.username:user01}")
	//@Value("${MONGODB_USERNAME}")
	private String username;

	@Value("${mongodb.password:pwd123}")
	//@Value("${MONGODB_PASSWORD}")
	private String password;

	@Value("${mongodb.database:testnnn}")
	//@Value("${MONGODB_DATABASE}")
	private String database;

	@Bean
	public MongoClient mongoClient() throws UnknownHostException {
		MongoCredential credentialsList = MongoCredential.createCredential(username,database,password.toCharArray());
		return new MongoClient(new ServerAddress(host, port),Arrays.asList(credentialsList));

	}
	
	@Bean("mongoTemplate")
	public MongoTemplate getMongoTemplate() throws UnknownHostException {
		MongoTemplate mongoTemplate = new MongoTemplate(new SimpleMongoDbFactory(mongoClient(), database));
		return mongoTemplate;
	}
	
}
