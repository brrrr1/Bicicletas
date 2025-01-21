package com.salesianos.bicicletas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Estacion {

    @Id
    @GeneratedValue
    private Long id;

    private double numero;
    private String nombre;
    private String coordenadas;
    private int capacidad;

    @OneToMany(mappedBy = "estacion")
    private List<Bicicleta> bicicletas;

    @OneToMany(mappedBy = "estacionFinal")
    private List<Uso> usosFinalizados;

}
