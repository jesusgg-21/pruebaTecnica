package com.pichincha.clientemicroservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pichincha.clientemicroservice.models.Cliente;
import com.pichincha.clientemicroservice.services.ClienteService;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin("*")
@RequestMapping("/cliente")
@AllArgsConstructor
public class ClienteController {

    @Autowired
    private final ClienteService service;

    @CrossOrigin("*")
    @GetMapping("/all")
    public ResponseEntity<List<Cliente>> getAll(){
        List<Cliente> personas = service.getAllClientes();
        if (personas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(personas);
        }
    }

    @CrossOrigin("*")
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable("id") long id){
        Cliente persona = service.getClienteById(id);
        if (persona == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(persona);
        }
    }

    @CrossOrigin("*")
    @PostMapping()
    public ResponseEntity<Cliente> save(@RequestBody Cliente persona){
        Cliente npersona = service.save(persona);
        return ResponseEntity.ok(npersona);

    }

    @CrossOrigin("*")
    @GetMapping("/byperson/{id}")
    public ResponseEntity<List<Cliente>> getByPersonId(@PathVariable("id") long id){
        List<Cliente> personas = service.byPersonaId(id);
        if (personas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(personas);
        }
    }

    @CrossOrigin("*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> deletePersona(@PathVariable("id") long id) {
        try {
            service.deleteCliente(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
