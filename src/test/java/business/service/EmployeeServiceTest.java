package business.service;

import business.dto.EmployeeDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    void testGetEmployeesByValidCity() {
    	
    	List<EmployeeDTO> employees = employeeService.getEmployeesByCity("NYC");
    	List<Integer> actualEmployeeNumbers = new ArrayList<>();
    	for (EmployeeDTO emp : employees) {
            actualEmployeeNumbers.add(emp.getEmployeeNumber());
        }
    	
        List<Integer> expectedEmployeeNumbers = new ArrayList<>();
        expectedEmployeeNumbers.add(1286);
        expectedEmployeeNumbers.add(1323);

        Collections.sort(expectedEmployeeNumbers);
        Collections.sort(actualEmployeeNumbers);

        assertEquals(expectedEmployeeNumbers, actualEmployeeNumbers);
    }

    @Test
    void testGetEmployeesByInvalidCity() {
        
        List<EmployeeDTO> employees = employeeService.getEmployeesByCity("");
        assertTrue(employees.isEmpty());
    }
}