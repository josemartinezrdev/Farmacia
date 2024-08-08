package com.farmacia.customer.application;

import com.farmacia.customer.domain.entity.CustomerDto;
import com.farmacia.customer.domain.service.CustomerService;

public class FindByIdCustomerDtoUseCase {

    private CustomerService customerService;

    public FindByIdCustomerDtoUseCase(CustomerService customerService) {
        this.customerService = customerService;
    }

    public CustomerDto execute(String id) {
        return customerService.findCustomerDtoById(id);
    }
}
