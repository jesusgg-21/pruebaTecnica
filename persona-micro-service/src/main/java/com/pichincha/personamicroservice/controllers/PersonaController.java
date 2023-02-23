package com.pichincha.personamicroservice.controllers;

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

import com.pichincha.personamicroservice.models.Cliente;
import com.pichincha.personamicroservice.models.Persona;
import com.pichincha.personamicroservice.services.PersonaService;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin("*")
@RequestMapping("/persona")
@AllArgsConstructor
public class PersonaController {

    @Autowired
    private final PersonaService service;

    @CrossOrigin("*")
    @GetMapping("/all")
    public ResponseEntity<List<Persona>> getAll(){
        List<Persona> personas = service.getAllPersonas();
        if (personas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(personas);
        }
    }

    @CrossOrigin("*")
    @GetMapping("/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") long id){
        Persona persona = service.getPersonaById(id);
        return ResponseEntity.ok(persona);
        /*if (persona == null) {
            return ResponseEntity.notFound().build();
        }else{
        }*/
    }

    @CrossOrigin("*")
    @PostMapping()
    public ResponseEntity<Persona> save(@RequestBody Persona persona){
        Persona npersona = service.save(persona);
        return ResponseEntity.ok(npersona);

    }

    @CrossOrigin("*")
    @GetMapping("/usuarios/{id}")
    public ResponseEntity<List<Cliente>> getUsuarios(@PathVariable("id") long id){
        Persona persona = service.getPersonaById(id);
        if (persona == null) {
            return ResponseEntity.notFound().build();
        }else{
            List<Cliente> clientes = service.getClientes(id);
            return ResponseEntity.ok(clientes);
        }
    }

    @CrossOrigin("*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Persona> deletePersona(@PathVariable("id") long id) {
        try {
            service.deletePersona(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
