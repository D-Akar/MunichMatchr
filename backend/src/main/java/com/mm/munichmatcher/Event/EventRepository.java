package com.mm.munichmatcher.Event;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {

    Event findByName(String name);

    void deleteByName(String name);
}
