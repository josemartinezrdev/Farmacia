package com.farmacia.presentation.application;

import com.farmacia.presentation.domain.entity.Presentation;
import com.farmacia.presentation.domain.service.PresentationService;

public class FindByIdPresentationUseCase {
    private PresentationService presentationService;

    public FindByIdPresentationUseCase(PresentationService presentationService) {
        this.presentationService = presentationService;
    }

    public Presentation execute(int id) {
        return presentationService.findByIdPresentation(id);
    }

}
