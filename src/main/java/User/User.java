package User;

import Entities.Geschlecht;
import Entities.Interest;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class User {

    @Id
    private int id;
    private String Vorname;
    private String Nachname;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String role;
    private int age;
    private Geschlecht geschlecht;

    @OneToMany
    private List<Interest> interest;

}
