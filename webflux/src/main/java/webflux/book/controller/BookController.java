package webflux.book.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import webflux.book.model.Book;
import webflux.book.mongo.BookReactiveRepo;

@RestController
public class BookController {

    private BookReactiveRepo repository;

    public BookController(BookReactiveRepo repo) {
        repository = repo;
    }

    @PostMapping(value = "/book")
    public Mono<Book> createBook(@RequestBody Book book) {
        return repository.save(book);
    }

}
