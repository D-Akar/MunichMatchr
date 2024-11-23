package com.mm.munichmatcher.Organisation;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Organisation")
public class Organisation {

    @Id
    private String id;
    private String email;
    private String contactPerson;
    private String description;
    private String phoneNumber;
    private String website;
    private String address;
    private long longitude;

    public Organisation(long longitude, String address, String website, String phoneNumber, String description, String contactPerson, String email, String id) {
        this.longitude = longitude;
        this.address = address;
        this.website = website;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.contactPerson = contactPerson;
        this.email = email;
        this.id = id;
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

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }
}
