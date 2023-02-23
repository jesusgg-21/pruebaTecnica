package com.pichincha.cuentamicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pichincha.cuentamicroservice.models.Cuenta;


@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long>{
    
}
