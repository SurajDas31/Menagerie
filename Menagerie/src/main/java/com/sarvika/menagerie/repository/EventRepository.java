package com.sarvika.menagerie.repository;

import com.sarvika.menagerie.model.Event;
import com.sarvika.menagerie.model.Pet;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {
   List<Event> findEventsByPet(Pet pet, Sort sort);

}
