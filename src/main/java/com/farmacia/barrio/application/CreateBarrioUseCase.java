package com.farmacia.barrio.application;

import com.farmacia.barrio.domain.entity.Barrio;
import com.farmacia.barrio.domain.service.BarrioService;

public class CreateBarrioUseCase {

    private final BarrioService barrioService;

    public CreateBarrioUseCase(BarrioService barrioService) {
        this.barrioService = barrioService;
    }

    public void execute(Barrio barrio) {
        barrioService.addBarrio(barrio);
    }
}
