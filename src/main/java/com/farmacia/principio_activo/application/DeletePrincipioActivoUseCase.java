package com.farmacia.principio_activo.application;

import com.farmacia.principio_activo.domain.service.PrincipioActivoService;

public class DeletePrincipioActivoUseCase {
    private PrincipioActivoService principioActivoService;

    public DeletePrincipioActivoUseCase(PrincipioActivoService principioActivoService) {
        this.principioActivoService = principioActivoService;
    }

    public void execute(int id) {
        principioActivoService.deletePrincipioAct(id);
    }

}
