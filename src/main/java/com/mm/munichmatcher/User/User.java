package com.mm.munichmatcher.User;

import com.mm.munichmatcher.Entities.AgeGroup;
import com.mm.munichmatcher.Entities.Interest;
import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "User")
public class User {

    //id = email
    private String id;
    private String firstName;
    private String lastName;

    private int eventCounter;

    private List<String> languagues;
    private List<String> interests;
    private List<String> preferredTypesOfEvents;

    private int coins;

    public User() {}

    public User(String id, String firstName, String lastName, int eventCounter, List<String> languagues, List<String> interests, List<String> preferredTypesOfEvents, int coins) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.eventCounter = eventCounter;
        this.languagues = languagues;
        this.interests = interests;
        this.preferredTypesOfEvents = preferredTypesOfEvents;
        this.coins = coins;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getEventCounter() {
        return eventCounter;
    }

    public void setEventCounter(int eventCounter) {
        this.eventCounter = eventCounter;
    }

    public List<String> getLanguagues() {
        return languagues;
    }

    public void setLanguagues(List<String> languagues) {
        this.languagues = languagues;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public List<String> getPreferredTypesOfEvents() {
        return preferredTypesOfEvents;
    }

    public void setPreferredTypesOfEvents(List<String> preferredTypesOfEvents) {
        this.preferredTypesOfEvents = preferredTypesOfEvents;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
}
