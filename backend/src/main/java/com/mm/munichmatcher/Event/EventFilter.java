package com.mm.munichmatcher.Event;

import java.util.List;


public class EventFilter {

    private List<String> interests;
    private List<String> languages;

    public EventFilter() {
    }

    public EventFilter(List<String> interests, List<String> languages) {
        this.interests = interests;
        this.languages = languages;
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
}
