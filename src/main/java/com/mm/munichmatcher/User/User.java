package com.mm.munichmatcher.User;

import com.mm.munichmatcher.Entities.Geschlecht;
import com.mm.munichmatcher.Entities.Interest;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document(collection = "User")
public class User {

    @Id
    private String id;
    private String name;

    public User() {}

    public User(String id, String name) {
        this.id = id;
        this.name = name;
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
}
