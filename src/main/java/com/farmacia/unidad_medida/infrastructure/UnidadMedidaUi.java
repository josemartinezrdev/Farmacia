package com.farmacia.unidad_medida.infrastructure;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.farmacia.unidad_medida.application.CreateUnidadMedidaUseCase;
import com.farmacia.unidad_medida.application.DeleteUnidadMedidaUseCase;
import com.farmacia.unidad_medida.application.FindAllUnidadMedidaUseCase;
import com.farmacia.unidad_medida.application.FindByIdUnidadMedidaUseCase;
import com.farmacia.unidad_medida.application.UpdateUnidadMedidaUseCase;
import com.farmacia.unidad_medida.domain.entity.UnidadMedida;

public class UnidadMedidaUi {
    private CreateUnidadMedidaUseCase createUnidadMedidaUseCase;
    private UpdateUnidadMedidaUseCase updateUnidadMedidaUseCase;
    private DeleteUnidadMedidaUseCase deleteUnidadMedidaUseCase;
    private FindByIdUnidadMedidaUseCase findByIdUnidadMedidaUseCase;
    private FindAllUnidadMedidaUseCase findAllUnidadMedidaUseCase;

    public UnidadMedidaUi(CreateUnidadMedidaUseCase createUnidadMedidaUseCase,
            UpdateUnidadMedidaUseCase updateUnidadMedidaUseCase, DeleteUnidadMedidaUseCase deleteUnidadMedidaUseCase,
            FindByIdUnidadMedidaUseCase findByIdUnidadMedidaUseCase,
            FindAllUnidadMedidaUseCase findAllUnidadMedidaUseCase) {
        this.createUnidadMedidaUseCase = createUnidadMedidaUseCase;
        this.updateUnidadMedidaUseCase = updateUnidadMedidaUseCase;
        this.deleteUnidadMedidaUseCase = deleteUnidadMedidaUseCase;
        this.findByIdUnidadMedidaUseCase = findByIdUnidadMedidaUseCase;
        this.findAllUnidadMedidaUseCase = findAllUnidadMedidaUseCase;
    }

    public void addUnidadMedida() {
        UnidadMedida unidadMedida = new UnidadMedida();
        unidadMedida.setNombre(JOptionPane.showInputDialog(null, "Ingrese el nombre de la unidad de medida"));
        createUnidadMedidaUseCase.execute(unidadMedida);
    }

    public void showUnidadMedida(UnidadMedida unidadMedida) {
        String[] columns = { "ID", "Nombre" };
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        Object[] row = {
                unidadMedida.getIdunidadmedida(),
                unidadMedida.getNombre() };
        model.addRow(row);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);
        JOptionPane.showMessageDialog(null, panel, "Unidad De Medida", JOptionPane.PLAIN_MESSAGE);
    }

    public UnidadMedida findByIdUnidadMedida() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el ID de la unidad de medida"));
        UnidadMedida unidadMedida = findByIdUnidadMedidaUseCase.execute(id);
        showUnidadMedida(unidadMedida);
        return unidadMedida;
    }

    public void updateUnidadMedida() {
        UnidadMedida unidadMedida = findByIdUnidadMedida();
        unidadMedida.setNombre(JOptionPane.showInputDialog(null, "Ingrese el nombre de la unidad de medida"));
        updateUnidadMedidaUseCase.execute(unidadMedida);
    }

    public void deleteUnidadMedida() {
        UnidadMedida unidadMedida = findByIdUnidadMedida();
        deleteUnidadMedidaUseCase.execute(unidadMedida.getIdunidadmedida());
    }

    public void showAllUnidadesMedidas(List<UnidadMedida> unidadesMedidas) {
        String[] columns = { "ID", "Nombre" };
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        unidadesMedidas.forEach(unidadMedida -> {
            Object[] row = {
                    unidadMedida.getIdunidadmedida(),
                    unidadMedida.getNombre() };
            model.addRow(row);
        });
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);
        JOptionPane.showMessageDialog(null, panel, "Unidades De Medida", JOptionPane.PLAIN_MESSAGE);
    }

    public void findAllUnidadesMedidas() {
        List<UnidadMedida> unidadesMedidas = findAllUnidadMedidaUseCase.execute();
        showAllUnidadesMedidas(unidadesMedidas);
    }
}
