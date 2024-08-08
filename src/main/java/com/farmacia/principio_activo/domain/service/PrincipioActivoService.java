package com.farmacia.principio_activo.domain.service;

import java.util.List;

import com.farmacia.principio_activo.domain.entity.PrincipioActivo;

public interface PrincipioActivoService {
    public void addPrincipioAct(PrincipioActivo principioActivo);

    public void updatePrincipioAct(PrincipioActivo principioActivo);

    public void deletePrincipioAct(int id);

    public PrincipioActivo findByIdPrincipioAct(int id);

    public List<PrincipioActivo> findAllPrincipiosActivos();
}
