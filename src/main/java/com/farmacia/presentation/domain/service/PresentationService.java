package com.farmacia.presentation.domain.service;

import java.util.List;

import com.farmacia.presentation.domain.entity.Presentation;

public interface PresentationService {

    public void addPresentation(Presentation presentation);

    public void updatePresentation(Presentation presentation);

    public void deletePresentation(int id);

    public Presentation findByIdPresentation(int id);

    public List<Presentation> findAllPresentations();

}
