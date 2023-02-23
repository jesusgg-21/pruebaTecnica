package com.pichincha.clientemicroservice.models;

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
public class Cliente {
    @Id
    private Long clienteId;
    private String contrasenia;
    private Boolean estado;
    
    private Long personaId;

}
