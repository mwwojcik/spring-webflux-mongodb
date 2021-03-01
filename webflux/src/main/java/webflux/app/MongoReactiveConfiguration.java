package webflux.app;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EnableReactiveMongoRepositories(basePackages = "webflux")
public class MongoReactiveConfiguration extends AbstractReactiveMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "training";
    }

    @Override
    public MongoClient reactiveMongoClient() {
        return MongoClients.create("mongodb://192.168.0.114:27017");
    }

}
