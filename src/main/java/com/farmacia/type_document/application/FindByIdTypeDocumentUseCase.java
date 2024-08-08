package com.farmacia.type_document.application;

import com.farmacia.type_document.domain.entity.TypeDocument;
import com.farmacia.type_document.domain.service.TypeDocumentService;

public class FindByIdTypeDocumentUseCase {

    private final TypeDocumentService typeDocumentService;

    public FindByIdTypeDocumentUseCase(TypeDocumentService typeDocumentService) {
        this.typeDocumentService = typeDocumentService;
    }

    public TypeDocument execute(int idciudad) {
        TypeDocument typeDocument = typeDocumentService.findTypeDocumentById(idciudad);
        return typeDocument;
    }

}
