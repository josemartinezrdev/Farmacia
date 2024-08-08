package com.farmacia.city.infrastructure;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.farmacia.city.application.CreateCityUseCase;
import com.farmacia.city.application.DeleteCityUseCase;
import com.farmacia.city.application.FindByIdCityUseCase;
import com.farmacia.city.application.FindCityUseCase;
import com.farmacia.city.application.UpdateCityUseCase;
import com.farmacia.city.domain.entity.City;

public class CityUi {

    private CreateCityUseCase createCityUseCase;
    private UpdateCityUseCase updateCityUseCase;
    private FindCityUseCase findCityUseCase;
    private FindByIdCityUseCase findByIdCityUseCase;
    private DeleteCityUseCase deleteCityUseCase;

    public CityUi(CreateCityUseCase createCityUseCase, UpdateCityUseCase updateCityUseCase,
            FindCityUseCase findCityUseCase, FindByIdCityUseCase findByIdCityUseCase,
            DeleteCityUseCase deleteCityUseCase) {
        this.createCityUseCase = createCityUseCase;
        this.updateCityUseCase = updateCityUseCase;
        this.findCityUseCase = findCityUseCase;
        this.findByIdCityUseCase = findByIdCityUseCase;
        this.deleteCityUseCase = deleteCityUseCase;
    }

    public void showAllCities(List<City> cities) {

        String[] columns = { "ID", "Name" };

        DefaultTableModel model = new DefaultTableModel(columns, 0);

        cities.forEach(city -> {
            Object[] row = {
                    city.getIdciudad(),
                    city.getNombre() };
            model.addRow(row);
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Cities List", JOptionPane.PLAIN_MESSAGE);

    }

    public void showCityById(City city) {

        String[] columns = { "ID", "Name" };

        DefaultTableModel model = new DefaultTableModel(columns, 0);

        Object[] row = {
                city.getIdciudad(),
                city.getNombre() };
        model.addRow(row);

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Cities List", JOptionPane.PLAIN_MESSAGE);

    }

    public void addCity() {
        City city = new City();
        city.setIdciudad(JOptionPane.showInputDialog(null, "Ingrese Id"));
        city.setNombre(JOptionPane.showInputDialog(null, "Ingrese Nombre de la ciudad"));
        createCityUseCase.execute(city);
    }

    public void updateCity() {
        City city = findCityById();
        city.setNombre(JOptionPane.showInputDialog(null, "Ingrese Nombre de la ciudad"));
        updateCityUseCase.execute(city);
    }

    public void findAllCities() {
        List<City> cities = findCityUseCase.execute();
        showAllCities(cities);
    }

    public City findCityById() {
        String id = JOptionPane.showInputDialog(null, "Ingrese el ID de la ciudad");
        City city = findByIdCityUseCase.execute(id);
        showCityById(city);
        return city;
    }

    public void deleteCity() {
        City city = findCityById();
        deleteCityUseCase.execute(city.getIdciudad());
    }
}
