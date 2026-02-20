package edu.icet.service.impl;

import edu.icet.model.dto.CustomerDto;
import edu.icet.repository.CustomerRepository;
import edu.icet.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public boolean addCustomer(CustomerDto customerDto) {
        return customerRepository.addCustomer(customerDto);
    }

    @Override
    public boolean updateCustomer(CustomerDto customerDto) {
        return customerRepository.updateCustomer(customerDto);
    }

    @Override
    public boolean deleteCustomer(String id) {
        return customerRepository.deleteCustomer(id);
    }

    @Override
    public CustomerDto searchCustomerById(String id) {
        return customerRepository.searchCustomerById(id);
    }

    @Override
    public List<CustomerDto> getAll() {
        return customerRepository.getAll();
    }
}
