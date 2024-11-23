package com.mm.munichmatcher.Organisation;

import com.mm.munichmatcher.Event.Event;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Organisation")
public class Organisation {

    @Id
    private String id;
    private String email;
    //private String contactPerson;
    //private String description;
    //private String phoneNumber;
    //private String website;
    //private String address;
    //private long longitude;
    //private long latitude;
    private List<String> eventName;

    public Organisation() {}

    public Organisation(String id, String email, List<String> events) {
        this.id = id;
        this.email = email;
        this.eventName = events;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getEventName() {
        return eventName;
    }

    public void setEventName(List<String> events) {
        this.eventName = events;
    }
}
