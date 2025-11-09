package business.service.impl;

import business.dto.EmployeeCustomerCountDTO;
import business.dto.EmployeeDTO;
import business.entity.Employee;
import business.repository.EmployeeRepository;
import business.service.EmployeeService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeDTO> getAllEmployeeSummaries() {
        return employeeRepository.findAll().stream()
                .map(emp -> new EmployeeDTO(
                        emp.getEmployeeNumber(),
                        emp.getFirstName(),
                        emp.getLastName(),
                        emp.getJobTitle(),
                        emp.getEmail(),
                        emp.getOffice() != null ? emp.getOffice().getOfficeCode() : null
                ))
                .collect(Collectors.toList());
    }
    
    @Override
    public List<EmployeeDTO> getEmployeesByCity(String city) {
        List<Employee> employees = employeeRepository.findByOfficeCity(city);
        return employees.stream()
                .map(emp -> new EmployeeDTO(
                        emp.getEmployeeNumber(),
                        emp.getFirstName(),
                        emp.getLastName(),
                        emp.getJobTitle(),
                        emp.getEmail(),
                        emp.getOffice() != null ? emp.getOffice().getOfficeCode() : null
                ))
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeCustomerCountDTO> getEmployeesWithCustomerCount() {
        return employeeRepository.findAll().stream()
                .map(emp -> new EmployeeCustomerCountDTO(
                        emp.getEmployeeNumber(),
                        emp.getFirstName(),
                        emp.getLastName(),
                        emp.getCustomers() != null ? (long) emp.getCustomers().size() : 0L
                ))
                .collect(Collectors.toList());
    }
    
    @Override
    public int countEmployeesByCity(String city) {
        return employeeRepository.findByOfficeCity(city).size();
    }
}