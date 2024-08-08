package com.farmacia.laboratory.application;

import com.farmacia.laboratory.domain.entity.Laboratory;
import com.farmacia.laboratory.domain.service.LaboratoryService;

public class CreateLaboratoryUseCase {

    private LaboratoryService laboratoryService;

    public CreateLaboratoryUseCase(LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    public void execute(Laboratory laboratory) {
        laboratoryService.addLaboratory(laboratory);
    }

}
