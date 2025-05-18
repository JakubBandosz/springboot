package com.pierwszyraz.moj_pierwszyraz.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pierwszyraz.moj_pierwszyraz.dto.AdoptionRequest;
import com.pierwszyraz.moj_pierwszyraz.model.Adoption;
import com.pierwszyraz.moj_pierwszyraz.services.AdoptionService;

@RestController
@RequestMapping("/api/adoptions")

public class AdoptionController {

    private final AdoptionService adoptionService;

    @Autowired
    public AdoptionController(AdoptionService adoptionService) {
        this.adoptionService = adoptionService;
    }

    @PostMapping
    public ResponseEntity<Adoption> adoptAnimal(@RequestBody AdoptionRequest request) {
        Optional<Adoption> adoption = adoptionService.createAdoption(request.getPersonId(), request.getAnimalId());
        return adoption.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
