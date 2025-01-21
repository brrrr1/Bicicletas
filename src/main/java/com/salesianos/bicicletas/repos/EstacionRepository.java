package com.salesianos.bicicletas.repos;

import com.salesianos.bicicletas.model.Estacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstacionRepository extends JpaRepository <Estacion, Long> {
}
