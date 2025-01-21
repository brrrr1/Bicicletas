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
    @ToString.Exclude
    private List<Bicicleta> bicicletas;

    @OneToMany(mappedBy = "estacionFinal")
    @ToString.Exclude
    private List<Uso> usosFinalizados;

    // Métodos helper BICICLETA
    public void addBicicleta(Bicicleta b) {
        this.bicicletas.add(b);
        b.setEstacion(this);
    }

    public void removeBicicleta(Bicicleta b) {
        this.bicicletas.remove(b);
        b.setEstacion(null);
    }

    // Métodos helper USO
    public void addUso(Uso u) {
        this.usosFinalizados.add(u);
        u.setEstacionFinal(this);
    }

    public void removeUso(Uso u) {
        this.usosFinalizados.remove(u);
        u.setEstacionFinal(null);
    }

}
