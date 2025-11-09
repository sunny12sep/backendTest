package business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import business.dto.ProductVendorDTO;
import business.service.ProductVendorService;

@RestController
@RequestMapping("/productvendor")
public class ProductVendorController {

    @Autowired
    private ProductVendorService productVendorService;

    @GetMapping("/{productCode}")
    public ProductVendorDTO getProductVendorByProductCode(@PathVariable String productCode) {
        return productVendorService.getProductVendorByProductCode(productCode);
    }
}