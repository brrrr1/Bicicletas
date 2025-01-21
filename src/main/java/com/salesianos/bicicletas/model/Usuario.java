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
    private List<Uso> usos;
}
