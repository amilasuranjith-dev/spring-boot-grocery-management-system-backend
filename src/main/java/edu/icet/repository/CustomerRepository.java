package edu.icet.repository;

import edu.icet.model.dto.CustomerDto;
import java.util.List;

public interface CustomerRepository {
    boolean addCustomer(CustomerDto customerDto);
    boolean updateCustomer(CustomerDto customerDto);
    boolean deleteCustomer(String id);
    CustomerDto searchCustomer(String id);
    List<CustomerDto> getAll();
}
