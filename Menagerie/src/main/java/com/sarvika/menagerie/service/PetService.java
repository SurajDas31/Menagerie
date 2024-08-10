package com.sarvika.menagerie.service;

import com.sarvika.menagerie.model.Pet;

import java.util.List;
import java.util.Optional;

public interface PetService {

    Pet createPet(Pet pet);

    Pet updatePet(Pet pet);

    List<Pet> findAll();

    List<Pet> findAllBySpecies(String species);

    Optional<Pet> findById(int id);

    void deletePetById(int id);


}
