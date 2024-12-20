package com.mm.munichmatcher.UserEvent;

import com.mm.munichmatcher.Event.Event;
import com.mm.munichmatcher.Event.EventService;
import com.mm.munichmatcher.User.User;
import com.mm.munichmatcher.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/userEvent")
public class UserEventController {

    @Autowired
    private UserService userService;
    @Autowired
    private EventService eventService;

    @GetMapping("/getFiltered/{email}")
    public List<Event> getFilteredEvents(@PathVariable String email) {
        User user = userService.getUserByEmail(email);
        return eventService.getFilteredEvents(user);
    }

    @GetMapping("/adminView/{email}")
    public List<String>[] getAdminView(@PathVariable String email) {
        User user = userService.getUserByEmail(email);
        if (user == null || user.getIsAdmin() != 1) {
            return null;
        }

        List<String>[] adminView = new List[3];
        for (int i = 0; i < 3; i++) {
            adminView[i] = new ArrayList<>();
        }

        List<Event> eventsFromOrganiserList = eventService.getAllEvents().stream().filter(event -> event.getOrganisationName().equals(user.getOrganisationName())).toList();
        for (Event event : eventsFromOrganiserList) {
            adminView[0].addAll(event.getPendingApplicants());
            adminView[1].addAll(event.getApprovedApplicants());
            adminView[2].addAll(event.getVerifiedApplicants());
        }

        return adminView;
    }

    @PutMapping("/anmeldung/{email}/{eventName}")
    public void anmelden(@PathVariable String email, @PathVariable String eventName) {
        User user = userService.getUserByEmail(email);
        if (user == null) {
            throw new RuntimeException("User mit Email " + email + " nicht gefunden.");
        }

        Event event = eventService.getEventByName(eventName);
        if (event == null) {
            throw new RuntimeException("Event mit Name " + eventName + " nicht gefunden.");
        }
        if(event.getPendingApplicants() != null) {
            event.getPendingApplicants().add(user.getEmail());
        }
        else {
            event.setPendingApplicants(List.of(user.getEmail()));
        }
        eventService.addEvent(event); //save
    }

     @PutMapping("/accept/{email}/{eventName}")
    public void accept(@PathVariable String email, @PathVariable String eventName) {
        User user = userService.getUserByEmail(email);
        if (user == null) {
            throw new RuntimeException("User mit Email " + email + " nicht gefunden.");
        }

        Event event = eventService.getEventByName(eventName);
        if (event == null) {
            throw new RuntimeException("Event mit Name " + eventName + " nicht gefunden.");
        }

        if(!event.getPendingApplicants().contains(user.getEmail())) {
            throw new RuntimeException("User mit Email " + email + " hat sich nicht angemeldet.");
        }
        else {
            event.getPendingApplicants().remove(user.getEmail());
            List<String> approved = event.getApprovedApplicants();
            if(approved != null) {
                approved.add(user.getEmail());
            }
            else {
                event.setApprovedApplicants(List.of(user.getEmail()));
            }
        }
        eventService.addEvent(event); //save
    }

    @PutMapping("/verify/{email}/{eventName}")
    public void verify(@PathVariable String email, @PathVariable String eventName) {
        User user = userService.getUserByEmail(email);
        if (user == null) {
            throw new RuntimeException("User mit Email " + email + " nicht gefunden.");
        }

        Event event = eventService.getEventByName(eventName);
        if (event == null) {
            throw new RuntimeException("Event mit Name " + eventName + " nicht gefunden.");
        }

        if(!event.getApprovedApplicants().contains(user.getEmail())) {
            throw new RuntimeException("User mit Email " + email + " hat sich nicht angemeldet.");
        }
        else {
            event.getApprovedApplicants().remove(user.getEmail());
            List<String> verified = event.getVerifiedApplicants();
            if(verified != null) {
                verified.add(user.getEmail());
            }
            else {
                event.setVerifiedApplicants(List.of(user.getEmail()));
            }
            user.setEventCounter(user.getEventCounter() + 1);
            user.setCoins(user.getCoins() + 20);
            userService.deleteUser(user.getEmail());
            userService.addUser(user);
        }
        eventService.addEvent(event); //save
    }
}
