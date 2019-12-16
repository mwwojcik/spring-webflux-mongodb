package mw.web.user;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories
@Profile("remote")
public class UserProfileMongoConfiguration {

    /*
     * Use the standard Mongo driver API to create a com.mongodb.MongoClient instance.
     */
    public @Bean MongoClient mongoClient() {
        return MongoClients.create("mongodb://10.22.33.78:27017");
    }

    public @Bean
    MongoDbFactory mongoDbFactory(@Autowired MongoClient client) {
        return new SimpleMongoClientDbFactory( client, "test");
    }
}

