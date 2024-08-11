package com.sarvika.menagerie.service;

import com.sarvika.menagerie.exception.EntityNotFoundException;
import com.sarvika.menagerie.exception.InputSexMismatchException;
import com.sarvika.menagerie.model.Event;
import com.sarvika.menagerie.model.Pet;
import com.sarvika.menagerie.model.PetWithEvents;

import java.util.List;

public interface PetService {

    Pet createPet(Pet pet) throws InputSexMismatchException;

    Pet updatePet(Pet pet) throws InputSexMismatchException, EntityNotFoundException;

    List<Pet> findAll();

    List<Pet> findAllBySpecies(String species);

    PetWithEvents findById(int id, String sort, String order) throws EntityNotFoundException;

    PetWithEvents createEvent(int id, Event event) throws EntityNotFoundException;

    void deletePetById(int id) throws EntityNotFoundException;


}
