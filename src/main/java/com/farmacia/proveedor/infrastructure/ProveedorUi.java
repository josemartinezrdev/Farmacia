package com.farmacia.proveedor.infrastructure;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.farmacia.proveedor.application.CreateProveedorUseCase;
import com.farmacia.proveedor.application.DeleteProveedorUseCase;
import com.farmacia.proveedor.application.FindAllProveedorDtoUseCase;
import com.farmacia.proveedor.application.FindAllProveedorUseCase;
import com.farmacia.proveedor.application.FindByIdProveedorDtoUseCase;
import com.farmacia.proveedor.application.FindByIdProveedorUseCase;
import com.farmacia.proveedor.application.UpdateProveedorUseCase;
import com.farmacia.proveedor.domain.entity.Proveedor;
import com.farmacia.proveedor.domain.entity.ProveedorDto;

public class ProveedorUi {
    private CreateProveedorUseCase createProveedorUseCase;
    private UpdateProveedorUseCase updateProveedorUseCase;
    private DeleteProveedorUseCase deleteProveedorUseCase;
    private FindByIdProveedorUseCase findByIdProveedorUseCase;
    private FindByIdProveedorDtoUseCase findByIdProveedorDtoUseCase;
    private FindAllProveedorUseCase findAllProveedorUseCase;
    private FindAllProveedorDtoUseCase findAllProveedorDtoUseCase;

    public ProveedorUi(CreateProveedorUseCase createProveedorUseCase, UpdateProveedorUseCase updateProveedorUseCase,
            DeleteProveedorUseCase deleteProveedorUseCase, FindByIdProveedorUseCase findByIdProveedorUseCase,
            FindByIdProveedorDtoUseCase findByIdProveedorDtoUseCase, FindAllProveedorUseCase findAllProveedorUseCase,
            FindAllProveedorDtoUseCase findAllProveedorDtoUseCase) {
        this.createProveedorUseCase = createProveedorUseCase;
        this.updateProveedorUseCase = updateProveedorUseCase;
        this.deleteProveedorUseCase = deleteProveedorUseCase;
        this.findByIdProveedorUseCase = findByIdProveedorUseCase;
        this.findByIdProveedorDtoUseCase = findByIdProveedorDtoUseCase;
        this.findAllProveedorUseCase = findAllProveedorUseCase;
        this.findAllProveedorDtoUseCase = findAllProveedorDtoUseCase;
    }

    public void addProveedor() {
        Proveedor proveedor = new Proveedor();
        proveedor.setIdproveedor(JOptionPane.showInputDialog("Ingrese el ID del proveedor"));
        proveedor.setNombre(JOptionPane.showInputDialog("Ingrese el nombre del proveedor"));
        proveedor.setEmail(JOptionPane.showInputDialog("Ingrese el email del proveedor"));
        proveedor.setTelefono(JOptionPane.showInputDialog("Ingrese el telefono del proveedor"));
        proveedor.setIdtipo(
                Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del tipo de documento del proveedor")));

        createProveedorUseCase.execute(proveedor);
    }

    public void showProveedor(Proveedor proveedor) {
        String[] columns = { "ID", "Nombre", "Email", "Telefono", "ID Tipo" };
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        Object[] row = {
                proveedor.getIdproveedor(),
                proveedor.getNombre(),
                proveedor.getEmail(),
                proveedor.getTelefono(),
                proveedor.getIdtipo() };
        model.addRow(row);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);
        JOptionPane.showMessageDialog(null, panel, "Proveedor", JOptionPane.PLAIN_MESSAGE);
    }

    public void showProveedorDto(ProveedorDto proveedorDto) {
        String[] columns = { "ID", "Nombre", "Email", "Telefono", "Tipo" };
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        Object[] row = {
                proveedorDto.getIdproveedor(),
                proveedorDto.getNombre(),
                proveedorDto.getEmail(),
                proveedorDto.getTelefono(),
                proveedorDto.getNombreTipo() };
        model.addRow(row);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);
        JOptionPane.showMessageDialog(null, panel, "Proveedor Dto", JOptionPane.PLAIN_MESSAGE);
    }

    public Proveedor findByIdProveedor() {
        String id = JOptionPane.showInputDialog(null, "Ingrese el ID del proveedor");
        Proveedor proveedor = findByIdProveedorUseCase.execute(id);
        showProveedor(proveedor);
        return proveedor;
    }

    public void findByIdProveedorDto() {
        String id = JOptionPane.showInputDialog(null, "Ingrese el ID del proveedor");
        ProveedorDto proveedorDto = findByIdProveedorDtoUseCase.execute(id);
        showProveedorDto(proveedorDto);
    }

    public void updateProveedor() {
        Proveedor proveedor = findByIdProveedor();
        proveedor.setNombre(JOptionPane.showInputDialog("Ingrese el nombre del proveedor"));
        proveedor.setEmail(JOptionPane.showInputDialog("Ingrese el email del proveedor"));
        proveedor.setTelefono(JOptionPane.showInputDialog("Ingrese el telefono del proveedor"));
        proveedor.setIdtipo(
                Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del tipo de documento del proveedor")));
        updateProveedorUseCase.execute(proveedor);
    }

    public void deleteProveedor() {
        Proveedor proveedor = findByIdProveedor();
        deleteProveedorUseCase.execute(proveedor.getIdproveedor());
    }

    public void showAllProveedores(List<Proveedor> proveedores) {
        String[] columns = { "ID", "Nombre", "Email", "Telefono", "ID Tipo" };
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        proveedores.forEach(proveedor -> {
            Object[] row = {
                    proveedor.getIdproveedor(),
                    proveedor.getNombre(),
                    proveedor.getEmail(),
                    proveedor.getTelefono(),
                    proveedor.getIdtipo() };
            model.addRow(row);
        });
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);
        JOptionPane.showMessageDialog(null, panel, "Proveedores", JOptionPane.PLAIN_MESSAGE);
    }

    public void showAllProveedoresDto(List<ProveedorDto> proveedoresDto) {
        String[] columns = { "ID", "Nombre", "Email", "Telefono", "Tipo" };
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        proveedoresDto.forEach(proveedorDto -> {
            Object[] row = {
                    proveedorDto.getIdproveedor(),
                    proveedorDto.getNombre(),
                    proveedorDto.getEmail(),
                    proveedorDto.getTelefono(),
                    proveedorDto.getNombreTipo() };
            model.addRow(row);
        });
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);
        JOptionPane.showMessageDialog(null, panel, "Proveedores Dto", JOptionPane.PLAIN_MESSAGE);
    }

    public void findAllProveedoresDto() {
        List<ProveedorDto> proveedores = findAllProveedorDtoUseCase.execute();
        showAllProveedoresDto(proveedores);
    }

    public void findAllProveedores() {
        List<Proveedor> proveedores = findAllProveedorUseCase.execute();
        showAllProveedores(proveedores);
    }

}
