package com.farmacia.barrio.application;

import java.util.List;

import com.farmacia.barrio.domain.entity.Barrio;
import com.farmacia.barrio.domain.service.BarrioService;

public class FindBarrioUseCase {
    private final BarrioService barrioService;

    public FindBarrioUseCase(BarrioService barrioService) {
        this.barrioService = barrioService;
    }

    public List<Barrio> execute() {
        List<Barrio> barrios = barrioService.findAllBarrios();
        return barrios;
    }
}
