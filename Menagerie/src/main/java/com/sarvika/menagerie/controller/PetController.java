package com.sarvika.menagerie.controller;

import com.sarvika.menagerie.model.Pet;
import com.sarvika.menagerie.repository.PetRepository;
import com.sarvika.menagerie.service.PetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PetController {

    Logger log = LoggerFactory.getLogger(PetController.class);

    private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/pets")
    public ResponseEntity getPets(@RequestParam(required = false) String species){

        if(species != null){
            return new ResponseEntity(petService.findAllBySpecies(species), HttpStatus.OK);
        }

        return new ResponseEntity(petService.findAll(), HttpStatus.OK);

    }


    @GetMapping("/pets/{id}")
    public ResponseEntity getPetsById(@PathVariable int id){
        log.info("id: {}",id);
        return new ResponseEntity(petService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/pets")
    public ResponseEntity addPets(@Valid @RequestBody Pet pet){
        log.info("Pet: {}", pet);

        Pet save = petService.createPet(pet);
        return new ResponseEntity(save, HttpStatus.OK);
    }
}
