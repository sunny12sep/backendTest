package business.service;

import java.util.List;
import business.dto.OfficeDTO;

public interface OfficeService {
    OfficeDTO getOfficeByEmployeeNumber(Integer employeeNumber);
    List<OfficeDTO> getAllOffices();
}