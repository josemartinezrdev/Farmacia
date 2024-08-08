package com.farmacia.proveedor.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.farmacia.proveedor.domain.entity.Proveedor;
import com.farmacia.proveedor.domain.entity.ProveedorDto;
import com.farmacia.proveedor.domain.service.ProveedorService;

public class ProveedorRepository implements ProveedorService {
    private Connection connection;

    public ProveedorRepository() {
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
    public void addProveedor(Proveedor proveedor) {
        try {
            String query = """
                    INSERT INTO proveedores (idproveedor, nombre, email, telefono, idtipo) VALUES (?, ?, ?, ?, ?)
                    """;
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, proveedor.getIdproveedor());
            ps.setString(2, proveedor.getNombre());
            ps.setString(3, proveedor.getEmail());
            ps.setString(4, proveedor.getTelefono());
            ps.setInt(5, proveedor.getIdtipo());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProveedor(Proveedor proveedor) {
        try {
            String query = """
                    UPDATE proveedores SET nombre = ?, email = ?, telefono = ?, idtipo = ? WHERE idproveedor = ?
                    """;
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, proveedor.getNombre());
            ps.setString(2, proveedor.getEmail());
            ps.setString(3, proveedor.getTelefono());
            ps.setInt(4, proveedor.getIdtipo());
            ps.setString(5, proveedor.getIdproveedor());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProveedor(String id) {
        try {

            String query = "DELETE FROM proveedores WHERE idproveedor = ?";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Proveedor findByIdProveedor(String id) {
        Proveedor proveedor = new Proveedor();
        try {
            String query = """
                    SELECT idproveedor, nombre, email, telefono, idtipo FROM proveedores WHERE idproveedor = ?
                    """;
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                proveedor.setIdproveedor(rs.getString("idproveedor"));
                proveedor.setNombre(rs.getString("nombre"));
                proveedor.setEmail(rs.getString("email"));
                proveedor.setTelefono(rs.getString("telefono"));
                proveedor.setIdtipo(rs.getInt("idtipo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return proveedor;
    }

    @Override
    public List<Proveedor> findAllProveedores() {
        List<Proveedor> proveedores = new ArrayList<>();
        try {
            String query = """
                    SELECT idproveedor, nombre, email, telefono, idtipo FROM proveedores
                    """;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Proveedor proveedor = new Proveedor(
                        rs.getString("idproveedor"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("telefono"),
                        rs.getInt("idtipo"));
                proveedores.add(proveedor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return proveedores;
    }

    @Override
    public ProveedorDto findByIdProveedorDto(String id) {
        ProveedorDto proveedorDto = new ProveedorDto();
        try {
            String query = """
                            SELECT prov.idproveedor, prov.nombre, prov.email, prov.telefono, prov.idtipo, tip.tipo
                            FROM proveedores prov INNER JOIN tipos_documentos tip ON
                            prov.idtipo = tip.idtipo WHERE idproveedor = ?
                    """;
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                proveedorDto.setIdproveedor(rs.getString("idproveedor"));
                proveedorDto.setNombre(rs.getString("nombre"));
                proveedorDto.setEmail(rs.getString("email"));
                proveedorDto.setTelefono(rs.getString("telefono"));
                proveedorDto.setNombreTipo(rs.getString("tipo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return proveedorDto;
    }

    @Override
    public List<ProveedorDto> findAllProveedoresDto() {
        List<ProveedorDto> proveedoresDto = new ArrayList<>();
        try {
            String query = """
                    SELECT prov.idproveedor, prov.nombre, prov.email, prov.telefono, prov.idtipo, tip.tipo
                    FROM proveedores prov INNER JOIN tipos_documentos tip ON prov.idtipo = tip.idtipo
                    ORDER BY prov.idproveedor
                    """;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                ProveedorDto proveedorDto = new ProveedorDto(
                        rs.getString("idproveedor"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("telefono"),
                        rs.getInt("idtipo"),
                        rs.getString("tipo"));
                proveedoresDto.add(proveedorDto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return proveedoresDto;
    }

}
