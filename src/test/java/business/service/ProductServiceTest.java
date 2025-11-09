package business.service;

import business.dto.ProductDTO;
import business.exception.InvalidCustomerNumberException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void testGetProductsByValidCustomerNumber() {
       
        List<ProductDTO> products = productService.getProductsByCustomerNumber(103);
        
        List<String> expectedProductCode = new ArrayList<>();
        expectedProductCode.add("S18_1589");
        expectedProductCode.add("S18_2870");
        expectedProductCode.add("S24_1628");
        expectedProductCode.add("S24_2022");
        expectedProductCode.add("S18_2625");
        expectedProductCode.add("S18_3685");
        expectedProductCode.add("S10_2016");
        Collections.sort(expectedProductCode);
        
        List<String> actualProductCode = new ArrayList<>();
        for (ProductDTO i: products) {
        	actualProductCode.add(i.getProductCode());
        }
        Collections.sort(actualProductCode);
        
        assertEquals(expectedProductCode, actualProductCode);
    }
    
    @Test
    void testGetProductsByInvalidCustomerNumber() {
 
        assertThrows(
            InvalidCustomerNumberException.class,
            () -> productService.getProductsByCustomerNumber(-1)
        );
    }

}