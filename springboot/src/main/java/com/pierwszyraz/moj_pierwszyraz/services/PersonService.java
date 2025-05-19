package com.pierwszyraz.moj_pierwszyraz.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pierwszyraz.moj_pierwszyraz.model.Person;
import com.pierwszyraz.moj_pierwszyraz.repository.PersonRepository;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    
    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Optional<Person> getPersonById(Integer id){
        return personRepository.findById(id);
    }
}
