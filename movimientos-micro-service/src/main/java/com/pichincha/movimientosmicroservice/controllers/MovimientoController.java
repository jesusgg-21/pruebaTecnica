package com.pichincha.movimientosmicroservice.controllers;

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

import com.pichincha.movimientosmicroservice.models.Cuenta;
import com.pichincha.movimientosmicroservice.models.Movimiento;
import com.pichincha.movimientosmicroservice.services.MovimientosService;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin("*")
@RequestMapping("/movimiento")
@AllArgsConstructor
public class MovimientoController {

    @Autowired
    private final MovimientosService service;

    @CrossOrigin("*")
    @GetMapping("/all")
    public ResponseEntity<List<Movimiento>> getAll(){
        List<Movimiento> movimientos = service.getAllMovimientos();
        if (movimientos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(movimientos);
        }
    }

    @CrossOrigin("*")
    @GetMapping("/{id}")
    public ResponseEntity<Movimiento> getById(@PathVariable("id") long id){
        Movimiento movimiento = service.getMovimientoById(id);
        if (movimiento == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(movimiento);
        }
    }

    @CrossOrigin("*")
    @PostMapping()
    public ResponseEntity<Movimiento> save(@RequestBody Movimiento movimiento){
        Movimiento nmovimiento = service.save(movimiento);
        return ResponseEntity.ok(nmovimiento);

    }


    @CrossOrigin("*")
    @GetMapping("/bycuentas/{id}")
    public ResponseEntity<List<Cuenta>> getByPersonId(@PathVariable("id") long id){
        List<Cuenta> cuentas = service.byCuentaId(id);
        if (cuentas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(cuentas);
        }
    }


    @CrossOrigin("*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Movimiento> deletePersona(@PathVariable("id") long id) {
        try {
            service.deleteMovimiento(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
