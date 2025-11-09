package business.controller;

import business.dto.EmployeeCustomerCountDTO;
import business.dto.EmployeeDTO;
import business.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployeeSummaries() {
        return ResponseEntity.ok(employeeService.getAllEmployeeSummaries());
    }
    
    @GetMapping("/{city}")
    public List<EmployeeDTO> getEmployeesByCity(@PathVariable String city) {
        return employeeService.getEmployeesByCity(city);
    }
    
    @GetMapping("/count/{city}")
    public ResponseEntity<Integer> countEmployeesByCity(@PathVariable String city) {
        return ResponseEntity.ok(employeeService.countEmployeesByCity(city));
    }

    @GetMapping("/with-customer-count")
    public List<EmployeeCustomerCountDTO> getEmployeesWithCustomerCount() {
        return employeeService.getEmployeesWithCustomerCount();
    }

}