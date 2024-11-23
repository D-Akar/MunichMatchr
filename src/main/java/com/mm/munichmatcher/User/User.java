package com.mm.munichmatcher.User;

import com.mm.munichmatcher.Entities.Geschlecht;
import com.mm.munichmatcher.Entities.Interest;
import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document(collection = "User")
public class User {

    @Id
    private String email;
    private String name;

    public User() {}

    public User(String email, String name) {
        this.email = email;
        this.name = name;
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
}
