package com.pierwszyraz.moj_pierwszyraz.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "animals")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animalid")
    private Integer animalId;

    @ManyToOne
    @JoinColumn(name = "ownerid")
    private Person owner;

    @Column(name = "animaltype")
    private String animalType;

    @Column(name = "animalname")
    private String animalName;

    @Column(name = "animalage")
    private Integer animalAge;

    @Column(name = "animaltimeinshelter")
    private Integer animalTimeInShelter;

    @Column(name = "animalfur")
    private String animalFur;

    @Column(name = "animalsize")
    private String animalSize;

    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AnimalPhoto> photos;

    @OneToMany(mappedBy = "animal")
    private List<Adoption> adoptions;

    public Animal() {
    }

    // Gettery i settery

    public Integer getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Integer animalId) {
        this.animalId = animalId;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public Integer getAnimalAge() {
        return animalAge;
    }

    public void setAnimalAge(Integer animalAge) {
        this.animalAge = animalAge;
    }

    public Integer getAnimalTimeInShelter() {
        return animalTimeInShelter;
    }

    public void setAnimalTimeInShelter(Integer animalTimeInShelter) {
        this.animalTimeInShelter = animalTimeInShelter;
    }

    public String getAnimalFur() {
        return animalFur;
    }

    public void setAnimalFur(String animalFur) {
        this.animalFur = animalFur;
    }

    public String getAnimalSize() {
        return animalSize;
    }

    public void setAnimalSize(String animalSize) {
        this.animalSize = animalSize;
    }

    public List<AnimalPhoto> getPhotos() {
        return photos;
    }

    public void setPhotos(List<AnimalPhoto> photos) {
        this.photos = photos;
    }

    public List<Adoption> getAdoptions() {
        return adoptions;
    }

    public void setAdoptions(List<Adoption> adoptions) {
        this.adoptions = adoptions;
    }
}
