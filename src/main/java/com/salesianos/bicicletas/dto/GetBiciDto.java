package com.salesianos.bicicletas.dto;

import com.salesianos.bicicletas.model.Bicicleta;

public record GetBiciDto (
        Long id,
        String marca,
        String modelo,
        String estado,
        GetEstacionDto estacion
){

    public static GetBiciDto of(Bicicleta bici) {
        return new GetBiciDto(bici.getId(), bici.getMarca(), bici.getModelo(), bici.getEstado(), GetEstacionDto.of(bici.getEstacion()));
    }

}
