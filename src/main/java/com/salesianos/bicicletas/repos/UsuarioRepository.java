package com.salesianos.bicicletas.repos;

import com.salesianos.bicicletas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
