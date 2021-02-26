package webflux.reactive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

public class ReactiveOperatorTest {

    @DisplayName("Simple map operator test")
    @Test
    void simpleMapOperatorTest() {
        Flux.just(1, 2, 3).map(i -> i * 5).subscribe(System.out::println);
    }
}
