package com.pierwszyraz.moj_pierwszyraz.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pierwszyraz.moj_pierwszyraz.model.Adoption;
import com.pierwszyraz.moj_pierwszyraz.model.Animal;
import com.pierwszyraz.moj_pierwszyraz.model.Person;
import com.pierwszyraz.moj_pierwszyraz.repository.AdoptionRepository;
import com.pierwszyraz.moj_pierwszyraz.repository.AnimalsRepository;
import com.pierwszyraz.moj_pierwszyraz.repository.PersonRepository;

@Service
public class AdoptionService {

    private final AdoptionRepository adoptionRepository;
    private final PersonRepository personRepository;
    private final AnimalsRepository animalsRepository;

    @Autowired
    public AdoptionService(AdoptionRepository adoptionRepository, PersonRepository personRepository, AnimalsRepository animalRepository) {
        this.adoptionRepository = adoptionRepository;
        this.personRepository = personRepository;
        this.animalsRepository = animalRepository;
    }

    public Optional<Adoption> createAdoption(Integer personId, Integer animalId) {
        Optional<Person> personOpt = personRepository.findById(personId);
        Optional<Animal> animalOpt = animalsRepository.findById(animalId);

        if (personOpt.isPresent() && animalOpt.isPresent()) {
            Adoption adoption = new Adoption(personOpt.get(), animalOpt.get());
            return Optional.of(adoptionRepository.save(adoption));
        }

        return Optional.empty();
    }
}
