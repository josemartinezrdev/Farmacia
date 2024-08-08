package com.farmacia.principio_activo.application;

import com.farmacia.principio_activo.domain.entity.PrincipioActivo;
import com.farmacia.principio_activo.domain.service.PrincipioActivoService;

public class UpdatePrincipioActivoUseCase {
    private PrincipioActivoService principioActivoService;

    public UpdatePrincipioActivoUseCase(PrincipioActivoService principioActivoService) {
        this.principioActivoService = principioActivoService;
    }

    public void execute(PrincipioActivo principioActivo) {
        principioActivoService.updatePrincipioAct(principioActivo);
    }

}
