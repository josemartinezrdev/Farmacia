package com.farmacia.laboratory.application;

import com.farmacia.laboratory.domain.entity.Laboratory;
import com.farmacia.laboratory.domain.service.LaboratoryService;

public class FindByIdLaboratoryUseCase {
    private LaboratoryService laboratoryService;

    public FindByIdLaboratoryUseCase(LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    public Laboratory execute(int id) {
        return laboratoryService.findByIdLaboratory(id);
    }

}
