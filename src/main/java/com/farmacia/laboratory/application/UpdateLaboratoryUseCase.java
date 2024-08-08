package com.farmacia.laboratory.application;

import com.farmacia.laboratory.domain.entity.Laboratory;
import com.farmacia.laboratory.domain.service.LaboratoryService;

public class UpdateLaboratoryUseCase {

    private LaboratoryService laboratoryService;

    public UpdateLaboratoryUseCase(LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    public void execute(Laboratory laboratory) {
        laboratoryService.updateLaboratory(laboratory);
    }

}
