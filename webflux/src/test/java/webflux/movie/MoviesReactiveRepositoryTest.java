package webflux.movie;

import org.assertj.core.api.Fail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import webflux.app.MongoBlockingConfiguration;
import webflux.app.MongoReactiveConfiguration;

@SpringBootTest(classes = {MongoReactiveConfiguration.class})
class MoviesReactiveRepositoryTest {

    @Autowired
    private MoviesReactiveRepository moviesReactiveRepo;

    @DisplayName("Should return all movies in reactive way")
    @Test
    void shouldReturnAllMoviesInReactiveWay() {
        moviesReactiveRepo.findAll().subscribe();
    }
}