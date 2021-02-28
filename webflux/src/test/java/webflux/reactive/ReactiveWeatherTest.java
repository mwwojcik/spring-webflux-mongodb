package webflux.reactive;

import java.time.Duration;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

/**
 * https://stackoverflow.com/questions/12581072/intellij-thread-debug
 */
@Slf4j
public class ReactiveWeatherTest {

    private static final int SLEEP_TIME_MILLIS = 1000;

    @DisplayName("Should fetch the Weather in the reactive way.")
    @Test
    void shouldFetchTheWeatherInTheReactiveWay() {
        //StepVerifier.create(Weather.rxRetch("Warsaw")).expectNextCount(1).verifyComplete();
        Weather.rxFetch("Warsaw").subscribe((Weather w) -> this.print(w));

    }

    @DisplayName("Should return weather in reactive way with timeout - should Throw timeout exception when no result in timeout")
    @Test
    void shouldReturnWeatherInReactiveWayWithTimeout() {

        //Weather.rxRetch("Radom").timeout(Duration.ofMillis(500)).subscribe();
        StepVerifier.create(Weather.rxFetch("Radom").timeout(Duration.ofMillis(500))).expectError().verify();
        StepVerifier.create(Weather.rxFetch("Radom").timeout(Duration.ofMillis(2000))).expectNextCount(1).verifyComplete();
    }

    @DisplayName("Should display weathers from different cities")
    @Test
    void shouldDisplayWeathersFromDifferentCities() {
        var warsaw = Weather.rxFetch("Warsaw");
        var radom = Weather.rxFetch("Radom");

        var weathers = warsaw.mergeWith(radom);

        weathers.doOnNext(this::print).subscribe();
        //two SYNC (not async!) operations returns  2 objects

        //subscribe() is blocking
        //warsaw.subscribe();
        //this line is reachead after finish warsaw stream!
    }

    @DisplayName("Should process data on cities in concurrent way ")
    @Test
    void shouldProcessDataOnCitiesIConcurrentWay() {
        Scheduler s = Schedulers.newParallel("parallel-scheduler", 4);

        var weather = Weather.rxFetch("Warsaw");
        var info = TouristInfo.rxFetch("Warsaw");

        weather=weather.subscribeOn(s);
        info=info.subscribeOn(s);

        weather.zipWith(info,(Weather w,TouristInfo t)->new CityInfo(w,t)).subscribe((CityInfo c)->print(c));

        System.out.println("Let's wait for child threads to finish");
        Sleeper.sleep(Duration.ofMillis(1000));
    }

    public void print(Weather weather) {
        log.info(String.format("Got: %s", weather.kind));
    }

    public void print(CityInfo cityInfo) {
        log.info(String.format("Got wether: %s in the country %s", cityInfo.getWeather().getKind(),cityInfo.getInfo().getCountry()));
    }

    @Slf4j
    @AllArgsConstructor
    @Getter
    static class Weather {

        private String kind;

        public static Weather fetch(String city) {
            Sleeper.sleep(Duration.ofMillis(SLEEP_TIME_MILLIS));
            log.info(String.format("Load weather for city %s", city));
            return new Weather("Sunny");
        }

        public static Mono<Weather> rxFetch(String city) {
            return Mono.fromSupplier(() -> fetch(city));
        }
    }

    @Slf4j
    @AllArgsConstructor
    @Getter
    static class TouristInfo {

        private String country;

        public static TouristInfo fetch(String city) {
            Sleeper.sleep(Duration.ofMillis(SLEEP_TIME_MILLIS));
            log.info(String.format("Load tourist information for city %s", city));
            return new TouristInfo("Poland");
        }

        public static Mono<TouristInfo> rxFetch(String city) {
            return Mono.fromSupplier(() -> fetch(city));
        }
    }

    @Getter
    @Builder
   static class CityInfo{
        private Weather weather;
        private TouristInfo info;

    }
}


