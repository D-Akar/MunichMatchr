package com.mm.munichmatcher.OrgaEvent;

import com.mm.munichmatcher.Event.Event;
import com.mm.munichmatcher.Event.EventService;
import com.mm.munichmatcher.Organisation.Organisation;
import com.mm.munichmatcher.Organisation.OrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orgaEvent")
public class OrgaEventController {

    @Autowired
    private OrganisationService organisationService;
    @Autowired
    private EventService eventService;

    /*@GetMapping("/getEventsForOrga/{email}")
    public List<Event> getEventsforOrga(@PathVariable String email) {
        Organisation orga = organisationService.getOrgaByEmail(email);
        return eventService.getAllEvents().stream().filter(event -> event.getOrganisation().equals(orga.getEmail())).toList();
    }*/

}
