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
    @JoinColumn(name = "estacion_id", foreignKey = @ForeignKey(name = "fk_estacion_bicicleta"))
    private Estacion estacion;

    @OneToMany(mappedBy = "bicicleta")
    @ToString.Exclude
    private List<Uso> usos;

    // Métodos helper ESTACION
    public void addUso(Uso u) {
        this.usos.add(u);
        u.setBicicleta(this);
    }

    public void removeUso(Uso u) {
        this.usos.remove(u);
        u.setBicicleta(null);
    }

}
