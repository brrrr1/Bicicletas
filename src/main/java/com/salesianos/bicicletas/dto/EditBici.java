package com.salesianos.bicicletas.dto;

public record EditBici(
        String marca,
        String modelo,
        String estado,
        Long estacionId
) {
}
