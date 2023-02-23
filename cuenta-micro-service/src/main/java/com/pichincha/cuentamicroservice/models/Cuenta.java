package com.pichincha.cuentamicroservice.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Cuenta {
    @Id
    private Long cuentaId;
    private String numeroCuenta;
    private String tipoCuenta;
    private Float saldoInicial;
    private Boolean estado;

    private Long clienteID;
}
