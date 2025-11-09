package business.service;

import java.util.List;

import business.dto.CustomerDTO;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();
    List<CustomerDTO> getCustomersBySalesRep(Integer employeeNumber);
}