package webflux.blog;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories
public class BlogMongoDatabaseConfiguration {
    /*
     * Use the standard Mongo driver API to create a com.mongodb.MongoClient instance.
     */
    public @Bean
    MongoClient mongoClient() {
        return MongoClients.create("mongodb://10.22.33.78:27017");
    }

    public @Bean
    MongoDbFactory mongoDbFactory() {
        return new SimpleMongoClientDbFactory( mongoClient(), "test");
    }
}
