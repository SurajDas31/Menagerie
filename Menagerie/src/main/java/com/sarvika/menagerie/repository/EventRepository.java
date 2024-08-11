package com.sarvika.menagerie.repository;

import com.sarvika.menagerie.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Event.EventId> {

    List<Event> findByPetId(Integer petId);

}
