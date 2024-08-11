package com.sarvika.menagerie.model;

import java.util.List;

public class PetWithEvents {

    private Pet pet;

    private List<Event> eventList;

    public PetWithEvents(Pet pet, List<Event> eventList) {
        this.pet = pet;
        this.eventList = eventList;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }
}
