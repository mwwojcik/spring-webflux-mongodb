package webflux.book;

import com.mongodb.reactivestreams.client.MongoClients;
import com.mongodb.reactivestreams.client.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.core.ReactiveMongoClientFactoryBean;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories
public class BookMongoDatabaseConfiguration {

    /*
     * Use the Reactive Streams Mongo Client API to create a com.mongodb.reactivestreams.client.MongoClient instance.
     */
   /* public @Bean MongoClient reactiveMongoClient()  {
        return MongoClients.create("mongodb://root:root@10.22.33.78:27017");
    }*/


  /*  public @Bean
    ReactiveMongoDatabaseFactory reactiveMongoDatabaseFactory() {
        return new SimpleReactiveMongoDatabaseFactory(MongoClients.create("mongodb://root:root@10.22.33.78:27017"), "database");
    }

    public @Bean ReactiveMongoTemplate reactiveMongoTemplate() {
        return new ReactiveMongoTemplate(reactiveMongoDatabaseFactory());
    }*/

}
