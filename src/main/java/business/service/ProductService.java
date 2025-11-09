package business.service;

import java.util.List;
import business.dto.ProductDTO;

public interface ProductService {
    List<ProductDTO> getProductsByCustomerNumber(Integer customerNumber);
    List<ProductDTO> getProductsByOrderNumber(Integer orderNumber);
    List<ProductDTO> getProductsByProductLine(String productLine);
}