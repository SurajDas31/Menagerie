package com.sarvika.menagerie.repository;

import com.sarvika.menagerie.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Integer> {

    List<Pet> findAllBySpecies(String species);
}
