package com.farmacia.presentation.application;

import com.farmacia.presentation.domain.entity.Presentation;
import com.farmacia.presentation.domain.service.PresentationService;

public class UpdatePresentationUseCase {
    private PresentationService presentationService;

    public UpdatePresentationUseCase(PresentationService presentationService) {
        this.presentationService = presentationService;
    }

    public void execute(Presentation presentation) {
        presentationService.updatePresentation(presentation);
    }

}
