package mw.web.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;
@Document(collection = "profile")
public class UserProfileEntry {

    @MongoId
    private String id;
    private String name;
    private String lastname;
    private List<String> emails;

    public UserProfileEntry(String id, String name, String lastname, List<String> emails) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.emails = emails;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }
}
