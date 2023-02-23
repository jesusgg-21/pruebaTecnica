package com.pichincha.movimientosmicroservice.models;

import java.sql.Date;

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
public class Movimiento {
    @Id
    private Long movimientoId;
    private Date fecha;
    private String tipoMovimiento;
    private Float saldo;
    private Boolean estado;
    
    private Long cuentaId;

}
