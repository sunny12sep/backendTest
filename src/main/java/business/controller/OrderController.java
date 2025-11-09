package business.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import business.dto.CustomerOrderSummaryDTO;
import business.dto.OrderDTO;
import business.dto.OrderTotalDTO;
import business.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    
    @GetMapping("/status-count/{customerNumber}")
    public ResponseEntity<Map<String, Long>> getOrderStatusCountsForCustomer(@PathVariable Integer customerNumber) {
        return ResponseEntity.ok(orderService.getOrderStatusCountsForCustomer(customerNumber));
    }
    
    @GetMapping("/ordercount/{customerNumber}")
    public ResponseEntity<CustomerOrderSummaryDTO> getCustomerOrderSummary(@PathVariable Integer customerNumber) {
        CustomerOrderSummaryDTO summary = orderService.getCustomerOrderSummary(customerNumber);
        return ResponseEntity.ok(summary);
    }

    @GetMapping("/customer/{customerNumber}")
    public ResponseEntity<List<OrderDTO>> getOrdersByCustomer(@PathVariable Integer customerNumber) {
        return ResponseEntity.ok(orderService.getOrdersByCustomerNumber(customerNumber));
    }
    
    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }
    
    @GetMapping("/filter/{customerNumber}/{productCode}")
    public ResponseEntity<List<OrderDTO>> getOrdersByCustomerAndProduct(
            @PathVariable Integer customerNumber,
            @PathVariable String productCode) {
        return ResponseEntity.ok(orderService.getOrdersByCustomerAndProduct(customerNumber, productCode));
    }

    @GetMapping("/{customerNumber}/{status}")
    public ResponseEntity<List<OrderDTO>> getOrdersByCustomerAndStatus(
            @PathVariable Integer customerNumber,
            @PathVariable String status) {
        return ResponseEntity.ok(orderService.getOrdersByCustomerAndStatus(customerNumber, status));
    }
    
    @GetMapping("/total/{orderNumber}")
    public ResponseEntity<OrderTotalDTO> getOrderTotalDetails(@PathVariable Integer orderNumber) {
        return ResponseEntity.ok(orderService.getOrderTotalDetails(orderNumber));
    }
}