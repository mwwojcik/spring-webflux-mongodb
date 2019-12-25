package mw.web.nobel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
@Profile("remote")
public class NobelPriceWinnerMongoDatabseInit implements ApplicationRunner {

    @Autowired
    private MongoDbFactory factory ;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        MongoOperations mongoOps = new MongoTemplate(factory);
        mongoOps.dropCollection("nobel");
        mongoOps.createCollection("nobel");
    }
}