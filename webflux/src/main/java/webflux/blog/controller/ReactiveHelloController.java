package webflux.blog.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@RequestMapping("/blog/")
public class ReactiveHelloController {
    @GetMapping(path = "/hello",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> allMsgs() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(i -> new String("Hello " + i));
    }
}