package business.service;

import java.util.List;
import java.util.Map;

import business.dto.CustomerOrderSummaryDTO;
import business.dto.OrderDTO;
import business.dto.OrderTotalDTO;

public interface OrderService {
    List<OrderDTO> getOrdersByCustomerNumber(Integer customerNumber);
    List<OrderDTO> getAllOrders();
    CustomerOrderSummaryDTO getCustomerOrderSummary(Integer customerNumber);
    Map<String, Long> getOrderStatusCountsForCustomer(Integer customerNumber);
    OrderTotalDTO getOrderTotalDetails(Integer orderNumber);
    List<OrderDTO> getOrdersByCustomerAndProduct(Integer customerNumber, String productCode);
    List<OrderDTO> getOrdersByCustomerAndStatus(Integer customerNumber, String status);
}