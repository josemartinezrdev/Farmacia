package com.farmacia.type_document.application;

import com.farmacia.type_document.domain.entity.TypeDocument;
import com.farmacia.type_document.domain.service.TypeDocumentService;

public class CreateTypeDocumentUseCase {

    private final TypeDocumentService typeDocumentService;

    public CreateTypeDocumentUseCase(TypeDocumentService typeDocumentService) {
        this.typeDocumentService = typeDocumentService;
    }

    public void execute(TypeDocument typeDocument) {
        typeDocumentService.addTypeDocument(typeDocument);
    }

}
