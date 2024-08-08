package com.farmacia.principio_activo.application;

import java.util.List;

import com.farmacia.principio_activo.domain.entity.PrincipioActivo;
import com.farmacia.principio_activo.domain.service.PrincipioActivoService;

public class FindAllPrincipioActivoUseCase {
    private PrincipioActivoService principioActivoService;

    public FindAllPrincipioActivoUseCase(PrincipioActivoService principioActivoService) {
        this.principioActivoService = principioActivoService;
    }

    public List<PrincipioActivo> execute() {
        return principioActivoService.findAllPrincipiosActivos();
    }

}
