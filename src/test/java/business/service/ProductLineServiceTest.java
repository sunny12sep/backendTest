package business.service;

import business.dto.ProductLineDTO;
import business.exception.InvalidProductCodeException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductLineServiceTest {
	
	@Autowired
    private ProductLineService productLineService;

    @Test
    void testGetProductLineByValidProductCode() {
        
    	ProductLineDTO summary = productLineService.getProductLineSummaryByProductCode("S18_1589");
        assertEquals("Classic Cars", summary.getProductLine());
    }

    @Test
    void testGetProductLineByInvalidProductCode() {

        assertThrows(
            InvalidProductCodeException.class,
            () -> productLineService.getProductLineSummaryByProductCode("")
        );
    }
}