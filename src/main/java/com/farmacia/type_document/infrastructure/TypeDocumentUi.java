package com.farmacia.type_document.infrastructure;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.farmacia.type_document.application.CreateTypeDocumentUseCase;
import com.farmacia.type_document.application.DeleteTypeDocumentUseCase;
import com.farmacia.type_document.application.FindByIdTypeDocumentUseCase;
import com.farmacia.type_document.application.FindTypeDocumentUseCase;
import com.farmacia.type_document.application.UpdateTypeDocumentUseCase;
import com.farmacia.type_document.domain.entity.TypeDocument;

public class TypeDocumentUi {

    private CreateTypeDocumentUseCase createTypeDocumentUseCase;
    private UpdateTypeDocumentUseCase updateTypeDocumentUseCase;
    private FindTypeDocumentUseCase findTypeDocumentUseCase;
    private FindByIdTypeDocumentUseCase findByIdTypeDocumentUseCase;
    private DeleteTypeDocumentUseCase deleteTypeDocumentUseCase;

    public TypeDocumentUi(CreateTypeDocumentUseCase createTypeDocumentUseCase,
            UpdateTypeDocumentUseCase updateTypeDocumentUseCase, FindTypeDocumentUseCase findTypeDocumentUseCase,
            FindByIdTypeDocumentUseCase findByIdTypeDocumentUseCase,
            DeleteTypeDocumentUseCase deleteTypeDocumentUseCase) {
        this.createTypeDocumentUseCase = createTypeDocumentUseCase;
        this.updateTypeDocumentUseCase = updateTypeDocumentUseCase;
        this.findTypeDocumentUseCase = findTypeDocumentUseCase;
        this.findByIdTypeDocumentUseCase = findByIdTypeDocumentUseCase;
        this.deleteTypeDocumentUseCase = deleteTypeDocumentUseCase;
    }

    public void addTypeDocument() {
        TypeDocument typeDocument = new TypeDocument();
        typeDocument.setTipo(JOptionPane.showInputDialog(null, "Ingrese Nombre del tipo de documento"));
        createTypeDocumentUseCase.execute(typeDocument);
    }

    public void showAllTypesDocuments(List<TypeDocument> typesDocs) {

        String[] columns = { "ID", "Name" };
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        typesDocs.forEach(typeDoc -> {
            Object[] row = {
                    typeDoc.getIdtipo(),
                    typeDoc.getTipo() };
            model.addRow(row);
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);
        JOptionPane.showMessageDialog(null, panel, "Types List", JOptionPane.PLAIN_MESSAGE);

    }

    public void showTypeDocumentById(TypeDocument typeDocument) {

        String[] columns = { "ID", "Name" };

        DefaultTableModel model = new DefaultTableModel(columns, 0);

        Object[] row = {
                typeDocument.getIdtipo(),
                typeDocument.getTipo() };
        model.addRow(row);

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Types List", JOptionPane.PLAIN_MESSAGE);

    }

    public void updateTypeDocument() {
        TypeDocument typeDocument = findTypeDocumentById();
        typeDocument.setTipo(JOptionPane.showInputDialog(null, "Ingrese Nombre del tipo de documento"));
        updateTypeDocumentUseCase.execute(typeDocument);
    }

    public void findAllTypesDocuments() {
        List<TypeDocument> typesDocuments = findTypeDocumentUseCase.execute();
        showAllTypesDocuments(typesDocuments);
    }

    public TypeDocument findTypeDocumentById() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del tipo de documento"));
        TypeDocument typeDocument = findByIdTypeDocumentUseCase.execute(id);
        showTypeDocumentById(typeDocument);
        return typeDocument;
    }

    public void deleteTypeDocument() {
        TypeDocument typeDocument = findTypeDocumentById();
        deleteTypeDocumentUseCase.execute(typeDocument.getIdtipo());
    }
}
