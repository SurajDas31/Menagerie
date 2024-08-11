package com.sarvika.menagerie.service;

import com.sarvika.menagerie.model.Event;

import java.util.List;

public interface EventService {

    List<Event> findEventsByPetId(int id);

    Event createEvent(Event event);
}
