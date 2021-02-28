package webflux.movie;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "movies")
public class Movie {
    @MongoId
    String id;
    private String title;
    private String type;
}
