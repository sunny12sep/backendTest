package business.service.impl;

import business.dto.OfficeDTO;
import business.entity.Employee;
import business.entity.Office;
import business.exception.InvalidEmployeeNumberException;
import business.repository.EmployeeRepository;
import business.repository.OfficeRepository;
import business.service.OfficeService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class OfficeServiceImpl implements OfficeService {

    private final EmployeeRepository employeeRepository;
    private final OfficeRepository officeRepository;

    public OfficeServiceImpl(EmployeeRepository employeeRepository, OfficeRepository officeRepository) {
        this.employeeRepository = employeeRepository;
        this.officeRepository = officeRepository;
    }


    @Override
    public OfficeDTO getOfficeByEmployeeNumber(Integer employeeNumber) {

    	Optional<Employee> optionalEmployee = employeeRepository.findById(employeeNumber);
		if (optionalEmployee.isPresent() == false) {
			throw new InvalidEmployeeNumberException();
		}
		
        Office office = optionalEmployee.get().getOffice();
        return new OfficeDTO(
                office.getOfficeCode(),
                office.getCity(),
                office.getAddressLine1(),
                office.getPostalCode()
        );
    }
    
    @Override
    public List<OfficeDTO> getAllOffices() {
        return officeRepository.findAll().stream()
            .map(office -> new OfficeDTO(
                office.getOfficeCode(),
                office.getCity(),
                office.getAddressLine1(),
                office.getPostalCode()
            ))
            .toList();
    }

}