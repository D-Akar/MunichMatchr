package com.mm.munichmatcher.Event;

import com.mm.munichmatcher.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService eventService;

    //Standard CRUD Operations

    @GetMapping("/getAll")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/get/{name}")
    public Event getEventByName(@PathVariable String name) {
        return eventService.getEventByName(name);
    }

    @PostMapping("/add")
    public Event addEvent(@RequestBody Event event) {
        return eventService.addEvent(event);
    }

    @PutMapping("/update")
    public Event updateEvent(@RequestBody Event event) {
        return eventService.addEvent(event);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEvent(@PathVariable String id) {
        eventService.deleteEvent(id);
    }





}
