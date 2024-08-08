package com.farmacia.principio_activo.infrastructure;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.farmacia.principio_activo.application.CreatePrincipioActivoUseCase;
import com.farmacia.principio_activo.application.DeletePrincipioActivoUseCase;
import com.farmacia.principio_activo.application.FindAllPrincipioActivoUseCase;
import com.farmacia.principio_activo.application.FindByIdPrincipioActivoUseCase;
import com.farmacia.principio_activo.application.UpdatePrincipioActivoUseCase;
import com.farmacia.principio_activo.domain.entity.PrincipioActivo;

public class PrincipioActivoUi {

    private CreatePrincipioActivoUseCase createPrincipioActivoUseCase;
    private UpdatePrincipioActivoUseCase updatePrincipioActivoUseCase;
    private DeletePrincipioActivoUseCase deletePrincipioActivoUseCase;
    private FindByIdPrincipioActivoUseCase findByIdPrincipioActivoUseCase;
    private FindAllPrincipioActivoUseCase findAllPrincipioActivoUseCase;

    public PrincipioActivoUi(CreatePrincipioActivoUseCase createPrincipioActivoUseCase,
            UpdatePrincipioActivoUseCase updatePrincipioActivoUseCase,
            DeletePrincipioActivoUseCase deletePrincipioActivoUseCase,
            FindByIdPrincipioActivoUseCase findByIdPrincipioActivoUseCase,
            FindAllPrincipioActivoUseCase findAllPrincipioActivoUseCase) {
        this.createPrincipioActivoUseCase = createPrincipioActivoUseCase;
        this.updatePrincipioActivoUseCase = updatePrincipioActivoUseCase;
        this.deletePrincipioActivoUseCase = deletePrincipioActivoUseCase;
        this.findByIdPrincipioActivoUseCase = findByIdPrincipioActivoUseCase;
        this.findAllPrincipioActivoUseCase = findAllPrincipioActivoUseCase;
    }

    public void addPrincipioAct() {
        PrincipioActivo principioActivo = new PrincipioActivo();
        principioActivo.setNombre(JOptionPane.showInputDialog(null, "Ingrese el nombre del principio activo"));
        createPrincipioActivoUseCase.execute(principioActivo);
    }

    public void showPrincipioAct(PrincipioActivo principioActivo) {
        String[] columns = { "ID", "Nombre" };
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        Object[] row = {
                principioActivo.getIdprincipioact(),
                principioActivo.getNombre()
        };
        model.addRow(row);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);
        JOptionPane.showMessageDialog(null, panel, "Principio Activo", JOptionPane.PLAIN_MESSAGE);
    }

    public PrincipioActivo findByIdPrincipioAct() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del principio activo"));
        PrincipioActivo principioActivo = findByIdPrincipioActivoUseCase.execute(id);
        showPrincipioAct(principioActivo);
        return principioActivo;
    }

    public void updatePrincipioAct() {
        PrincipioActivo principioActivo = findByIdPrincipioAct();
        principioActivo.setNombre(JOptionPane.showInputDialog(null, "Ingrese el nombre del principio activo"));
        updatePrincipioActivoUseCase.execute(principioActivo);
    }

    public void deletePrincipioAct() {
        PrincipioActivo principioActivo = findByIdPrincipioAct();
        deletePrincipioActivoUseCase.execute(principioActivo.getIdprincipioact());
    }

    public void showAllPricipiosAct(List<PrincipioActivo> principiosActivos) {
        String[] columns = { "ID", "Nombre" };
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        principiosActivos.forEach(principioAct -> {
            Object[] row = {
                    principioAct.getIdprincipioact(),
                    principioAct.getNombre()
            };
            model.addRow(row);
        });
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);
        JOptionPane.showMessageDialog(null, panel, "Principios Activos", JOptionPane.PLAIN_MESSAGE);
    }

    public void findAllPrincipiosAct() {
        List<PrincipioActivo> principiosAct = findAllPrincipioActivoUseCase.execute();
        showAllPricipiosAct(principiosAct);
    }
}