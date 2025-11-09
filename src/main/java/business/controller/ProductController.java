package business.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import business.dto.ProductDTO;
import business.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/customer/{customerNumber}")
    public ResponseEntity<List<ProductDTO>> getProductsByCustomer(@PathVariable Integer customerNumber) {
        List<ProductDTO> products = productService.getProductsByCustomerNumber(customerNumber);
        return ResponseEntity.ok(products);
    }
    
    @GetMapping("/order/{orderNumber}")
    public ResponseEntity<List<ProductDTO>> getProductsByOrderNumber(@PathVariable Integer orderNumber) {
        return ResponseEntity.ok(productService.getProductsByOrderNumber(orderNumber));
    }
    
    @GetMapping("/by-productline/{productLine}")
    public List<ProductDTO> getProductsByProductLine(@PathVariable String productLine) {
        return productService.getProductsByProductLine(productLine);
    }

}