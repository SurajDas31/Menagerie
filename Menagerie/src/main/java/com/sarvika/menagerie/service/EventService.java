package com.sarvika.menagerie.service;

import com.sarvika.menagerie.model.Event;
import com.sarvika.menagerie.model.Pet;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface EventService {

    List<Event> findEventsByPetId(Pet pet, Sort eventSort);

    Event createEvent(Event event);

    void deleteEvent(Pet pet);
}
