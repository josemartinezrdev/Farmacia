package com.farmacia.principio_activo.application;

import com.farmacia.principio_activo.domain.entity.PrincipioActivo;
import com.farmacia.principio_activo.domain.service.PrincipioActivoService;

public class FindByIdPrincipioActivoUseCase {
    private PrincipioActivoService principioActivoService;

    public FindByIdPrincipioActivoUseCase(PrincipioActivoService principioActivoService) {
        this.principioActivoService = principioActivoService;
    }

    public PrincipioActivo execute(int id) {
        return principioActivoService.findByIdPrincipioAct(id);
    }
}
