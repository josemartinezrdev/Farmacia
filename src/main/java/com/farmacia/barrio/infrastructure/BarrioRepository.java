package com.farmacia.barrio.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.farmacia.barrio.domain.entity.Barrio;
import com.farmacia.barrio.domain.entity.BarrioDto;
import com.farmacia.barrio.domain.service.BarrioService;

public class BarrioRepository implements BarrioService {

    private Connection connection;

    public BarrioRepository() {
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
    public void addBarrio(Barrio barrio) {
        try {
            String query = "INSERT INTO barrios (nombre, idciudad) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, barrio.getNombre());
            ps.setString(2, barrio.getIdciudad());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateBarrio(Barrio barrio) {
        try {
            String query = "UPDATE barrios SET nombre = ?, idciudad = ? WHERE idbarrio = ?";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, barrio.getNombre());
            ps.setString(2, barrio.getIdciudad());
            ps.setInt(3, barrio.getIdbarrio());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBarrio(int id) {
        try {

            String query = "DELETE FROM barrios WHERE idbarrio = ?";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Barrio findBarrioById(int id) {
        Barrio barrio = new Barrio();
        try {
            String query = "SELECT idbarrio, nombre, idciudad FROM barrios WHERE idbarrio = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                barrio.setIdbarrio(rs.getInt("idbarrio"));
                barrio.setNombre(rs.getString("nombre"));
                barrio.setIdciudad(rs.getString("idciudad"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return barrio;
    }

    @Override
    public List<Barrio> findAllBarrios() {
        List<Barrio> barrios = new ArrayList<>();
        try {
            String query = "SELECT idbarrio, nombre, idciudad FROM barrios";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Barrio barrio = new Barrio(rs.getInt("idbarrio"), rs.getString("nombre"), rs.getString("idciudad"));
                barrios.add(barrio);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return barrios;
    }

    @Override
    public BarrioDto findBarrioDtoById(int id) {
        BarrioDto barrioDto = new BarrioDto();
        try {
            String query = "SELECT bar.idbarrio, bar.nombre, bar.idciudad, ciu.nombre AS nombreCiudad FROM barrios bar"
                    +
                    " INNER JOIN ciudades ciu ON bar.idciudad = ciu.idciudad WHERE bar.idbarrio = ?";

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                barrioDto.setIdbarrio(rs.getInt("idbarrio"));
                barrioDto.setNombre(rs.getString("nombre"));
                barrioDto.setIdciudad(rs.getString("idciudad"));
                barrioDto.setNombreCity(rs.getString("nombreCiudad"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return barrioDto;
    }

    @Override
    public List<BarrioDto> findAllBarriosDto() {
        List<BarrioDto> barriosDto = new ArrayList<>();
        try {
            String query = "SELECT bar.idbarrio, bar.nombre, bar.idciudad, ciu.nombre AS nombreCiudad FROM barrios bar"
                    +
                    " INNER JOIN ciudades ciu ON bar.idciudad = ciu.idciudad;";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                BarrioDto barrioDto = new BarrioDto(
                        rs.getInt("idbarrio"),
                        rs.getString("nombre"),
                        rs.getString("idciudad"),
                        rs.getString("nombreCiudad"));

                barriosDto.add(barrioDto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return barriosDto;
    }

}
