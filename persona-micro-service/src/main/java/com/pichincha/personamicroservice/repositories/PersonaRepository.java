package com.pichincha.personamicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pichincha.personamicroservice.models.Persona;


@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{
    
}
