package com.pierwszyraz.moj_pierwszyraz.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pierwszyraz.moj_pierwszyraz.model.AnimalPhoto;
import com.pierwszyraz.moj_pierwszyraz.services.AnimalPhotoService;

@RestController
@RequestMapping("/api/photos")  
public class AnimalPhotoController {

    private final AnimalPhotoService AnimalPhotoService;

    @Autowired
    public AnimalPhotoController(AnimalPhotoService AnimalPhotoService) {
        this.AnimalPhotoService = AnimalPhotoService;
    }

    
   @GetMapping
    public ResponseEntity<AnimalPhoto> getAnimalPhotoById(@RequestParam Integer id) {
        Optional<AnimalPhoto> AnimalPhoto = AnimalPhotoService.getAnimalPhotoById(id);
        if (AnimalPhoto.isPresent()) {
            return ResponseEntity.ok(AnimalPhoto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}