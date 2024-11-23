package com.mm.munichmatcher.User;

import com.mm.munichmatcher.Entities.AgeGroup;
import com.mm.munichmatcher.Entities.Interest;
import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "User")
public class User {

    @Id
    private int id;
    private String email;
    private String name;

    private int age;
    private String languague;
    private List<String> interests;

    private int coins;

    public User() {}

    public User(String email, String name, int age, String languague, List<String> interests) {
        this.email = email;
        this.name = name;
        this.age = age;
        this.languague = languague;
        this.interests = interests;
        this.coins = 0;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLanguague() {
        return languague;
    }

    public void setLanguague(String languague) {
        this.languague = languague;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
}
