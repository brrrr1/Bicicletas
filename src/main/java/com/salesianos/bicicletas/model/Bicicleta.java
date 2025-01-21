package com.salesianos.bicicletas.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Bicicleta {

    @Id
    @GeneratedValue
    private Long id;

    private String marca;
    private String modelo;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "estacion_id")
    private Estacion estacion;

    @OneToMany(mappedBy = "bicicleta")
    private List<Uso> usos;


}
