package com.pichincha.clientemicroservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pichincha.clientemicroservice.models.Cliente;
import com.pichincha.clientemicroservice.repositories.ClienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {

    @Autowired
    private final ClienteRepository repo;

    public List<Cliente> getAllClientes(){
        return repo.findAll();
    }

    public Cliente getClienteById(Long id){
        return repo.findById(id).orElse(null);
    }


    public Cliente save(Cliente persona){
        Cliente nuevaPersona = repo.save(persona);
        return nuevaPersona;
    }

    public List<Cliente> byPersonaId(Long id){
        return repo.findByPersonaId(id);
    }

    public void deleteCliente(Long id){
        repo.deleteById(id);
    }

}
