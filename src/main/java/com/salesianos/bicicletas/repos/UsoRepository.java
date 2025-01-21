package com.salesianos.bicicletas.repos;

import com.salesianos.bicicletas.model.Uso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsoRepository extends JpaRepository <Uso, Long> {
}
