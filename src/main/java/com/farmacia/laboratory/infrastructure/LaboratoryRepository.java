package com.farmacia.laboratory.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.farmacia.laboratory.domain.entity.Laboratory;
import com.farmacia.laboratory.domain.service.LaboratoryService;

public class LaboratoryRepository implements LaboratoryService {

    private Connection connection;

    public LaboratoryRepository() {
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
    public void addLaboratory(Laboratory laboratory) {
        try {
            String query = "INSERT INTO laboratorios (nombre) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, laboratory.getNombre());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateLaboratory(Laboratory laboratory) {
        try {
            String query = "UPDATE laboratorios SET nombre = ? WHERE idlaboratorio = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, laboratory.getNombre());
            ps.setInt(2, laboratory.getIdlaboratorio());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteLaboratory(int id) {
        try {
            String query = "DELETE FROM laboratorios WHERE idlaboratorio = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Laboratory findByIdLaboratory(int id) {
        Laboratory laboratory = new Laboratory();
        try {
            String query = "SELECT idlaboratorio, nombre FROM laboratorios WHERE idlaboratorio = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                laboratory.setIdlaboratorio(rs.getInt("idlaboratorio"));
                laboratory.setNombre(rs.getString("nombre"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return laboratory;
    }

    @Override
    public List<Laboratory> findAllLaboratories() {
        List<Laboratory> laboratories = new ArrayList<>();
        try {
            String query = "SELECT idlaboratorio, nombre FROM laboratorios ORDER BY idlaboratorio ASC";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Laboratory laboratory = new Laboratory(rs.getInt("idlaboratorio"), rs.getString("nombre"));
                laboratories.add(laboratory);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return laboratories;
    }
}
