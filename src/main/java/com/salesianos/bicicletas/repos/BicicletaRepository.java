package com.salesianos.bicicletas.repos;

import com.salesianos.bicicletas.model.Bicicleta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BicicletaRepository extends JpaRepository <Bicicleta, Long> {
}
