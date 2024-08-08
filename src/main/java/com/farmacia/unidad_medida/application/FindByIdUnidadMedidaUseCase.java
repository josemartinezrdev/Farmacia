package com.farmacia.unidad_medida.application;

import com.farmacia.unidad_medida.domain.entity.UnidadMedida;
import com.farmacia.unidad_medida.domain.service.UnidadMedidaService;

public class FindByIdUnidadMedidaUseCase {
    private UnidadMedidaService unidadMedidaService;

    public FindByIdUnidadMedidaUseCase(UnidadMedidaService unidadMedidaService) {
        this.unidadMedidaService = unidadMedidaService;
    }

    public UnidadMedida execute(int id) {
        return unidadMedidaService.findByIdUnidadMedida(id);
    }
}
