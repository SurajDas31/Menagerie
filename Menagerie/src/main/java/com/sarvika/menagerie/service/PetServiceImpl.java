package com.sarvika.menagerie.service;

import com.sarvika.menagerie.controller.PetController;
import com.sarvika.menagerie.model.Pet;
import com.sarvika.menagerie.repository.PetRepository;
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
    public List<Pet> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Pet> findAllBySpecies(String species) {
        return repository.findAllBySpecies(species);
    }

    @Override
    public Optional<Pet> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void deletePetById(int id) {
        repository.deleteById(id);
    }
}
