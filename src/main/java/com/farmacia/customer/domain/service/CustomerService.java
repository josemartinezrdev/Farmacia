package com.farmacia.customer.domain.service;

import java.util.List;

import com.farmacia.customer.domain.entity.Customer;
import com.farmacia.customer.domain.entity.CustomerDto;

public interface CustomerService {
    public void addCustomer(Customer customer);

    public void updateCustomer(Customer customer);

    public void deleteCustomer(String id);

    Customer findCustomerById(String id);

    List<Customer> findAllCustomers();

    // DTO

    CustomerDto findCustomerDtoById(String id);

    List<CustomerDto> findAllCustomersDto();
}
