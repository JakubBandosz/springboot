package com.pierwszyraz.moj_pierwszyraz.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pierwszyraz.moj_pierwszyraz.model.Animal;
import com.pierwszyraz.moj_pierwszyraz.services.AnimalService;

@RestController
@RequestMapping("/api/animal")
public class AnimalController{
    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService){
        this.animalService = animalService;
    }
    
    @GetMapping
    public ResponseEntity<Animal> getAnimalById(@RequestParam Integer id) {
        Optional<Animal> animal = animalService.getAnimalById(id);
        if (animal.isPresent()) {
            return ResponseEntity.ok(animal.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Animal> addAnimal(@RequestBody Animal animal) {
        Animal savedAnimal = animalService.saveAnimal(animal);
        return ResponseEntity.ok(savedAnimal);
}
}
