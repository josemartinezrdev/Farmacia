package com.farmacia.type_document.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.farmacia.type_document.domain.entity.TypeDocument;
import com.farmacia.type_document.domain.service.TypeDocumentService;

public class TypeDocumentRepository implements TypeDocumentService {

    private Connection connection;

    public TypeDocumentRepository() {
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
    public void addTypeDocument(TypeDocument typeDocument) {
        try {

            String query = "INSERT INTO tipos_documentos (tipo) VALUES (?)";

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, typeDocument.getTipo());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTypeDocument(TypeDocument typeDocument) {
        try {
            String query = "UPDATE tipos_documentos SET tipo = ? WHERE idtipo = ?";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, typeDocument.getTipo());
            ps.setInt(2, typeDocument.getIdtipo());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTypeDocument(int id) {
        try {

            String query = "DELETE FROM tipos_documentos WHERE idtipo = ?";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public TypeDocument findTypeDocumentById(int id) {
        TypeDocument typeDocument = new TypeDocument();
        try {
            String query = "SELECT idtipo, tipo FROM tipos_documentos WHERE idtipo = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                typeDocument.setIdtipo(rs.getInt("idtipo"));
                typeDocument.setTipo(rs.getString("tipo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return typeDocument;

    }

    @Override
    public List<TypeDocument> findAllTypesDocuments() {
        List<TypeDocument> typesDocuments = new ArrayList<>();
        try {
            String query = "SELECT idtipo, tipo FROM tipos_documentos";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                TypeDocument typeDocument = new TypeDocument(rs.getInt("idtipo"), rs.getString("tipo"));
                typesDocuments.add(typeDocument);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return typesDocuments;
    }

}
