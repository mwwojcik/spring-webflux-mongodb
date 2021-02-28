package webflux.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({ReactiveConfiguration.class})
public class ReactiveHelloSpringApplication {
    public static void main(String[] args) {
            SpringApplication.run(ReactiveHelloSpringApplication.class, args);
    }
}
