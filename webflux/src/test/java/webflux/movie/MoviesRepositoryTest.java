package webflux.movie;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import webflux.app.ReactiveConfiguration;

@SpringBootTest(classes = {ReactiveConfiguration.class})
class MoviesRepositoryTest {

    @Autowired
    private MoviesRepository moviesRepository;

    @DisplayName("Should return all movies")
    @Test
    void shouldReturnAllMovies() {
        var size = moviesRepository.findAll().size();
        Assertions.assertThat(size).isGreaterThan(0);
    }
}