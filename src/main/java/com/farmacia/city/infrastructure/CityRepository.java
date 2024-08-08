package com.farmacia.city.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.farmacia.city.domain.entity.City;
import com.farmacia.city.domain.service.CityService;

public class CityRepository implements CityService {

    private Connection connection;

    public CityRepository() {
        try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("db.properties"));
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");

            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addCity(City city) {
        try {
            String query = "INSERT INTO ciudades (idciudad, nombre) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, city.getIdciudad());
            ps.setString(2, city.getNombre());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCity(City city) {
        try {
            String query = "UPDATE ciudades SET nombre = ? WHERE idciudad = ?";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, city.getNombre());
            ps.setString(2, city.getIdciudad());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCity(String id) {
        try {

            String query = "DELETE FROM ciudades WHERE idciudad = ?";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public City findCityById(String id) {
        City city = new City();
        try {
            String query = "SELECT idciudad, nombre FROM ciudades WHERE idciudad = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                city.setIdciudad(rs.getString("idciudad"));
                city.setNombre(rs.getString("nombre"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return city;
    }

    @Override
    public List<City> findAllCities() {
        List<City> cities = new ArrayList<>();
        try {
            String query = "SELECT idciudad, nombre FROM ciudades";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                City city = new City(rs.getString("idciudad"), rs.getString("nombre"));
                cities.add(city);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }

}
