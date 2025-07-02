package com.example.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;

@Component
public class BookQueryResolver {

	@Autowired
	private BookRepository bookRepository;

	@QueryMapping
	public Book getBook(Long id) {
		return bookRepository.findById(id).orElse(null);
	}

	@QueryMapping
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

}
