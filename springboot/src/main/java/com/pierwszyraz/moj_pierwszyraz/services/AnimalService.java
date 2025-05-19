package com.pierwszyraz.moj_pierwszyraz.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pierwszyraz.moj_pierwszyraz.model.Animal;
import com.pierwszyraz.moj_pierwszyraz.repository.AnimalsRepository;

@Service
public class AnimalService{
    private final AnimalsRepository animalRepository;

    @Autowired
    public AnimalService(AnimalsRepository animalRepository){
        this.animalRepository = animalRepository;
    }

    public List<Animal> getallAnimals(){
        return animalRepository.findAll();
    }

    
    public Optional<Animal> getAnimalById(Integer id){
        return animalRepository.findById(id);
    }

    public Animal saveAnimal(Animal animal) {
        return animalRepository.save(animal);
    }
}