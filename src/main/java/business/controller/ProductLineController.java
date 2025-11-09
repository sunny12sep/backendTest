package business.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import business.dto.ProductLineDTO;
import business.service.ProductLineService;

@RestController
@RequestMapping("/productlines")
public class ProductLineController {

    @Autowired
    private ProductLineService productLineService;

    @GetMapping("/by-product/{productCode}")
    public ResponseEntity<ProductLineDTO> getProductLineSummary(@PathVariable String productCode) {
        ProductLineDTO summary = productLineService.getProductLineSummaryByProductCode(productCode);
        return ResponseEntity.ok(summary);
    }
    
    @GetMapping
    public List<ProductLineDTO> getAllProductLines() {
        return productLineService.getAllProductLines();
    }

}