package com.farmacia.via_administracion.infrastructure;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.farmacia.via_administracion.application.CreateViaAdminisUseCase;
import com.farmacia.via_administracion.application.DeleteViaAdminisUseCase;
import com.farmacia.via_administracion.application.UpdateViaAminisUseCase;
import com.farmacia.via_administracion.application.FindByIdViaAdminisUseCase;
import com.farmacia.via_administracion.application.FindViaAdminisUseCase;
import com.farmacia.via_administracion.domain.entity.ViaAdminis;

public class ViaAdminisUi {

    private CreateViaAdminisUseCase createViaAdminisUseCase;
    private UpdateViaAminisUseCase updateViaAminisUseCase;
    private DeleteViaAdminisUseCase deleteViaAdminisUseCase;
    private FindByIdViaAdminisUseCase findByIdViaAdminisUseCase;
    private FindViaAdminisUseCase findViaAdminisUseCase;

    public ViaAdminisUi(CreateViaAdminisUseCase createViaAdminisUseCase, UpdateViaAminisUseCase updateViaAminisUseCase,
            DeleteViaAdminisUseCase deleteViaAdminisUseCase, FindByIdViaAdminisUseCase findByIdViaAdminisUseCase,
            FindViaAdminisUseCase findViaAdminisUseCase) {
        this.createViaAdminisUseCase = createViaAdminisUseCase;
        this.updateViaAminisUseCase = updateViaAminisUseCase;
        this.deleteViaAdminisUseCase = deleteViaAdminisUseCase;
        this.findByIdViaAdminisUseCase = findByIdViaAdminisUseCase;
        this.findViaAdminisUseCase = findViaAdminisUseCase;
    }

    public void addViaAdminis() {
        ViaAdminis viaAdminis = new ViaAdminis();
        viaAdminis.setNombre(JOptionPane.showInputDialog(null, "Ingresa el nombre de la via de administracion"));
        createViaAdminisUseCase.execute(viaAdminis);
    }

    public void showViaAdminisById(ViaAdminis viaAdminis) {

        String[] columns = { "ID", "Nombre" };
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        Object[] row = {
                viaAdminis.getIdviaadmin(),
                viaAdminis.getNombre() };
        model.addRow(row);

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);
        JOptionPane.showMessageDialog(null, panel, "Vias Adminis List", JOptionPane.PLAIN_MESSAGE);
    }

    public ViaAdminis findViaAdminisById() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el ID de la via de administracion"));
        ViaAdminis viaAdminis = findByIdViaAdminisUseCase.execute(id);
        showViaAdminisById(viaAdminis);
        return viaAdminis;
    }

    public void updateViaAdminis() {
        ViaAdminis viaAdminis = findViaAdminisById();
        viaAdminis.setNombre(JOptionPane.showInputDialog(null, "Ingrese el nombre de la via de administracion"));
        updateViaAminisUseCase.execute(viaAdminis);
    }

    public void deleteViaAdminis() {
        ViaAdminis viaAdminis = findViaAdminisById();
        deleteViaAdminisUseCase.execute(viaAdminis.getIdviaadmin());
    }

    public void showAllViasAdminis(List<ViaAdminis> viasAdminis) {
        String[] columns = { "ID", "Nombre" };
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        viasAdminis.forEach(viaAdminis -> {
            Object[] row = {
                    viaAdminis.getIdviaadmin(),
                    viaAdminis.getNombre() };
            model.addRow(row);
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);
        JOptionPane.showMessageDialog(null, panel, "Vias Adminis List", JOptionPane.PLAIN_MESSAGE);
    }

    public void findAllViasAdminis() {
        List<ViaAdminis> viasAdminis = findViaAdminisUseCase.execute();
        showAllViasAdminis(viasAdminis);
    }
}
