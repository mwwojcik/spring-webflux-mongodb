package webflux.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import webflux.blog.BlogMongoWebfluxApplication;

@SpringBootApplication
public class ReactiveHelloSpringApplication {
    public static void main(String[] args) {

            SpringApplication.run(ReactiveHelloSpringApplication.class, args);
    }
}
