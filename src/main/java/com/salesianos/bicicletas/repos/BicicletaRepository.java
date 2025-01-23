package com.salesianos.bicicletas.repos;

import com.salesianos.bicicletas.model.Bicicleta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BicicletaRepository extends JpaRepository <Bicicleta, Long> {

    List<Bicicleta> findByMarca(String marca);

}
