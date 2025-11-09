package business.service;

import business.dto.ProductOrderCountDTO;
import java.util.List;

public interface CustomerOrderService {
    List<ProductOrderCountDTO> getProductOrderCounts(Integer customerNumber);
}