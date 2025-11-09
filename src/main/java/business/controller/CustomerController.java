package business.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import business.dto.CustomerDTO;
import business.service.CustomerService;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }
    
    @GetMapping("/salesrep/{employeeNumber}")
    public ResponseEntity<List<CustomerDTO>> getCustomersBySalesRep(@PathVariable Integer employeeNumber) {
        return ResponseEntity.ok(customerService.getCustomersBySalesRep(employeeNumber));
    }
}