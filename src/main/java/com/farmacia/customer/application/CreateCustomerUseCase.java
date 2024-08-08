package com.farmacia.customer.application;

import com.farmacia.customer.domain.entity.Customer;
import com.farmacia.customer.domain.service.CustomerService;

public class CreateCustomerUseCase {

    private final CustomerService customerService;

    public CreateCustomerUseCase(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void execute(Customer customer) {
        customerService.addCustomer(customer);
    }

}
