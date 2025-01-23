package com.salesianos.bicicletas.dto;

import com.salesianos.bicicletas.model.Bicicleta;

public record GetBiciMarca (
        Long id,
        String marca
) {

    public static GetBiciMarca fromBicicleta(Bicicleta bici) {
        return new GetBiciMarca(bici.getId(), bici.getMarca());
    }

}
