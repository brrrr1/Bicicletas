package com.salesianos.bicicletas;

import com.salesianos.bicicletas.model.*;
import com.salesianos.bicicletas.repos.*;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class DataSeed {

    private final UsuarioRepository usuarioRepository;
    private final BicicletaRepository bicicletaRepository;
    private final EstacionRepository estacionRepository;
    private final UsoRepository usoRepository;

    @PostConstruct
    public void init() {
        Usuario usuario1 = Usuario.builder()
                .nombre("Juan Perez")
                .numTarjeta("123456789")
                .pin("1234").saldo("50.0")
                .build();

        Usuario usuario2 = Usuario.builder()
                .nombre("Ana Lopez")
                .numTarjeta("987654321")
                .pin("5678")
                .saldo("30.0")
                .build();

        usuarioRepository.save(usuario1);
        usuarioRepository.save(usuario2);

        Estacion estacion1 = Estacion.builder()
                .numero(1).nombre("Estación Central")
                .coordenadas("40.416775,-3.703790")
                .capacidad(10)
                .build();

        Estacion estacion2 = Estacion.builder()
                .numero(2).nombre("Estación Norte")
                .coordenadas("40.452085,-3.688530")
                .capacidad(15)
                .build();

        estacionRepository.save(estacion1);
        estacionRepository.save(estacion2);

        Bicicleta bicicleta1 = Bicicleta.builder()
                .marca("Orbea")
                .modelo("MX50")
                .estado("Disponible")
                .estacion(estacion1)
                .build();

        Bicicleta bicicleta2 = Bicicleta.builder()
                .marca("Giant")
                .modelo("Talon")
                .estado("Disponible")
                .estacion(estacion2)
                .build();

        bicicletaRepository.save(bicicleta1);
        bicicletaRepository.save(bicicleta2);

        Uso uso1 = Uso.builder()
                .fechaInicio(LocalDateTime.now().minusHours(1))
                .fechaFin(LocalDateTime.now())
                .coste(5.0)
                .usuario(usuario1)
                .bicicleta(bicicleta1)
                .estacionFinal(estacion2)
                .build();

        Uso uso2 = Uso.builder()
                .fechaInicio(LocalDateTime.now().minusHours(2))
                .fechaFin(LocalDateTime.now().minusHours(1))
                .coste(3.0)
                .usuario(usuario2)
                .bicicleta(bicicleta2)
                .estacionFinal(estacion1)
                .build();

        usoRepository.save(uso1);
        usoRepository.save(uso2);

        System.out.println("Usuarios: " + usuarioRepository.findAll());
        System.out.println("Estaciones: " + estacionRepository.findAll());
        System.out.println("Bicicletas: " + bicicletaRepository.findAll());
        System.out.println("Usos: " + usoRepository.findAll());
    }
}
