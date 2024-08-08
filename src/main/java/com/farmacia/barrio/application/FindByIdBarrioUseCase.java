package com.farmacia.barrio.application;

import com.farmacia.barrio.domain.entity.Barrio;
import com.farmacia.barrio.domain.service.BarrioService;

public class FindByIdBarrioUseCase {
    private final BarrioService barrioService;

    public FindByIdBarrioUseCase(BarrioService barrioService) {
        this.barrioService = barrioService;
    }

    public Barrio execute(int idbarrio) {
        Barrio barrio = barrioService.findBarrioById(idbarrio);
        return barrio;
    }
}
