package com.pierwszyraz.moj_pierwszyraz.services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pierwszyraz.moj_pierwszyraz.model.AnimalPhoto;
import com.pierwszyraz.moj_pierwszyraz.repository.AnimalPhotoRepository;

@Service
public class AnimalPhotoService {
    private final AnimalPhotoRepository animalphotoRepository;

    @Autowired
    public AnimalPhotoService(AnimalPhotoRepository animalphotoRepository){
        this.animalphotoRepository = animalphotoRepository;
    }

    public Optional<AnimalPhoto> getAnimalPhotoById(Integer id){
        return animalphotoRepository.findById(id);
    }
}