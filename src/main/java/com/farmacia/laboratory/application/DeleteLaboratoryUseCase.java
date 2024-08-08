package com.farmacia.laboratory.application;

import com.farmacia.laboratory.domain.service.LaboratoryService;

public class DeleteLaboratoryUseCase {
    private LaboratoryService laboratoryService;

    public DeleteLaboratoryUseCase(LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    public void execute(int id) {
        laboratoryService.deleteLaboratory(id);
    }

}
