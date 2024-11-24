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
import java.util.HashMap;
import java.util.List;

@Document(collection = "Event")
public class Event {

    @Id
    private String id;
    private String name;
    private long lat;
    private long lon;
    private String description;

    private String typeOfEvent;

    private List<String> interests;
    private List<String> languages;
    private List<String> availability;
    private List<String> accessibility;

    //@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
    //private String StartDate;
    //@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
    //private String EndDate;

    private String date;
    private int duration;


    private List<String> approvedApplicants;

    private List<String> pendingApplicants;

    private List<String> verifiedApplicants;

    private String organisationName;

    public Event() {}

    public Event(String id, String name, long lat, long lon, String description, String typeOfEvent, List<String> interests, List<String> languages, List<String> availability, List<String> accessibility, String date, int duration, List<String> approvedApplicants, List<String> pendingApplicants, List<String> verifiedApplicants, String organisationName) {
        this.id = id;
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.description = description;
        this.typeOfEvent = typeOfEvent;
        this.interests = interests;
        this.languages = languages;
        this.availability = availability;
        this.accessibility = accessibility;
        this.date = date;
        this.duration = duration;
        this.approvedApplicants = approvedApplicants;
        this.pendingApplicants = pendingApplicants;
        this.verifiedApplicants = verifiedApplicants;
        this.organisationName = organisationName;
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

    public String getTypeOfEvent() {
        return typeOfEvent;
    }

    public void setTypeOfEvent(String typeOfEvent) {
        this.typeOfEvent = typeOfEvent;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<String> getApprovedApplicants() {
        return approvedApplicants;
    }

    public void setApprovedApplicants(List<String> approvedApplicants) {
        this.approvedApplicants = approvedApplicants;
    }

    public List<String> getPendingApplicants() {
        return pendingApplicants;
    }

    public void setPendingApplicants(List<String> pendingApplicants) {
        this.pendingApplicants = pendingApplicants;
    }

    public List<String> getVerifiedApplicants() {
        return verifiedApplicants;
    }

    public void setVerifiedApplicants(List<String> verifiedApplicants) {
        this.verifiedApplicants = verifiedApplicants;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }
}
