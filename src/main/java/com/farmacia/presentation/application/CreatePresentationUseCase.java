package com.farmacia.presentation.application;

import com.farmacia.presentation.domain.entity.Presentation;
import com.farmacia.presentation.domain.service.PresentationService;

public class CreatePresentationUseCase {

    private PresentationService presentationService;

    public CreatePresentationUseCase(PresentationService presentationService) {
        this.presentationService = presentationService;
    }

    public void execute(Presentation presentation) {
        presentationService.addPresentation(presentation);
    }

}
