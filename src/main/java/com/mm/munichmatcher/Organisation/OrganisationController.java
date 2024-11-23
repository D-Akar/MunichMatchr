package com.mm.munichmatcher.Organisation;

import com.mm.munichmatcher.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/organisation")
public class OrganisationController {

    @Autowired
    private OrganisationService organisationService;

    @GetMapping("/get")
    public List<Organisation> getAllOrgas(){
        return organisationService.getAllOrgas();
    }

    @GetMapping("/get/{email}")
    public Organisation getOrgaById(@PathVariable String email) {
        return organisationService.getOrgaByEmail(email);
    }

    @PostMapping("/add")
    public Organisation addOrga(@RequestBody Organisation orga) {
        return organisationService.addOrga(orga);
    }

    @DeleteMapping("/delete/{email}")
    public void deleteOrga(@PathVariable String email) {
        organisationService.deleteUser(email);
    }
}
