package com.salesianos.bicicletas.service;

import com.salesianos.bicicletas.dto.EditBici;
import com.salesianos.bicicletas.model.Bicicleta;
import com.salesianos.bicicletas.repos.BicicletaRepository;
import com.salesianos.bicicletas.repos.EstacionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BicicletaService {

    private final BicicletaRepository bicicletaRepository;
    private final EstacionRepository estacionRepository;

    public List<Bicicleta> findAll() {
        List<Bicicleta> result = bicicletaRepository.findAll();
        if (result.isEmpty())
            throw new EntityNotFoundException("No hay bicicletas con esos criterios de búsqueda");
        return result;
    }

    public Bicicleta findById(Long id) {
        return bicicletaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No hay bicicleta con ID: "+ id));
    }

    public Bicicleta save(EditBici nuevo) {
        return bicicletaRepository.save(Bicicleta.builder()
                .marca(nuevo.marca())
                .modelo(nuevo.modelo())
                .estado(nuevo.estado())
                .estacion(estacionRepository.findById(nuevo.estacionId())
                        .orElseThrow(() -> new EntityNotFoundException("No hay bicicleta con ID: "+ nuevo.estacionId())))
                .build());
    }

    public Bicicleta edit(EditBici editBiciCmd, Long id) {
        return bicicletaRepository.findById(id)
                .map(old -> {
                    old.setMarca(editBiciCmd.marca());
                    old.setModelo(editBiciCmd.modelo());
                    old.setEstado(editBiciCmd.estado());
                    old.setEstacion(estacionRepository.findById(editBiciCmd.estacionId())
                            .orElseThrow(() -> new EntityNotFoundException("No hay estación con ID: "+ editBiciCmd.estacionId())));
                    return bicicletaRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No hay bicicleta con ID: "+ id));

    }

    public void delete(Long id) {
        bicicletaRepository.deleteById(id);
    }

    public List<Bicicleta> findByMarca(String marca) {
        List<Bicicleta> result = bicicletaRepository.findByMarca(marca);
        if (result.isEmpty())
            throw new EntityNotFoundException("No hay bicicletas con esa marca");
        return result;
    }

}
