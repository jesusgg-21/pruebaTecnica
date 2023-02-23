package com.pichincha.personamicroservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pichincha.personamicroservice.models.Cliente;
import com.pichincha.personamicroservice.models.Persona;
import com.pichincha.personamicroservice.repositories.PersonaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonaService {

    @Autowired
    PersonaRepository repo;

    @Autowired
    RestTemplate restTemplate;

    public List<Persona> getAllPersonas(){
        return repo.findAll();
    }

    public Persona getPersonaById(Long id){
        return repo.findById(id).orElse(null);
    }


    public Persona save(Persona persona){
        Persona nuevaPersona = repo.save(persona);
        return nuevaPersona;
    }

    public List<Cliente> getClientes(Long id){
        List<Cliente> clientes = restTemplate.getForObject("http://localhost:8011/cliente/byperson/" + id, List.class);
        return clientes;
    }

    public void deletePersona(Long id){
        repo.deleteById(id);
    }

}
