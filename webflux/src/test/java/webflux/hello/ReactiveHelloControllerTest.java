package webflux.hello;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.Duration;

@SpringBootTest
@AutoConfigureWebTestClient
class ReactiveHelloControllerTest {

    private final String s = "/api/hello";
    @Autowired
    private WebTestClient webTestClient;

    // @formatter:off
    @DisplayName(
            "when GET on api/hello, " +
                    "then hello message with status 200 is returned"
    )
    // @formatter:on
    @Test
    void test() throws Exception {
        // when
        webTestClient.get().uri(s).accept(MediaType.TEXT_EVENT_STREAM).exchange()
                // then
                .expectStatus().isOk().expectBody().jsonPath("$.msg")
                .isEqualTo("hello");
    }

}