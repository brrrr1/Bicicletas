package com.salesianos.bicicletas.service;

import com.salesianos.bicicletas.model.Estacion;
import com.salesianos.bicicletas.repos.EstacionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstacionService {

    private final EstacionRepository estacionRepository;

    public List<Estacion> findAll() {
        List<Estacion> result = estacionRepository.findAll();
        if (result.isEmpty())
            throw new EntityNotFoundException("No hay estaciones con esos criterios de búsqueda");
        return result;
    }

    public Estacion findById(Long id) {
        return estacionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No hay estación con ID: " + id));

    }

    public Estacion save(Estacion estacion) {
        return estacionRepository.save(estacion);
    }

    public Estacion edit(Estacion estacion, Long id) {
        return estacionRepository.findById(id)
                .map(old -> {
                    old.setNombre(estacion.getNombre());
                    return estacionRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No hay estación con ID: " + id));

    }

    public void delete(Long id) {
        estacionRepository.deleteById(id);
    }

}
