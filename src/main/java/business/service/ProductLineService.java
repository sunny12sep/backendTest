package business.service;

import java.util.List;
import business.dto.ProductLineDTO;

public interface ProductLineService {
	ProductLineDTO getProductLineSummaryByProductCode(String productCode);
	List<ProductLineDTO> getAllProductLines();
}