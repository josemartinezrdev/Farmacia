package com.farmacia.type_document.application;

import com.farmacia.type_document.domain.service.TypeDocumentService;

public class DeleteTypeDocumentUseCase {
    private final TypeDocumentService typeDocumentService;

    public DeleteTypeDocumentUseCase(TypeDocumentService typeDocumentService) {
        this.typeDocumentService = typeDocumentService;
    }

    public void execute(int id) {
        typeDocumentService.deleteTypeDocument(id);
    }
}
