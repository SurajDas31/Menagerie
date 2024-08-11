package com.sarvika.menagerie.service;

import com.sarvika.menagerie.model.Event;
import com.sarvika.menagerie.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService{

    private EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> findEventsByPetId(int id) {

        return eventRepository.findByPetId(id);
    }

    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }
}
