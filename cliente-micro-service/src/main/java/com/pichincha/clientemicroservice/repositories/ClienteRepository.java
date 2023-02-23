package com.pichincha.clientemicroservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pichincha.clientemicroservice.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
    List<Cliente> findByPersonaId(Long id);
}
