package com.mm.munichmatcher.Event;

import com.mm.munichmatcher.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    //filter für alle Events, die überhaupt in Frage kommen
    public List<Event> getFilteredEvents(User user) {
        List<String> interests = user.getInterests();
        String userLanguague = user.getLanguague();
        return getAllEvents().stream().filter(event -> event.getInterests().stream().anyMatch(interests::contains) && userLanguague.equals(event.getLanguage())).toList();
    }

    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    public void deleteEvent(String id) {
        eventRepository.deleteByName(id);
    }

    public Event getEventByName(String name) {
        return eventRepository.findByName(name);
    }


    //TODO: Calculate Number of Days between StartDate and EndDate
}
