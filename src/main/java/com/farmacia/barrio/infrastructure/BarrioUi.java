package com.farmacia.barrio.infrastructure;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.farmacia.barrio.application.CreateBarrioUseCase;
import com.farmacia.barrio.application.DeleteBarrioUseCase;
import com.farmacia.barrio.application.FindBarrioDtoUseCase;
import com.farmacia.barrio.application.FindBarrioUseCase;
import com.farmacia.barrio.application.FindByIdBarrioDtoUseCase;
import com.farmacia.barrio.application.FindByIdBarrioUseCase;
import com.farmacia.barrio.application.UpdateBarrioUseCase;
import com.farmacia.barrio.domain.entity.Barrio;
import com.farmacia.barrio.domain.entity.BarrioDto;

public class BarrioUi {

    private CreateBarrioUseCase createBarrioUseCase;
    private UpdateBarrioUseCase updateBarrioUseCase;
    private FindBarrioUseCase findBarrioUseCase;
    private FindByIdBarrioUseCase findByIdBarrioUseCase;
    private DeleteBarrioUseCase deleteBarrioUseCase;
    private FindBarrioDtoUseCase findBarrioDtoUseCase;
    private FindByIdBarrioDtoUseCase findByIdBarrioDtoUseCase;

    public BarrioUi(CreateBarrioUseCase createBarrioUseCase, UpdateBarrioUseCase updateBarrioUseCase,
            FindBarrioUseCase findBarrioUseCase, FindByIdBarrioUseCase findByIdBarrioUseCase,
            DeleteBarrioUseCase deleteBarrioUseCase, FindBarrioDtoUseCase findBarrioDtoUseCase,
            FindByIdBarrioDtoUseCase findByIdBarrioDtoUseCase) {
        this.createBarrioUseCase = createBarrioUseCase;
        this.updateBarrioUseCase = updateBarrioUseCase;
        this.findBarrioUseCase = findBarrioUseCase;
        this.findByIdBarrioUseCase = findByIdBarrioUseCase;
        this.deleteBarrioUseCase = deleteBarrioUseCase;
        this.findBarrioDtoUseCase = findBarrioDtoUseCase;
        this.findByIdBarrioDtoUseCase = findByIdBarrioDtoUseCase;
    }

    public void showAllBarrios(List<Barrio> barrios) {

        String[] columns = { "ID", "Name", "Id Ciudad" };

        DefaultTableModel model = new DefaultTableModel(columns, 0);

        barrios.forEach(barrio -> {
            Object[] row = {
                    barrio.getIdbarrio(),
                    barrio.getNombre(),
                    barrio.getIdciudad()
            };
            model.addRow(row);
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Barrios List", JOptionPane.PLAIN_MESSAGE);

    }

    public void showBarrioById(Barrio barrio) {

        String[] columns = { "ID", "Name", "Id Ciudad" };

        DefaultTableModel model = new DefaultTableModel(columns, 0);

        Object[] row = {
                barrio.getIdbarrio(),
                barrio.getNombre(),
                barrio.getIdciudad()
        };
        model.addRow(row);

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Barrios List", JOptionPane.PLAIN_MESSAGE);

    }

    public void showAllBarriosDto(List<BarrioDto> barrios) {
        String[] columns = { "ID", "Nombre", "ID ciudad", "Nombre ciudad" };

        DefaultTableModel model = new DefaultTableModel(columns, 0);

        barrios.forEach(barrio -> {
            Object[] row = {
                    barrio.getIdbarrio(),
                    barrio.getNombre(),
                    barrio.getIdciudad(),
                    barrio.getNombreCity()
            };
            model.addRow(row);
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Barrios List", JOptionPane.PLAIN_MESSAGE);
    }

    public void showBarrioDtoById(BarrioDto barrioDto) {
        String[] columns = { "ID", "Nombre", "ID Ciudad", "Nombre ciudad" };

        DefaultTableModel model = new DefaultTableModel(columns, 0);

        Object[] row = {
                barrioDto.getIdbarrio(),
                barrioDto.getNombre(),
                barrioDto.getIdciudad(),
                barrioDto.getNombreCity()
        };
        model.addRow(row);

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Barrios List", JOptionPane.PLAIN_MESSAGE);
    }

    public void addBarrio() {
        Barrio barrio = new Barrio();
        barrio.setNombre(JOptionPane.showInputDialog(null, "Ingrese el nombre del barrio"));
        barrio.setIdciudad(JOptionPane.showInputDialog(null, "Ingresa el id de la ciudad"));
        createBarrioUseCase.execute(barrio);
    }

    public void updateBarrio() {
        Barrio barrio = findBarrioById();
        barrio.setNombre(JOptionPane.showInputDialog(null, "Ingrese Nombre del barrio"));
        barrio.setIdciudad(JOptionPane.showInputDialog(null, "Ingrese el ID de la ciudad"));
        updateBarrioUseCase.execute(barrio);
    }

    public void findAllBarrios() {
        List<Barrio> barrios = findBarrioUseCase.execute();
        showAllBarrios(barrios);
    }

    public Barrio findBarrioById() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del barrio"));
        Barrio barrio = findByIdBarrioUseCase.execute(id);
        showBarrioById(barrio);
        return barrio;
    }

    public void deleteBarrio() {
        Barrio barrio = findBarrioById();
        deleteBarrioUseCase.execute(barrio.getIdbarrio());
    }

    public void findAllBarriosDto() {
        List<BarrioDto> barrioDtos = findBarrioDtoUseCase.execute();
        showAllBarriosDto(barrioDtos);
    }

    public void findBarrioDtoById() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del barrio"));
        BarrioDto barrioDto = findByIdBarrioDtoUseCase.execute(id);
        showBarrioDtoById(barrioDto);
    }
}
