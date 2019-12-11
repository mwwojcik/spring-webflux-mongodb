package webflux.book.mongo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import webflux.book.model.Book;

public interface BookReactiveRepo extends ReactiveMongoRepository<Book, String> {
}
