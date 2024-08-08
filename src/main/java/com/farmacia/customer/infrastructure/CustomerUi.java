package com.farmacia.customer.infrastructure;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.farmacia.customer.application.CreateCustomerUseCase;
import com.farmacia.customer.application.DeleteCustomerUseCase;
import com.farmacia.customer.application.FindByIdCustomerDtoUseCase;
import com.farmacia.customer.application.FindByIdCustomerUseCase;
import com.farmacia.customer.application.FindCustomerDtoUseCase;
import com.farmacia.customer.application.FindCustomerUseCase;
import com.farmacia.customer.application.UpdateCustomerUseCase;
import com.farmacia.customer.domain.entity.Customer;
import com.farmacia.customer.domain.entity.CustomerDto;

public class CustomerUi {

    private CreateCustomerUseCase createCustomerUseCase;
    private UpdateCustomerUseCase updateCustomerUseCase;
    private FindCustomerUseCase findCustomerUseCase;
    private FindByIdCustomerUseCase findByIdCustomerUseCase;
    private DeleteCustomerUseCase deleteCustomerUseCase;
    private FindByIdCustomerDtoUseCase findByIdCustomerDtoUseCase;
    private FindCustomerDtoUseCase findCustomerDtoUseCase;

    public CustomerUi(CreateCustomerUseCase createCustomerUseCase, UpdateCustomerUseCase updateCustomerUseCase,
            FindCustomerUseCase findCustomerUseCase, FindByIdCustomerUseCase findByIdCustomerUseCase,
            DeleteCustomerUseCase deleteCustomerUseCase, FindByIdCustomerDtoUseCase findByIdCustomerDtoUseCase,
            FindCustomerDtoUseCase findCustomerDtoUseCase) {
        this.createCustomerUseCase = createCustomerUseCase;
        this.updateCustomerUseCase = updateCustomerUseCase;
        this.findCustomerUseCase = findCustomerUseCase;
        this.findByIdCustomerUseCase = findByIdCustomerUseCase;
        this.deleteCustomerUseCase = deleteCustomerUseCase;
        this.findByIdCustomerDtoUseCase = findByIdCustomerDtoUseCase;
        this.findCustomerDtoUseCase = findCustomerDtoUseCase;
    }

    public void showAllCustomers(List<Customer> customers) {

        String[] columns = { "ID", "Name", "Apellido", "Edad", "Fecha Nac", "Fecha Reg", "ID Tipo Doc", "ID Barrio" };

        DefaultTableModel model = new DefaultTableModel(columns, 0);

        customers.forEach(customer -> {
            Object[] row = {
                    customer.getIdcliente(),
                    customer.getNombre(),
                    customer.getApellido(),
                    customer.getEdad(),
                    customer.getFechaNacimiento(),
                    customer.getFechaRegistro(),
                    customer.getIdtipo(),
                    customer.getIdbarrio()
            };
            model.addRow(row);
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();

        table.setPreferredSize(new Dimension(800, 400));
        scrollPane.setPreferredSize(new Dimension(800, 400));
        panel.setPreferredSize(new Dimension(800, 400));

        panel.add(scrollPane);
        JOptionPane.showMessageDialog(null, panel, "Customer List", JOptionPane.PLAIN_MESSAGE);

    }

    public void showCustomerById(Customer customer) {

        String[] columns = { "ID", "Name", "Apellido", "Edad", "Fecha Nac", "Fecha Reg", "ID Tipo Doc", "ID Barrio" };

        DefaultTableModel model = new DefaultTableModel(columns, 0);

        Object[] row = {
                customer.getIdcliente(),
                customer.getNombre(),
                customer.getApellido(),
                customer.getEdad(),
                customer.getFechaNacimiento(),
                customer.getFechaRegistro(),
                customer.getIdtipo(),
                customer.getIdbarrio()
        };
        model.addRow(row);

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();

        table.setPreferredSize(new Dimension(800, 400));
        scrollPane.setPreferredSize(new Dimension(800, 400));
        panel.setPreferredSize(new Dimension(800, 400));

        panel.add(scrollPane);
        JOptionPane.showMessageDialog(null, panel, "Customer List", JOptionPane.PLAIN_MESSAGE);

    }

    public void showAllCustomersDto(List<CustomerDto> customersDto) {
        String[] columns = { "ID", "Nombre", "Apellido", "Edad", "Fecha Nac", "Fecha Reg", "Tipo Doc", "Barrio" };

        DefaultTableModel model = new DefaultTableModel(columns, 0);

        customersDto.forEach(customer -> {
            Object[] row = {
                    customer.getIdcliente(),
                    customer.getNombre(),
                    customer.getApellido(),
                    customer.getEdad(),
                    customer.getFechaNacimiento(),
                    customer.getFechaRegistro(),
                    customer.getNombreTipo(),
                    customer.getNombreBarrio()
            };
            model.addRow(row);
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();

        table.setPreferredSize(new Dimension(800, 400));
        scrollPane.setPreferredSize(new Dimension(800, 400));
        panel.setPreferredSize(new Dimension(800, 400));

        panel.add(scrollPane);
        JOptionPane.showMessageDialog(null, panel, "Customer List", JOptionPane.PLAIN_MESSAGE);
    }

    public void showCustomerDtoById(CustomerDto customerDto) {

        String[] columns = { "ID", "Nombre", "Apellido", "Edad", "Fecha Nac", "Fecha Reg", "Tipo Doc", "Barrio" };

        DefaultTableModel model = new DefaultTableModel(columns, 0);

        Object[] row = {
                customerDto.getIdcliente(),
                customerDto.getNombre(),
                customerDto.getApellido(),
                customerDto.getEdad(),
                customerDto.getFechaNacimiento(),
                customerDto.getFechaRegistro(),
                customerDto.getNombreTipo(),
                customerDto.getNombreBarrio()
        };
        model.addRow(row);

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();

        table.setPreferredSize(new Dimension(800, 400));
        scrollPane.setPreferredSize(new Dimension(800, 400));
        panel.setPreferredSize(new Dimension(800, 400));

        panel.add(scrollPane);
        JOptionPane.showMessageDialog(null, panel, "Customer List", JOptionPane.PLAIN_MESSAGE);

    }

    public void addCustomer() {
        Customer customer = new Customer();
        customer.setIdcliente(JOptionPane.showInputDialog(null, "Ingrese Id del Cliente"));
        customer.setNombre(JOptionPane.showInputDialog(null, "Ingrese el Nombre del cliente"));
        customer.setApellido(JOptionPane.showInputDialog(null, "Ingrese el Apellido del cliente"));
        customer.setEdad(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la Edad del cliente")));
        customer.setFechaNacimiento(JOptionPane.showInputDialog(null, "Ingrese la fecha de nacimiento (YYYY-MM-DD)"));
        customer.setIdbarrio(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del Barrio")));
        customer.setIdtipo(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del tipo de documento")));

        createCustomerUseCase.execute(customer);
    }

    public void updateCustomer() {
        Customer customer = findCustomerById();

        customer.setNombre(JOptionPane.showInputDialog(null, "Ingrese el Nombre del cliente"));
        customer.setApellido(JOptionPane.showInputDialog(null, "Ingrese el Apellido del cliente"));
        customer.setEdad(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la Edad del cliente")));
        customer.setFechaNacimiento(JOptionPane.showInputDialog(null, "Ingrese la fecha de nacimiento (YYYY-MM-DD)"));
        customer.setIdbarrio(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del Barrio")));
        customer.setIdtipo(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del tipo de documento")));

        updateCustomerUseCase.execute(customer);
    }

    public void findAllCustomers() {
        List<Customer> customers = findCustomerUseCase.execute();
        showAllCustomers(customers);
    }

    public Customer findCustomerById() {
        String id = JOptionPane.showInputDialog(null, "Ingrese el ID del cliente");
        Customer customer = findByIdCustomerUseCase.execute(id);
        showCustomerById(customer);
        return customer;
    }

    public void deleteCustomer() {
        Customer customer = findCustomerById();
        deleteCustomerUseCase.execute(customer.getIdcliente());
    }

    public void findAllCustomersDto() {
        List<CustomerDto> customersDto = findCustomerDtoUseCase.execute();
        showAllCustomersDto(customersDto);
    }

    public void findCustomerDtoById() {
        String id = JOptionPane.showInputDialog(null, "Ingrese el ID del cliente");
        CustomerDto customerDto = findByIdCustomerDtoUseCase.execute(id);
        showCustomerDtoById(customerDto);
    }

}
