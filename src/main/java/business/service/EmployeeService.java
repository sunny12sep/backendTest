package business.service;

import business.dto.EmployeeCustomerCountDTO;
import business.dto.EmployeeDTO;
import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getAllEmployeeSummaries();
    List<EmployeeDTO> getEmployeesByCity(String city);
    List<EmployeeCustomerCountDTO> getEmployeesWithCustomerCount();
    int countEmployeesByCity(String city);
}