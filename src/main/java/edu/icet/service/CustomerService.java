package edu.icet.service;

import edu.icet.model.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    boolean addCustomer(CustomerDto customerDto);
    boolean updateCustomer(CustomerDto customerDto);
    boolean deleteCustomer(String id);
    CustomerDto searchCustomerById(String id);
    List<CustomerDto> getAll();
}
