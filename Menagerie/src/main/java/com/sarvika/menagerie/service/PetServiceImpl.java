package com.sarvika.menagerie.service;

import com.sarvika.menagerie.exception.EntityNotFoundException;
import com.sarvika.menagerie.exception.InputSexMismatchException;
import com.sarvika.menagerie.model.Event;
import com.sarvika.menagerie.model.Pet;
import com.sarvika.menagerie.model.PetWithEvents;
import com.sarvika.menagerie.repository.PetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PetServiceImpl implements PetService {

    Logger log = LoggerFactory.getLogger(PetServiceImpl.class);

    private PetRepository repository;

    private EventService eventService;

    public PetServiceImpl(PetRepository repository, EventService eventService) {
        this.repository = repository;
        this.eventService = eventService;
    }

    @Override
    public Pet createPet(Pet pet) throws InputSexMismatchException {
        log.info("Pet: {}", pet);

        if (pet.getSex().equals("m") && pet.getSex().equals("f"))
            throw new InputSexMismatchException("Invalid gender! Please choose \"M\" or \"F\"");
        return repository.save(pet);
    }

    @Override
    public Pet updatePet(Pet pet) throws InputSexMismatchException, EntityNotFoundException {

        log.info("Pet: {}", pet);

        if (pet.getSex().equals("m") && pet.getSex().equals("f"))
            throw new InputSexMismatchException("Invalid gender! Please choose \"M\" or \"F\"");

        Pet newPet = repository.findById(pet.getId()).orElse(null);
        if(newPet == null)
            throw new EntityNotFoundException("There is no record for specific id");


        return repository.save(pet);
    }

    @Override
    public List<Pet> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Pet> findAllBySpecies(String species) {
        return repository.findAllBySpecies(species);
    }

    @Override
    public Pet findById(int id) throws EntityNotFoundException {
        Pet pet = repository.findById(id).orElse(null);

        if (pet == null) {
            log.error("No record present in database");
            throw new EntityNotFoundException("There is no record for specific id");
        }

        List<Event> events = eventService.findEventsByPetId(pet.getId());

        log.info("Events: {}", events);

        return pet;
    }

    @Override
    public PetWithEvents createEvent(int id, Event event) throws EntityNotFoundException {
        log.info("Event {}", event);
        Pet pet = repository.findById(id).orElse(null);
        if(pet == null){
            log.error("No record present in database");
            throw new EntityNotFoundException("There is no record for specific id");
        }
        event.setPetId(new Event.EventId(pet.getId()));
        Event createdEvent = eventService.createEvent(event);

        List<Event> eventList = new ArrayList<>();
        eventList.add(createdEvent);

        return new PetWithEvents(pet, eventList);
    }

    @Override
    public void deletePetById(int id) throws EntityNotFoundException {
        Optional<Pet> pet = repository.findById(id);
        if (!pet.isPresent()) {
            log.error("No record present in database");
            throw new EntityNotFoundException("Unable to delete pet record because there is no record for the specific ID: " + id);
        }
        repository.deleteById(id);
    }
}
