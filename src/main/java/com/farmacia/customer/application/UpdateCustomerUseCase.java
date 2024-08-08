package com.farmacia.customer.application;

import com.farmacia.customer.domain.entity.Customer;
import com.farmacia.customer.domain.service.CustomerService;

public class UpdateCustomerUseCase {

    private CustomerService customerService;

    public UpdateCustomerUseCase(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void execute(Customer customer) {
        customerService.updateCustomer(customer);
    }
}
