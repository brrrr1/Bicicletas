package com.salesianos.bicicletas.dto;

import com.salesianos.bicicletas.model.Estacion;

public record GetEstacionDto(
        Long id,
        String nombre
) {

    public static GetEstacionDto of(Estacion estacion) {
        return new GetEstacionDto(estacion.getId(), estacion.getNombre());
    }

}
