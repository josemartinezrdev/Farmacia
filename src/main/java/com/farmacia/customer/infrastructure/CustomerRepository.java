package com.farmacia.customer.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.farmacia.customer.domain.entity.Customer;
import com.farmacia.customer.domain.entity.CustomerDto;
import com.farmacia.customer.domain.service.CustomerService;

public class CustomerRepository implements CustomerService {

    private Connection connection;

    public CustomerRepository() {
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
    public void addCustomer(Customer customer) {
        try {
            String query = "INSERT INTO clientes (idcliente, nombre, apellido, edad, fechaNacimiento, fechaRegistro, idtipo, idbarrio) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, customer.getIdcliente());
            ps.setString(2, customer.getNombre());
            ps.setString(3, customer.getApellido());
            ps.setInt(4, customer.getEdad());
            ps.setString(5, customer.getFechaNacimiento());
            ps.setDate(6, customer.getFechaRegistro());
            ps.setInt(7, customer.getIdtipo());
            ps.setInt(8, customer.getIdbarrio());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        try {
            String query = "UPDATE clientes SET nombre = ?, apellido = ?, idtipo = ?, idbarrio = ? WHERE idcliente = ?";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, customer.getNombre());
            ps.setString(2, customer.getApellido());
            ps.setInt(3, customer.getIdtipo());
            ps.setInt(4, customer.getIdbarrio());
            ps.setString(5, customer.getIdcliente());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(String id) {
        try {
            String query = "DELETE FROM clientes WHERE idcliente = ?";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer findCustomerById(String id) {
        Customer customer = new Customer();
        try {
            String query = "SELECT idcliente, nombre, apellido, edad, fechaNacimiento, fechaRegistro, idtipo, idbarrio FROM clientes WHERE idcliente = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                customer.setIdcliente(rs.getString("idcliente"));
                customer.setNombre(rs.getString("nombre"));
                customer.setApellido(rs.getString("apellido"));
                customer.setEdad(rs.getInt("edad"));
                customer.setFechaNacimiento(rs.getString("fechaNacimiento"));
                customer.setFechaRegistro(rs.getDate("fechaRegistro"));
                customer.setIdtipo(rs.getInt("idtipo"));
                customer.setIdbarrio(rs.getInt("idbarrio"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public List<Customer> findAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        try {
            String query = "SELECT idcliente, nombre, apellido, edad, fechaNacimiento, fechaRegistro, idtipo, idbarrio FROM clientes";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setIdcliente(rs.getString("idcliente"));
                customer.setNombre(rs.getString("nombre"));
                customer.setApellido(rs.getString("apellido"));
                customer.setEdad(rs.getInt("edad"));
                customer.setFechaNacimiento(rs.getString("fechaNacimiento"));
                customer.setFechaRegistro(rs.getDate("fechaRegistro"));
                customer.setIdtipo(rs.getInt("idtipo"));
                customer.setIdbarrio(rs.getInt("idbarrio"));
                customers.add(customer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public CustomerDto findCustomerDtoById(String id) {
        CustomerDto customerDto = new CustomerDto();
        try {
            String query = "SELECT  cli.idcliente, cli.nombre, cli.apellido, cli.edad, cli.fechaNacimiento," +
                    " cli.fechaRegistro, tip.tipo, bar.nombre AS nombreBarrio FROM clientes cli" +
                    " INNER JOIN tipos_documentos tip ON cli.idtipo = tip.idtipo INNER JOIN barrios bar" +
                    " ON cli.idbarrio = bar.idbarrio WHERE idcliente = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                customerDto.setIdcliente(rs.getString("idcliente"));
                customerDto.setNombre(rs.getString("nombre"));
                customerDto.setApellido(rs.getString("apellido"));
                customerDto.setEdad(rs.getInt("edad"));
                customerDto.setFechaNacimiento(rs.getString("fechaNacimiento"));
                customerDto.setFechaRegistro(rs.getDate("fechaRegistro"));
                customerDto.setNombreTipo(rs.getString("tipo"));
                customerDto.setNombreBarrio(rs.getString("nombreBarrio"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerDto;
    }

    @Override
    public List<CustomerDto> findAllCustomersDto() {
        List<CustomerDto> customersDto = new ArrayList<>();
        try {
            String query = "SELECT  cli.idcliente, cli.nombre, cli.apellido, cli.edad, cli.fechaNacimiento," +
                    " cli.fechaRegistro, tip.tipo, bar.nombre AS nombreBarrio FROM clientes cli" +
                    " INNER JOIN tipos_documentos tip ON cli.idtipo = tip.idtipo INNER JOIN barrios bar" +
                    " ON cli.idbarrio = bar.idbarrio";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                CustomerDto customerDto = new CustomerDto();
                customerDto.setIdcliente(rs.getString("idcliente"));
                customerDto.setNombre(rs.getString("nombre"));
                customerDto.setApellido(rs.getString("apellido"));
                customerDto.setEdad(rs.getInt("edad"));
                customerDto.setFechaNacimiento(rs.getString("fechaNacimiento"));
                customerDto.setFechaRegistro(rs.getDate("fechaRegistro"));
                customerDto.setNombreTipo(rs.getString("tipo"));
                customerDto.setNombreBarrio(rs.getString("nombreBarrio"));
                customersDto.add(customerDto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return customersDto;
    }

}
