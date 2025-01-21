package com.salesianos.bicicletas.model;

import jakarta.persistence.*;
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
    @JoinColumn(name = "usuario_id", foreignKey = @ForeignKey(name = "fk_usuario_uso"))
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "bicicleta_id", foreignKey = @ForeignKey(name = "fk_bicicleta_uso"))
    private Bicicleta bicicleta;

    @ManyToOne
    @JoinColumn(name = "estacion_final_id", foreignKey = @ForeignKey(name = "fk_estacion_final_uso"))
    private Estacion estacionFinal;

}
