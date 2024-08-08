package com.farmacia.customer.application;

import com.farmacia.customer.domain.service.CustomerService;

public class DeleteCustomerUseCase {

    private final CustomerService customerService;

    public DeleteCustomerUseCase(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void execute(String id) {
        customerService.deleteCustomer(id);
    }

}
