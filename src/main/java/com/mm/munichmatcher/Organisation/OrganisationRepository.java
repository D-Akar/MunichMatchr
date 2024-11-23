package com.mm.munichmatcher.Organisation;

import com.mm.munichmatcher.User.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganisationRepository extends MongoRepository<Organisation, String> {

    Organisation findByEmail(String email);

    void deleteByEmail(String email);
}
