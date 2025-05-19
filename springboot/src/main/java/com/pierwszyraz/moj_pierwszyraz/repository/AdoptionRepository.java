package com.pierwszyraz.moj_pierwszyraz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pierwszyraz.moj_pierwszyraz.model.Adoption;

@Repository
public interface AdoptionRepository extends JpaRepository<Adoption, Long> {
}
