package com.farmacia.laboratory.domain.service;

import java.util.List;

import com.farmacia.laboratory.domain.entity.Laboratory;

public interface LaboratoryService {
    public void addLaboratory(Laboratory laboratory);

    public void updateLaboratory(Laboratory laboratory);

    public void deleteLaboratory(int id);

    public Laboratory findByIdLaboratory(int id);

    public List<Laboratory> findAllLaboratories();
}
