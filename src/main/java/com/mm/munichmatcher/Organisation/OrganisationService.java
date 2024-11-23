package com.mm.munichmatcher.Organisation;

import org.hibernate.jdbc.Expectation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganisationService {

    @Autowired
    private OrganisationRepository organisationRepository;

    public List<Organisation> getAllOrgas() {
        return organisationRepository.findAll();
    }

    public Organisation getOrgaByEmail(String email) {
        return organisationRepository.findById(email).orElse(null);
    }

    public Organisation addOrga(Organisation orga) {
        return organisationRepository.save(orga);
    }

    public void deleteUser(String email) {
        organisationRepository.deleteByEmail(email);
    }
}
