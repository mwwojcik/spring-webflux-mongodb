package mw.web.user;

import com.mongodb.client.MongoClients;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserProfileMongoDatabaseInit implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        MongoOperations mongoOps = new MongoTemplate(MongoClients.create("mongodb://10.22.33.78:27017"), "myfirstbase");

        mongoOps.dropCollection("profile");

        mongoOps.createCollection("profile");

    }
}
