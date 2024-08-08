package com.farmacia.laboratory.infrastructure;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.farmacia.laboratory.application.CreateLaboratoryUseCase;
import com.farmacia.laboratory.application.DeleteLaboratoryUseCase;
import com.farmacia.laboratory.application.FindAllLaboratoryUseCase;
import com.farmacia.laboratory.application.FindByIdLaboratoryUseCase;
import com.farmacia.laboratory.application.UpdateLaboratoryUseCase;
import com.farmacia.laboratory.domain.entity.Laboratory;

public class LaboratoryUi {
    private CreateLaboratoryUseCase createLaboratoryUseCase;
    private UpdateLaboratoryUseCase updateLaboratoryUseCase;
    private DeleteLaboratoryUseCase deleteLaboratoryUseCase;
    private FindAllLaboratoryUseCase findAllLaboratoryUseCase;
    private FindByIdLaboratoryUseCase findByIdLaboratoryUseCase;

    public LaboratoryUi(CreateLaboratoryUseCase createLaboratoryUseCase,
            UpdateLaboratoryUseCase updateLaboratoryUseCase, DeleteLaboratoryUseCase deleteLaboratoryUseCase,
            FindAllLaboratoryUseCase findAllLaboratoryUseCase, FindByIdLaboratoryUseCase findByIdLaboratoryUseCase) {
        this.createLaboratoryUseCase = createLaboratoryUseCase;
        this.updateLaboratoryUseCase = updateLaboratoryUseCase;
        this.deleteLaboratoryUseCase = deleteLaboratoryUseCase;
        this.findAllLaboratoryUseCase = findAllLaboratoryUseCase;
        this.findByIdLaboratoryUseCase = findByIdLaboratoryUseCase;
    }

    public void addLaboratory() {
        Laboratory laboratory = new Laboratory();
        laboratory.setNombre(JOptionPane.showInputDialog(null, "Ingrese el nombre del laboratorio"));
        createLaboratoryUseCase.execute(laboratory);
    }

    public void showLaboratory(Laboratory laboratory) {
        String[] columns = { "ID", "Nombre" };
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        Object[] row = {
                laboratory.getIdlaboratorio(),
                laboratory.getNombre() };
        model.addRow(row);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);
        JOptionPane.showMessageDialog(null, panel, "Laboratory", JOptionPane.PLAIN_MESSAGE);
    }

    public Laboratory findByIdLaboratory() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del laboratorio"));
        Laboratory laboratory = findByIdLaboratoryUseCase.execute(id);
        showLaboratory(laboratory);
        return laboratory;
    }

    public void updateLaboratory() {
        Laboratory laboratory = findByIdLaboratory();
        laboratory.setNombre(JOptionPane.showInputDialog(null, "Ingrese el nombre del laboratorio"));
        updateLaboratoryUseCase.execute(laboratory);
    }

    public void deleteLaboratory() {
        Laboratory laboratory = findByIdLaboratory();
        deleteLaboratoryUseCase.execute(laboratory.getIdlaboratorio());
    }

    public void showAllLaboratories(List<Laboratory> laboratories) {
        String[] columns = { "ID", "Nombre" };
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        laboratories.forEach(laboratory -> {
            Object[] row = {
                    laboratory.getIdlaboratorio(),
                    laboratory.getNombre()
            };
            model.addRow(row);
        });
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);
        JOptionPane.showMessageDialog(null, panel, "Laboratories List", JOptionPane.PLAIN_MESSAGE);
    }

    public void findAllLaboratories() {
        List<Laboratory> laboratories = findAllLaboratoryUseCase.execute();
        showAllLaboratories(laboratories);
    }
}
