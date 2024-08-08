package com.farmacia.presentation.application;

import java.util.List;

import com.farmacia.presentation.domain.entity.Presentation;
import com.farmacia.presentation.domain.service.PresentationService;

public class FindAllPresentationsUseCase {
    private PresentationService presentationService;

    public FindAllPresentationsUseCase(PresentationService presentationService) {
        this.presentationService = presentationService;
    }

    public List<Presentation> execute() {
        return presentationService.findAllPresentations();
    }
}
