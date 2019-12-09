package webflux.hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class SimpleHelloHandlerRouter {
    @Bean
    public RouterFunction<ServerResponse> route(SimpleHelloHandler helloHandler) {
        return RouterFunctions
                .route(GET("/api/hello"), helloHandler::hello);
    }
}
