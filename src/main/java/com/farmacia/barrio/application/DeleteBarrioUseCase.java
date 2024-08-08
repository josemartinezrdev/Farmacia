package com.farmacia.barrio.application;

import com.farmacia.barrio.domain.service.BarrioService;

public class DeleteBarrioUseCase {

    private final BarrioService barrioService;

    public DeleteBarrioUseCase(BarrioService barrioService) {
        this.barrioService = barrioService;
    }

    public void execute(int id) {
        barrioService.deleteBarrio(id);
    }

}
