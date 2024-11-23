package com.mm.munichmatcher.User;

import com.mm.munichmatcher.Entities.Geschlecht;
import com.mm.munichmatcher.Entities.Interest;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class User {

    @Id
    private int id;
    private String name;
//    private String Nachname;
//    private String email;
//    private String password;
//    private String phone;
//    private String address;
//    private String role;
//    private int age;
//    private Geschlecht geschlecht;

    //@OneToMany
    //private List<Interest> interest;


    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
