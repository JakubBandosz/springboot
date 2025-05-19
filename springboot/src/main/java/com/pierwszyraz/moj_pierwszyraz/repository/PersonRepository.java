package com.pierwszyraz.moj_pierwszyraz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pierwszyraz.moj_pierwszyraz.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    
}