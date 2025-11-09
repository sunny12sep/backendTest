package business.controller;

import business.dto.OfficeDTO;
import business.service.OfficeService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/offices")
public class OfficeController {

    private final OfficeService officeService;

    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }
    
    @GetMapping
    public ResponseEntity<List<OfficeDTO>> getAllOffices() {
        return ResponseEntity.ok(officeService.getAllOffices());
    }

    @GetMapping("/employee/{employeeNumber}")
    public ResponseEntity<OfficeDTO> getOfficeByEmployeeNumber(@PathVariable Integer employeeNumber) {
        return ResponseEntity.ok(officeService.getOfficeByEmployeeNumber(employeeNumber));
    }
}