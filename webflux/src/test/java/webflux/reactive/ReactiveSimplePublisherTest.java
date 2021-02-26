package webflux.reactive;


import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.assertj.core.api.Fail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;
import reactor.test.StepVerifier;

/**
 * Publisher<T>  - reactive interface represents a DATA sequence.
 * Is base for Flux<T> and Mono<T>
 *
 * FluxSink - reactive date emitter
 */
public class ReactiveSimplePublisherTest {

    private Executor executor = Executors.newFixedThreadPool(1);

    @DisplayName("Simple flux tests")
    @Test
    void simple() {
        Publisher<Integer> range = Flux.range(0, 10);
        StepVerifier.create(range).expectNext(0,1,2,3,4,5,6,7,8,9).verifyComplete();

        var strings = Flux.just("ala", "ma", "kota");
        StepVerifier.create(strings).expectNextCount(3).verifyComplete();

    }

   @DisplayName("Simple programmaticaly creating a sequence")
   @Test
   void simpleProgrammaticalyCreatingASequence() {
    Flux<String> streamOfStrings=Flux.generate(this::simpleHelloWorldGenerator);
    StepVerifier.create(streamOfStrings).expectNext("Hello world").verifyComplete();
    }


    @DisplayName("Simple programmaticaly creating a sequence with state")
    @Test
    void simpleProgrammaticalyCreatingASequenceWithState() {
        var sequence = Flux.generate(() -> 0,this::simpleGeneratorWithState);
        StepVerifier.create(sequence).expectNextCount(11).verifyComplete();
    }

    private Integer simpleGeneratorWithState(Integer state,SynchronousSink<String>sink){
        sink.next("3 x" + state + 3 * state);
        if (state == 10) {
            sink.complete();
        }
        return state + 1;
    }

    private void simpleHelloWorldGenerator(SynchronousSink<String> sink){
        sink.next("Hello world");
        sink.complete();
    }


}
