package com.sarvika.menagerie.service;

import com.sarvika.menagerie.controller.PetController;
import com.sarvika.menagerie.exception.EntityNotFoundException;
import com.sarvika.menagerie.model.Pet;
import com.sarvika.menagerie.repository.PetRepository;
import org.hibernate.action.internal.EntityActionVetoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetServiceImpl implements PetService {

    Logger log = LoggerFactory.getLogger(PetServiceImpl.class);

    private PetRepository repository;

    public PetServiceImpl(PetRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pet createPet(Pet pet) {
        log.info("Pet: {}", pet);
        return repository.save(pet);
    }

    @Override
    public Pet updatePet(Pet pet) {
        log.info("Pet: {}", pet);
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
    public Optional<Pet> findById(int id) throws EntityNotFoundException {
        Optional<Pet> pet = repository.findById(id);
        if(!pet.isPresent()) {
            log.error("No record present in database");
            throw new EntityNotFoundException("There is no record for specific id");
        }

        return pet;
    }

    @Override
    public void deletePetById(int id) throws EntityNotFoundException {
        Optional<Pet> pet = repository.findById(id);
        if(!pet.isPresent()) {
            log.error("No record present in database");
            throw new EntityNotFoundException("Unable to delete pet record because there is no record for the specific ID: "+id);
        }
        repository.deleteById(id);
    }
}
