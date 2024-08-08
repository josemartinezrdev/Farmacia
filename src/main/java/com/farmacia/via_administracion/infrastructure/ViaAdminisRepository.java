package com.farmacia.via_administracion.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.farmacia.via_administracion.domain.entity.ViaAdminis;
import com.farmacia.via_administracion.domain.service.ViaAdminisService;

public class ViaAdminisRepository implements ViaAdminisService {

    private Connection connection;

    public ViaAdminisRepository() {
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
    public void addViaAdminis(ViaAdminis viaAdminis) {
        try {
            String query = "INSERT INTO vias_administracion (nombre) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, viaAdminis.getNombre());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateViaAdminis(ViaAdminis viaAdminis) {
        try {
            String query = "UPDATE vias_administracion SET nombre = ? WHERE idviaadmin = ?";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, viaAdminis.getIdviaadmin());
            ps.setString(2, viaAdminis.getNombre());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteViaAdminis(int id) {
        try {
            String query = "DELETE FROM vias_administracion WHERE idviaadmin = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ViaAdminis findViaAdminisById(int id) {
        ViaAdminis viaAdminis = new ViaAdminis();
        try {
            String query = "SELECT idviaadmin, nombre FROM vias_administracion WHERE idviaadmin = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                viaAdminis.setIdviaadmin(rs.getInt("idviaadmin"));
                viaAdminis.setNombre(rs.getString("nombre"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return viaAdminis;
    }

    @Override
    public List<ViaAdminis> findAllViasAdminis() {
        List<ViaAdminis> viasAdminis = new ArrayList<>();
        try {
            String query = "SELECT idviaadmin, nombre FROM vias_administracion ORDER BY idviaadmin ASC";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                ViaAdminis viaAdminis = new ViaAdminis(
                        rs.getInt("idviaadmin"),
                        rs.getString("nombre"));
                viasAdminis.add(viaAdminis);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return viasAdminis;
    }

}
