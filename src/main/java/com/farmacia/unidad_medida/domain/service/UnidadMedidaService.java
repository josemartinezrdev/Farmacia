package com.farmacia.unidad_medida.domain.service;

import java.util.List;

import com.farmacia.unidad_medida.domain.entity.UnidadMedida;

public interface UnidadMedidaService {
    public void addUnidadMedida(UnidadMedida unidadMedida);

    public void updateUnidadMedida(UnidadMedida unidadMedida);

    public void deleteUnidadMedida(int id);

    public UnidadMedida findByIdUnidadMedida(int id);

    public List<UnidadMedida> findAllUnidadesMedidas();
}
