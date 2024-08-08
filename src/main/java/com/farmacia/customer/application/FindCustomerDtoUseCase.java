package com.farmacia.customer.application;

import java.util.List;

import com.farmacia.customer.domain.entity.CustomerDto;
import com.farmacia.customer.domain.service.CustomerService;

public class FindCustomerDtoUseCase {

    private CustomerService customerService;

    public FindCustomerDtoUseCase(CustomerService customerService) {
        this.customerService = customerService;
    }

    public List<CustomerDto> execute() {
        return customerService.findAllCustomersDto();
    }
}
