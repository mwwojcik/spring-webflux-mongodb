package webflux.movie;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MoviesReactiveRepository extends ReactiveMongoRepository<Movie,String> {

}
