package com.pichincha.personamicroservice.models;

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
public class Persona {
    @Id
    private Long idPersona;
    private String nombre;
    private String genero;
    private String edad;
    private String identificacion;
    private String direccion;
    private String telefono;

}
