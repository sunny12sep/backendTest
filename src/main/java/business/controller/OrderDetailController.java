package business.controller;

import business.dto.OrderDetailDTO;
import business.service.OrderDetailService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderdetails")
public class OrderDetailController {

    private final OrderDetailService orderDetailService;

    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @GetMapping("/order/{orderNumber}")
    public ResponseEntity<List<OrderDetailDTO>> getOrderDetailsByOrderNumber(@PathVariable Integer orderNumber) {
        return ResponseEntity.ok(orderDetailService.getOrderDetailsByOrderNumber(orderNumber));
    }
    
    @GetMapping("/shipped")
    public ResponseEntity<List<OrderDetailDTO>> getOrderDetailsByOrderStatus() {
        return ResponseEntity.ok(orderDetailService.getOrderDetailsByOrderStatus());
    }
}