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
    private String name;
    private String organisation;
    private List<String> interests;
    private String language;
    //@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
    private String StartDate;
    //@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
    private String EndDate;
    private int capacity;
    @DBRef
    private List<User> applicants;
    @DBRef
    private List<User> approvedApplicants;
    @DBRef
    private List<User> rejectedApplicants;
    @DBRef
    private List<User> applicantsParticipated;
    @DBRef
    private List<User> applicantsNotParticipated;

    private String organisatorEmail;

    public Event() {}

    public Event(String name, String organisation, List<String> interests, String language, String startDate, String endDate, int capacity, List<User> applicants, List<User> approvedApplicants, List<User> rejectedApplicants, List<User> applicantsParticipated, List<User> applicantsNotParticipated, String organisator) {
        this.name = name;
        this.organisation = organisation;
        this.interests = interests;
        this.language = language;
        StartDate = startDate;
        EndDate = endDate;
        this.capacity = capacity;
        this.applicants = applicants;
        this.approvedApplicants = approvedApplicants;
        this.rejectedApplicants = rejectedApplicants;
        this.applicantsParticipated = applicantsParticipated;
        this.applicantsNotParticipated = applicantsNotParticipated;
        this.organisatorEmail = organisator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<User> getApplicants() {
        return applicants;
    }

    public void setApplicants(List<User> applicants) {
        this.applicants = applicants;
    }

    public List<User> getApprovedApplicants() {
        return approvedApplicants;
    }

    public void setApprovedApplicants(List<User> approvedApplicants) {
        this.approvedApplicants = approvedApplicants;
    }

    public List<User> getRejectedApplicants() {
        return rejectedApplicants;
    }

    public void setRejectedApplicants(List<User> rejectedApplicants) {
        this.rejectedApplicants = rejectedApplicants;
    }

    public List<User> getApplicantsParticipated() {
        return applicantsParticipated;
    }

    public void setApplicantsParticipated(List<User> applicantsParticipated) {
        this.applicantsParticipated = applicantsParticipated;
    }

    public List<User> getApplicantsNotParticipated() {
        return applicantsNotParticipated;
    }

    public void setApplicantsNotParticipated(List<User> applicantsNotParticipated) {
        this.applicantsNotParticipated = applicantsNotParticipated;
    }

    public String getOrganisator() {
        return organisatorEmail;
    }

    public void setOrganisator(String organisator) {
        this.organisatorEmail = organisator;
    }
}
