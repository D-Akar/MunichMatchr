package com.mm.munichmatcher.Event;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mm.munichmatcher.Organisation.Organisation;
import com.mm.munichmatcher.User.User;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "Event")
public class Event {

    @Id
    private String id;
    private String name;
    private long lat;
    private long lon;
    private String description;

    private List<String> interests;
    private String language;
    private List<String> availability;
    private List<String> accessibility;

    //@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
    private String StartDate;
    //@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
    private String EndDate;

    @DBRef
    private List<User> approvedApplicants;
    @DBRef
    private List<User> pendingApplicants;

    public Event() {}

    public Event(String name, long lat, long lon, String description, List<String> interests, String language, List<String> availability, List<String> accessibility, String startDate, String endDate, List<User> approvedApplicants, List<User> pendingApplicants) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.description = description;
        this.interests = interests;
        this.language = language;
        this.availability = availability;
        this.accessibility = accessibility;
        StartDate = startDate;
        EndDate = endDate;
        this.approvedApplicants = approvedApplicants;
        this.pendingApplicants = pendingApplicants;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getLat() {
        return lat;
    }

    public void setLat(long lat) {
        this.lat = lat;
    }

    public long getLon() {
        return lon;
    }

    public void setLon(long lon) {
        this.lon = lon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<String> getAvailability() {
        return availability;
    }

    public void setAvailability(List<String> availability) {
        this.availability = availability;
    }

    public List<String> getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(List<String> accessibility) {
        this.accessibility = accessibility;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    public List<User> getApprovedApplicants() {
        return approvedApplicants;
    }

    public void setApprovedApplicants(List<User> approvedApplicants) {
        this.approvedApplicants = approvedApplicants;
    }

    public List<User> getPendingApplicants() {
        return pendingApplicants;
    }

    public void setPendingApplicants(List<User> pendingApplicants) {
        this.pendingApplicants = pendingApplicants;
    }
}
