package com.farmacia.laboratory.application;

import java.util.List;

import com.farmacia.laboratory.domain.entity.Laboratory;
import com.farmacia.laboratory.domain.service.LaboratoryService;

public class FindAllLaboratoryUseCase {
    private LaboratoryService laboratoryService;

    public FindAllLaboratoryUseCase(LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    public List<Laboratory> execute() {
        return laboratoryService.findAllLaboratories();
    }

}
