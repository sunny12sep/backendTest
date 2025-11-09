package business.controller;

import business.dto.ProductOrderCountDTO;
import business.service.CustomerOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customerorder")
public class CustomerOrderController {

    private final CustomerOrderService customerOrderService;

    public CustomerOrderController(CustomerOrderService customerOrderService) {
        this.customerOrderService = customerOrderService;
    }

    @GetMapping("/{customerNumber}/product-orders")
    public List<ProductOrderCountDTO> getProductOrderCounts(@PathVariable Integer customerNumber) {
        return customerOrderService.getProductOrderCounts(customerNumber);
    }
}