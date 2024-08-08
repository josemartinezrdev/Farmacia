package com.farmacia.principio_activo.application;

import com.farmacia.principio_activo.domain.entity.PrincipioActivo;
import com.farmacia.principio_activo.domain.service.PrincipioActivoService;

public class CreatePrincipioActivoUseCase {
    private PrincipioActivoService principioActivoService;

    public CreatePrincipioActivoUseCase(PrincipioActivoService principioActivoService) {
        this.principioActivoService = principioActivoService;
    }

    public void execute(PrincipioActivo principioActivo) {
        principioActivoService.addPrincipioAct(principioActivo);
    }

}
