package com.sarvika.menagerie.service;

import com.sarvika.menagerie.model.Event;
import com.sarvika.menagerie.model.Pet;
import com.sarvika.menagerie.repository.EventRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService{

    private EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> findEventsByPetId(Pet pet, Sort eventSort) {
        System.out.println(eventSort);
        List<Event> eventsByPetId = eventRepository.findEventsByPet(pet, eventSort);
        return eventsByPetId;
    }

    @Override
    public Event createEvent(Event event) {
        eventRepository.save(event);
        return event;
    }
}
