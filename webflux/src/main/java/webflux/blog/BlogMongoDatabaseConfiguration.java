package webflux.blog;

/*@Configuration
@EnableReactiveMongoRepositories*/
public class BlogMongoDatabaseConfiguration {
    /* *//*
     * Use the standard Mongo driver API to create a com.mongodb.MongoClient instance.
     *//*
    public @Bean
    MongoClient mongoClient() {
        return MongoClients.create("mongodb://10.22.33.78:27017");
    }

    public @Bean
    MongoDbFactory mongoDbFactory() {
        return new SimpleMongoClientDbFactory( mongoClient(), "test");
    }*/
}
