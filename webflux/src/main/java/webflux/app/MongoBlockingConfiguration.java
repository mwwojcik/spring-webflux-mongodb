package webflux.app;

/*import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;*/
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "webflux")
public class MongoBlockingConfiguration {


    @Bean(name = "blockingClient")
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://192.168.0.114:27017/training");
    }

    @Bean
    public MongoTemplate mongoTemplate(@Autowired @Qualifier("blockingClient") MongoClient client) {
        return new MongoTemplate(client, "training");
     }

}
