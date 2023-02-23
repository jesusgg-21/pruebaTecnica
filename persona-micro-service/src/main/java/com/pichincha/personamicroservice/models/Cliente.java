package com.pichincha.personamicroservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    private Long clienteId;
    private String contrasenia;
    private Boolean estado;
    
    private Long personaId;
    
}
