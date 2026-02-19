package edu.icet.controller;

import edu.icet.model.dto.CustomerDto;
import edu.icet.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@CrossOrigin
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/add")
    public boolean addCustomer(@RequestBody CustomerDto customerDto){
        return customerService.addCustomer(customerDto);
    }

    @PutMapping("/update")
    public boolean updateCustomer(@RequestBody CustomerDto customerDto){
        return customerService.updateCustomer(customerDto);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteCustomer(@PathVariable String id){
        return customerService.deleteCustomer(id);
    }

    @GetMapping("/search-by-id/{id}")
    public CustomerDto searchCustomer(@PathVariable String id){
        return customerService.searchCustomerById(id);
    }

    @GetMapping("/getAll")
    public List<CustomerDto> getAll(){
       return customerService.getAll();
    }


}
