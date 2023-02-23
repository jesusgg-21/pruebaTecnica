package com.pichincha.movimientosmicroservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pichincha.movimientosmicroservice.models.Movimiento;


@Repository
public interface MovimientosRepository extends JpaRepository<Movimiento, Long>{
    
    List<Movimiento> findByCuentaId(Long id);
}
