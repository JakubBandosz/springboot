package com.pierwszyraz.moj_pierwszyraz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "adoption")
public class Adoption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Dodany klucz główny

    @ManyToOne
    @JoinColumn(name = "adoptionownerid", nullable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "adoptionanimalid", nullable = false)
    private Animal animal;

    public Adoption() {}

    public Adoption(Person person, Animal animal) {
        this.person = person;
        this.animal = animal;
    }

    public Long getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
