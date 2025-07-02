package com.example.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;

public class BookMutationResolver {

	@Autowired
	private BookRepository bookRepository;

	@MutationMapping
	public Book addBook(String title, String author) {
		Book book = new Book();
		book.setTitle(title);
		book.setAuthor(author);
		return bookRepository.save(book);
	}

}
