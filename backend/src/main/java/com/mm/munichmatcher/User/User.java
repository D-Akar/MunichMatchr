package com.mm.munichmatcher.User;

import com.mm.munichmatcher.Entities.AgeGroup;
import com.mm.munichmatcher.Entities.Interest;
import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "User")
public class User {

    @Id
    //private int id;
    private String email;
    private String name;

    private int eventCounter;

    private List<String> languagues;
    private List<String> interests;
    private List<String> preferredTypesOfEvents;


    private int coins;

    private String password;

    private int isAdmin;
    private String organisationName;

    public User() {
    }

    public User(String email, String name, int eventCounter, List<String> languagues, List<String> interests, List<String> preferredTypesOfEvents, int coins, String password, int isAdmin, String organisationName) {
        this.email = email;
        this.name = name;
        this.eventCounter = eventCounter;
        this.languagues = languagues;
        this.interests = interests;
        this.preferredTypesOfEvents = preferredTypesOfEvents;
        this.coins = coins;
        this.password = password;
        this.isAdmin = isAdmin;
        this.organisationName = organisationName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }
}