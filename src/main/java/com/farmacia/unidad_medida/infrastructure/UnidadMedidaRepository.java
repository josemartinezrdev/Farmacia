package com.farmacia.unidad_medida.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.farmacia.unidad_medida.domain.entity.UnidadMedida;
import com.farmacia.unidad_medida.domain.service.UnidadMedidaService;

public class UnidadMedidaRepository implements UnidadMedidaService {

    private Connection connection;

    public UnidadMedidaRepository() {
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
    public void addUnidadMedida(UnidadMedida unidadMedida) {
        try {
            String query = "INSERT INTO unidades_medida (nombre) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, unidadMedida.getNombre());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUnidadMedida(UnidadMedida unidadMedida) {
        try {
            String query = "UPDATE unidades_media SET nombre = ? WHERE idunidadmedida = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, unidadMedida.getNombre());
            ps.setInt(2, unidadMedida.getIdunidadmedida());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUnidadMedida(int id) {
        try {
            String query = "DELETE FROM unidades_medida WHERE idunidadmedida = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public UnidadMedida findByIdUnidadMedida(int id) {
        UnidadMedida unidadMedida = new UnidadMedida();
        try {
            String query = "SELECT idunidadmedida, nombre FROM unidades_medida WHERE idunidadmedida = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                unidadMedida.setIdunidadmedida(rs.getInt("idunidadmedida"));
                unidadMedida.setNombre(rs.getString("nombre"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return unidadMedida;
    }

    @Override
    public List<UnidadMedida> findAllUnidadesMedidas() {
        List<UnidadMedida> unidadesMedidas = new ArrayList<>();
        try {
            String query = "SELECT idunidadmedida, nombre FROM unidades_medida ORDER BY idunidadmedida ASC";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                UnidadMedida unidadMedida = new UnidadMedida(
                        rs.getInt("idunidadmedida"),
                        rs.getString("nombre"));
                unidadesMedidas.add(unidadMedida);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return unidadesMedidas;
    }

}
