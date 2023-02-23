package com.pichincha.cuentamicroservice.controllers;

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

import com.pichincha.cuentamicroservice.models.Cliente;
import com.pichincha.cuentamicroservice.models.Cuenta;
import com.pichincha.cuentamicroservice.services.CuentaService;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin("*")
@RequestMapping("/cuenta")
@AllArgsConstructor
public class CuentaController {

    @Autowired
    private final CuentaService service;

    @CrossOrigin("*")
    @GetMapping("/all")
    public ResponseEntity<List<Cuenta>> getAll(){
        List<Cuenta> cuentas = service.getAllCuentas();
        if (cuentas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(cuentas);
        }
    }

    @CrossOrigin("*")
    @GetMapping("/{id}")
    public ResponseEntity<Cuenta> getById(@PathVariable("id") long id){
        Cuenta cuenta = service.getCuentaById(id);
        if (cuenta == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(cuenta);
        }
    }

    @CrossOrigin("*")
    @PostMapping()
    public ResponseEntity<Cuenta> save(@RequestBody Cuenta cuenta){
        Cuenta ncuenta = service.save(cuenta);
        return ResponseEntity.ok(ncuenta);

    }

    @CrossOrigin("*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Cuenta> deletePersona(@PathVariable("id") long id) {
        try {
            service.deleteCuenta(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @CrossOrigin("*")
    @GetMapping("/bycliente/{id}")
    public ResponseEntity<List<Cliente>> getByPersonId(@PathVariable("id") long id){
        List<Cliente> clientes = service.byClienteId(id);
        if (clientes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(clientes);
        }
    }

}
