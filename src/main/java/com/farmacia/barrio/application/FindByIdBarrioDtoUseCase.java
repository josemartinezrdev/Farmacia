package com.farmacia.barrio.application;

import com.farmacia.barrio.domain.entity.BarrioDto;
import com.farmacia.barrio.domain.service.BarrioService;

public class FindByIdBarrioDtoUseCase {

    private BarrioService barrioService;

    public FindByIdBarrioDtoUseCase(BarrioService barrioService) {
        this.barrioService = barrioService;
    }

    public BarrioDto execute(int id) {
        return barrioService.findBarrioDtoById(id);
    }
}
