package com.mm.munichmatcher.Organisation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/organisation")
public class OrganisationController {

    @Autowired
    private OrganisationService organisationService;

    @GetMapping("/details")
    public ResponseEntity<String> returnOrga() {
        return ResponseEntity.status(HttpStatus.CREATED).body("Orga");
    }

    @PostMapping
    public ResponseEntity<String> createOrga(){
        return ResponseEntity.status(HttpStatus.OK).body("Product created");
    }

    @PutMapping
    public ResponseEntity<String> updateOrga(){
        return ResponseEntity.status(HttpStatus.OK).body("Product Updated");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteOrga(){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Product deleted");
    }
}
