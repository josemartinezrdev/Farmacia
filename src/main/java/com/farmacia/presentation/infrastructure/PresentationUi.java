package com.farmacia.presentation.infrastructure;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.farmacia.presentation.application.CreatePresentationUseCase;
import com.farmacia.presentation.application.DeletePresentationUseCase;
import com.farmacia.presentation.application.FindAllPresentationsUseCase;
import com.farmacia.presentation.application.FindByIdPresentationUseCase;
import com.farmacia.presentation.application.UpdatePresentationUseCase;
import com.farmacia.presentation.domain.entity.Presentation;

public class PresentationUi {
    private CreatePresentationUseCase createPresentationUseCase;
    private UpdatePresentationUseCase updatePresentationUseCase;
    private DeletePresentationUseCase deletePresentationUseCase;
    private FindByIdPresentationUseCase findByIdPresentationUseCase;
    private FindAllPresentationsUseCase findAllPresentationsUseCase;

    public PresentationUi(CreatePresentationUseCase createPresentationUseCase,
            UpdatePresentationUseCase updatePresentationUseCase, DeletePresentationUseCase deletePresentationUseCase,
            FindByIdPresentationUseCase findByIdPresentationUseCase,
            FindAllPresentationsUseCase findAllPresentationsUseCase) {
        this.createPresentationUseCase = createPresentationUseCase;
        this.updatePresentationUseCase = updatePresentationUseCase;
        this.deletePresentationUseCase = deletePresentationUseCase;
        this.findByIdPresentationUseCase = findByIdPresentationUseCase;
        this.findAllPresentationsUseCase = findAllPresentationsUseCase;
    }

    public void addPresentation() {
        Presentation presentation = new Presentation();
        presentation.setNombre(JOptionPane.showInputDialog(null, "Ingresa el nombre de la presentacion"));
        createPresentationUseCase.execute(presentation);
    }

    public void showPresentation(Presentation presentation) {
        String[] columns = { "ID", "Nombre" };
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        Object[] row = {
                presentation.getIdpresentacion(),
                presentation.getNombre()
        };
        model.addRow(row);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);
        JOptionPane.showMessageDialog(null, panel, "Presentation", JOptionPane.PLAIN_MESSAGE);
    }

    public Presentation findByIdPresentation() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID de la presentacion"));
        Presentation presentation = findByIdPresentationUseCase.execute(id);
        showPresentation(presentation);
        return presentation;
    }

    public void updatePresentation() {
        Presentation presentation = findByIdPresentation();
        presentation.setNombre(JOptionPane.showInputDialog(null, "Ingrese el nombre de la presentación"));
        updatePresentationUseCase.execute(presentation);
    }

    public void deletePresentation() {
        Presentation presentation = findByIdPresentation();
        deletePresentationUseCase.execute(presentation.getIdpresentacion());
    }

    public void showAllPresentations(List<Presentation> presentations) {
        String[] columns = { "ID", "Nombre" };
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        presentations.forEach(presentation -> {
            Object[] row = {
                    presentation.getIdpresentacion(),
                    presentation.getNombre() };
            model.addRow(row);
        });
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);
        JOptionPane.showMessageDialog(null, panel, "Presentations List", JOptionPane.PLAIN_MESSAGE);
    }

    public void findAllPresentations() {
        List<Presentation> presentations = findAllPresentationsUseCase.execute();
        showAllPresentations(presentations);
    }

}
