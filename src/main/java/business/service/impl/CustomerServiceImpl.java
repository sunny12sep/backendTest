package business.service.impl;

import org.springframework.stereotype.Service;
import business.dto.CustomerDTO;
import business.exception.InvalidEmployeeNumberException;
import business.repository.CustomerRepository;
import business.service.CustomerService;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
    	 return customerRepository.findAll().stream()
    	            .map(c -> new CustomerDTO(
    	                c.getCustomerNumber(),
    	                c.getCustomerName(),
    	                c.getCountry()))
    	            .collect(Collectors.toList());
    }

    @Override
    public List<CustomerDTO> getCustomersBySalesRep(Integer employeeNumber) {
    	List<CustomerDTO> filtered = customerRepository.findBySalesRepEmployeeNumber(employeeNumber).stream()
                .map(c -> new CustomerDTO(
                        c.getCustomerNumber(),
                        c.getCustomerName(),
                        c.getCountry()))
                .collect(Collectors.toList());
    	
    	if (filtered.size() == 0) {
    		throw new InvalidEmployeeNumberException();
    	}
    	
    	return filtered;
    }

}