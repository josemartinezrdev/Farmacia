package com.farmacia.type_document.application;

import java.util.List;

import com.farmacia.type_document.domain.entity.TypeDocument;
import com.farmacia.type_document.domain.service.TypeDocumentService;

public class FindTypeDocumentUseCase {

    private final TypeDocumentService typeDocumentService;

    public FindTypeDocumentUseCase(TypeDocumentService typeDocumentService) {
        this.typeDocumentService = typeDocumentService;
    }

    public List<TypeDocument> execute() {
        List<TypeDocument> typesDocuments = typeDocumentService.findAllTypesDocuments();
        return typesDocuments;
    }

}
