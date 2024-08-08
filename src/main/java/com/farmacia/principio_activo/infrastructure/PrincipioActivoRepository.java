package com.farmacia.principio_activo.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.farmacia.principio_activo.domain.entity.PrincipioActivo;
import com.farmacia.principio_activo.domain.service.PrincipioActivoService;

public class PrincipioActivoRepository implements PrincipioActivoService {

    private Connection connection;

    public PrincipioActivoRepository() {
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
    public void addPrincipioAct(PrincipioActivo principioActivo) {
        try {
            String query = "INSERT INTO principios_activos (nombre) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, principioActivo.getNombre());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePrincipioAct(PrincipioActivo principioActivo) {
        try {
            String query = "UPDATE principios_activos SET nombre = ? WHERE idprincipioact = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, principioActivo.getNombre());
            ps.setInt(2, principioActivo.getIdprincipioact());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePrincipioAct(int id) {
        try {
            String query = "DELETE FROM principios_activos WHERE idprincipioact = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public PrincipioActivo findByIdPrincipioAct(int id) {
        PrincipioActivo principioActivo = new PrincipioActivo();
        try {
            String query = "SELECT idprincipioact, nombre FROM principios_activos WHERE idprincipioact = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                principioActivo.setIdprincipioact(rs.getInt("idprincipioact"));
                principioActivo.setNombre(rs.getString("nombre"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return principioActivo;
    }

    @Override
    public List<PrincipioActivo> findAllPrincipiosActivos() {
        List<PrincipioActivo> principiosActivos = new ArrayList<>();
        try {
            String query = "SELECT idprincipioact, nombre FROM principios_activos ORDER BY idprincipioact ASC";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                PrincipioActivo principioActivo = new PrincipioActivo(
                        rs.getInt("idprincipioact"),
                        rs.getString("nombre"));
                principiosActivos.add(principioActivo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return principiosActivos;
    }

}
