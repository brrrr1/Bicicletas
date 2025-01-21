package com.salesianos.bicicletas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Uso {

    @Id @GeneratedValue
    private Long id;

    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private double coste;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "bicicleta_id")
    private Bicicleta bicicleta;

    @ManyToOne
    @JoinColumn(name = "estacion_final_id")
    private Estacion estacionFinal;


}
