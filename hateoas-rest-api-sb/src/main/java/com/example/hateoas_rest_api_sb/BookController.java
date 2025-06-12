package com.example.hateoas_rest_api_sb;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.hateoas_rest_api_sb.Book;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/books")
public class BookController {

    private static final List<Book> books = new ArrayList<>();
    static {
        books.add(new Book(1L, "1984", "George Orwell"));
        books.add(new Book(2L, "To Kill a Mockingbird", "Harper Lee"));
        books.add(new Book(3L, "The Great Gatsby", "F. Scott Fitzgerald"));
    }

    @GetMapping("/{id}")
    public EntityModel<Book> getBookById(@PathVariable Long id) {
        Book book = books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Book not found"));

        EntityModel<Book> resource = EntityModel.of(book);
        resource.add(linkTo(methodOn(BookController.class).getBookById(id)).withSelfRel());
        resource.add(linkTo(methodOn(BookController.class).getAllBooks()).withRel("books"));

        return resource;
    }

    @GetMapping
    public CollectionModel<EntityModel<Book>> getAllBooks() {
        List<EntityModel<Book>> bookResources = books.stream()
                .map(book -> EntityModel.of(book,
                        linkTo(methodOn(BookController.class).getBookById(book.getId())).withSelfRel()))
                .collect(Collectors.toList());

        return CollectionModel.of(bookResources, linkTo(methodOn(BookController.class).getAllBooks()).withSelfRel());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(@PathVariable Long id, @RequestBody Book newBook) {
        return ResponseEntity.ok("Book updated for ID: " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        return ResponseEntity.ok("Book deleted for ID: " + id);
    }
}
