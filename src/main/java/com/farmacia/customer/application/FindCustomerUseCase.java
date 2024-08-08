package com.farmacia.customer.application;

import java.util.List;

import com.farmacia.customer.domain.entity.Customer;
import com.farmacia.customer.domain.service.CustomerService;

public class FindCustomerUseCase {

    private CustomerService customerService;

    public FindCustomerUseCase(CustomerService customerService) {
        this.customerService = customerService;
    }

    public List<Customer> execute() {
        return customerService.findAllCustomers();
    }
}
