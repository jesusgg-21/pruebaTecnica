package com.pichincha.cuentamicroservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pichincha.cuentamicroservice.models.Cliente;
import com.pichincha.cuentamicroservice.models.Cuenta;
import com.pichincha.cuentamicroservice.repositories.CuentaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CuentaService {

    @Autowired
    private final CuentaRepository repo;
    @Autowired
    RestTemplate restTemplate;

    public List<Cuenta> getAllCuentas(){
        return repo.findAll();
    }

    public Cuenta getCuentaById(Long id){
        return repo.findById(id).orElse(null);
    }

    public Cuenta save(Cuenta cuenta){
        Cuenta nuevaCuenta = repo.save(cuenta);
        return nuevaCuenta;
    }

    public List<Cliente> byClienteId(Long id){
        List<Cliente> cuentas = restTemplate.getForObject("http://localhost:8011/cliente/byperson/" + id, List.class);
        return cuentas;
    }

    public void deleteCuenta(Long id){
        repo.deleteById(id);
    }


}
