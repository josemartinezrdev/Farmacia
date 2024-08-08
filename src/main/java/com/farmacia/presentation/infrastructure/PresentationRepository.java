package com.farmacia.presentation.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.farmacia.presentation.domain.entity.Presentation;
import com.farmacia.presentation.domain.service.PresentationService;

public class PresentationRepository implements PresentationService {

    private Connection connection;

    public PresentationRepository() {
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
    public void addPresentation(Presentation presentation) {
        try {
            String query = "INSERT INTO presentaciones (nombre) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, presentation.getNombre());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePresentation(Presentation presentation) {
        try {
            String querty = "UPDATE presentaciones SET nombre = ? WHERE idpresentacion = ?";
            PreparedStatement ps = connection.prepareStatement(querty);
            ps.setString(1, presentation.getNombre());
            ps.setInt(2, presentation.getIdpresentacion());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePresentation(int id) {
        try {
            String query = "DELETE FROM presentaciones WHERE idpresentacion = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Presentation findByIdPresentation(int id) {
        Presentation presentation = new Presentation();
        try {
            String query = "SELECT idpresentacion, nombre FROM presentaciones WHERE idpresentacion = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                presentation.setIdpresentacion(rs.getInt("idpresentacion"));
                presentation.setNombre(rs.getString("nombre"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return presentation;
    }

    @Override
    public List<Presentation> findAllPresentations() {
        List<Presentation> presentations = new ArrayList<>();
        try {
            String query = "SELECT idpresentacion, nombre FROM presentaciones ORDER BY idpresentacion ASC";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Presentation presentation = new Presentation(rs.getInt("idpresentacion"), rs.getString("nombre"));
                presentations.add(presentation);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return presentations;
    }
}
