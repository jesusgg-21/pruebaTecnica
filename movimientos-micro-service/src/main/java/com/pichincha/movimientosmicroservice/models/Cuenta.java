package com.pichincha.movimientosmicroservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cuenta {
    private Long cuentaId;
    private String numeroCuenta;
    private String tipoCuenta;
    private Float saldoInicial;
    private Boolean estado;

    private Long clienteID;
    
}
