package com.farmacia.unidad_medida.application;

import java.util.List;

import com.farmacia.unidad_medida.domain.entity.UnidadMedida;
import com.farmacia.unidad_medida.domain.service.UnidadMedidaService;

public class FindAllUnidadMedidaUseCase {

    private UnidadMedidaService unidadMedidaService;

    public FindAllUnidadMedidaUseCase(UnidadMedidaService unidadMedidaService) {
        this.unidadMedidaService = unidadMedidaService;
    }

    public List<UnidadMedida> execute() {
        return unidadMedidaService.findAllUnidadesMedidas();
    }
}
