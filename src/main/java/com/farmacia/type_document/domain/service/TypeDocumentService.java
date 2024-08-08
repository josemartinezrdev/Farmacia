package com.farmacia.type_document.domain.service;

import java.util.List;

import com.farmacia.type_document.domain.entity.TypeDocument;

public interface TypeDocumentService {

    public void addTypeDocument(TypeDocument typeDocument);

    public void updateTypeDocument(TypeDocument typeDocument);

    public void deleteTypeDocument(int id);

    TypeDocument findTypeDocumentById(int id);

    List<TypeDocument> findAllTypesDocuments();

}
