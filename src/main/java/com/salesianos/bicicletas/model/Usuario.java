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
public class Usuario {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String numTarjeta;
    private String pin;
    private String saldo;

    @OneToMany(mappedBy = "usuario")
    @ToString.Exclude
    private List<Uso> usos;

    // Métodos helper USO
    public void addUso(Uso u) {
        this.usos.add(u);
        u.setUsuario(this);
    }

    public void removeUso(Uso u) {
        this.usos.remove(u);
        u.setUsuario(null);
    }

}
