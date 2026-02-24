package edu.icet.repository.impl;

import edu.icet.model.dto.CustomerDto;
import edu.icet.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public boolean addCustomer(CustomerDto customerDto) {
        String sql = "INSERT INTO customer VALUES(?,?,?,?,?,?,?,?,?)";

        return jdbcTemplate.update(sql,
                customerDto.getId(),
                customerDto.getTitle(),
                customerDto.getName(),
                customerDto.getDob(),
                customerDto.getSalary(),
                customerDto.getAddress(),
                customerDto.getCity(),
                customerDto.getProvince(),
                customerDto.getPostalCode()
        )>0;
    }

    @Override
    public boolean updateCustomer(CustomerDto customerDto) {
        String sql = "UPDATE customer SET CustTitle=?, CustName=?, DOB=?, " +
                "salary=?, CustAddress=?, City=?, Province=?, PostalCode=? WHERE CustID=?";
        return jdbcTemplate.update(sql,
                customerDto.getTitle(),
                customerDto.getName(),
                customerDto.getDob(),
                customerDto.getSalary(),
                customerDto.getAddress(),
                customerDto.getCity(),
                customerDto.getProvince(),
                customerDto.getPostalCode(),
                customerDto.getId()
                )>0;
    }

    @Override
    public boolean deleteCustomer(String id) {
        String sql = "DELETE FROM customer WHERE CustID=?";
        return jdbcTemplate.update(sql, id)>0;
    }

    @Override
    public CustomerDto searchCustomerById(String id) {
        String sql = "SELECT * FROM customer WHERE CustID=?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            CustomerDto customerDto = new CustomerDto();
            customerDto.setId(rs.getString(1));
            customerDto.setTitle(rs.getString(2));
            customerDto.setName(rs.getString(3));
            customerDto.setDob(rs.getDate(4));
            customerDto.setSalary(rs.getDouble(5));
            customerDto.setAddress(rs.getString(6));
            customerDto.setCity(rs.getString(7));
            customerDto.setProvince(rs.getString(8));
            customerDto.setPostalCode(rs.getString(9));
            return customerDto;
        }, id);
    }

    @Override
    public List<CustomerDto> getAll() {
        String sql = "SELECT * FROM customer";

        List<CustomerDto> customerDtoList = jdbcTemplate.query(sql, (rs, rowNum) -> {
           CustomerDto customer = new CustomerDto();
           customer.setId(rs.getString(1));
           customer.setTitle(rs.getString(2));
           customer.setName(rs.getString(3));
           customer.setDob(rs.getDate(4));
           customer.setSalary(rs.getDouble(5));
           customer.setAddress(rs.getString(6));
           customer.setCity(rs.getString(7));
           customer.setProvince(rs.getString(8));
           customer.setPostalCode(rs.getString(9));
           return customer;
        });
        return customerDtoList;
    }
}
