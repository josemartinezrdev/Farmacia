package com.farmacia.unidad_medida.application;

import com.farmacia.unidad_medida.domain.service.UnidadMedidaService;

public class DeleteUnidadMedidaUseCase {
    private UnidadMedidaService unidadMedidaService;

    public DeleteUnidadMedidaUseCase(UnidadMedidaService unidadMedidaService) {
        this.unidadMedidaService = unidadMedidaService;
    }

    public void execute(int id) {
        unidadMedidaService.deleteUnidadMedida(id);
    }
}
