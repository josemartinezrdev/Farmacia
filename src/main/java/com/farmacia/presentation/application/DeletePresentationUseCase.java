package com.farmacia.presentation.application;

import com.farmacia.presentation.domain.service.PresentationService;

public class DeletePresentationUseCase {
    private PresentationService presentationService;

    public DeletePresentationUseCase(PresentationService presentationService) {
        this.presentationService = presentationService;
    }

    public void execute(int id) {
        presentationService.deletePresentation(id);
    }

}
