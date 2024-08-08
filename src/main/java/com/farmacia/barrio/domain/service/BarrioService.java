package com.farmacia.barrio.domain.service;

import java.util.List;

import com.farmacia.barrio.domain.entity.Barrio;
import com.farmacia.barrio.domain.entity.BarrioDto;

public interface BarrioService {
    public void addBarrio(Barrio barrio);

    public void updateBarrio(Barrio barrio);

    public void deleteBarrio(int id);

    Barrio findBarrioById(int id);

    List<Barrio> findAllBarrios();

    // DTO

    BarrioDto findBarrioDtoById(int id);

    List<BarrioDto> findAllBarriosDto();
}
