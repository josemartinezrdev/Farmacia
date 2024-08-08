package com.farmacia.barrio.application;

import java.util.List;

import com.farmacia.barrio.domain.entity.BarrioDto;
import com.farmacia.barrio.domain.service.BarrioService;

public class FindBarrioDtoUseCase {

    private BarrioService barrioService;

    public FindBarrioDtoUseCase(BarrioService barrioService) {
        this.barrioService = barrioService;
    }

    public List<BarrioDto> execute() {
        return barrioService.findAllBarriosDto();
    }

}
