package com.mm.munichmatcher.UserEvent;

import com.mm.munichmatcher.Event.Event;
import com.mm.munichmatcher.Event.EventService;
import com.mm.munichmatcher.User.User;
import com.mm.munichmatcher.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /*@PutMapping("/anmeldung/{email}/{eventName}")
    public void anmelden(@PathVariable String email, @PathVariable String eventName) {
        User user = userService.getUserByEmail(email);
        if (user == null) {
            throw new RuntimeException("User mit Email " + email + " nicht gefunden.");
        }

        Event event = eventService.getEventByName(eventName);
        if (event == null) {
            throw new RuntimeException("Event mit Name " + eventName + " nicht gefunden.");
        }
        if(event.getApplicants() != null) {
            event.getApplicants().add(user);
        }
        else {
            event.setApplicants(List.of(user));
        }
        eventService.addEvent(event); //save
    }*/
}
