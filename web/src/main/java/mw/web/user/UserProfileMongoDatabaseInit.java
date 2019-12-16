package mw.web.user;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
@Profile("remote")
public class UserProfileMongoDatabaseInit implements ApplicationRunner {

    @Autowired
    private MongoClient client ;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        MongoOperations mongoOps = new MongoTemplate(client, "myfirstbase");

        mongoOps.dropCollection("profile");

        mongoOps.createCollection("profile");

    }
}
