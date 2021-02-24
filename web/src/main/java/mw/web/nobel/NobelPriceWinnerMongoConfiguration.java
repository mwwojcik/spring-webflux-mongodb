package mw.web.nobel;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;

@Configuration
public class NobelPriceWinnerMongoConfiguration {
    @Profile("remote")
    public @Bean MongoClient mongoClient() {
        return MongoClients.create("mongodb://10.22.33.78:27017");
    }

    @Profile("remote")
    public @Bean
    MongoDatabaseFactory mongoDbFactory(@Autowired MongoClient client) {
        return new SimpleMongoClientDatabaseFactory(client, "nobel");
    }
}
