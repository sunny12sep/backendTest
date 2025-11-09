package business.service;

import java.util.List;
import business.dto.OrderDetailDTO;

public interface OrderDetailService {
    List<OrderDetailDTO> getAllOrderDetails();
    List<OrderDetailDTO> getOrderDetailsByOrderNumber(Integer orderNumber);
    List<OrderDetailDTO> getOrderDetailsByOrderStatus();
}