package com.farmacia.unidad_medida.application;

import com.farmacia.unidad_medida.domain.entity.UnidadMedida;
import com.farmacia.unidad_medida.domain.service.UnidadMedidaService;

public class CreateUnidadMedidaUseCase {
    private UnidadMedidaService unidadMedidaService;

    public CreateUnidadMedidaUseCase(UnidadMedidaService unidadMedidaService) {
        this.unidadMedidaService = unidadMedidaService;
    }

    public void execute(UnidadMedida unidadMedida) {
        unidadMedidaService.addUnidadMedida(unidadMedida);
    }
}
