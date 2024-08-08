package com.farmacia.customer.application;

import com.farmacia.customer.domain.entity.Customer;
import com.farmacia.customer.domain.service.CustomerService;

public class FindByIdCustomerUseCase {

    private final CustomerService customerService;

    public FindByIdCustomerUseCase(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Customer execute(String id) {
        return customerService.findCustomerById(id);
    }

}
