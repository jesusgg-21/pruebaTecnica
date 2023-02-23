package com.pichincha.movimientosmicroservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pichincha.movimientosmicroservice.models.Cuenta;
import com.pichincha.movimientosmicroservice.models.Movimiento;
import com.pichincha.movimientosmicroservice.repositories.MovimientosRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovimientosService {

    @Autowired
    private final MovimientosRepository repo;
    @Autowired
    RestTemplate restTemplate;

    public List<Movimiento> getAllMovimientos(){
        return repo.findAll();
    }

    public Movimiento getMovimientoById(Long id){
        return repo.findById(id).orElse(null);
    }


    public Movimiento save(Movimiento movimiento){
        Movimiento nuevoMovimiento = repo.save(movimiento);
        return nuevoMovimiento;
    }

    public void deleteMovimiento(Long id){
        repo.deleteById(id);
    }

    public List<Cuenta> byCuentaId(Long id){
        List<Cuenta> cuentas = restTemplate.getForObject("http://localhost:8011/cuenta/bycliente/" + id, List.class);
        return cuentas;
    }

}
