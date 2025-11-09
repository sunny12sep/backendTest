package business.controller;

import business.dto.CustomerSpendingDTO;
import business.dto.PaymentDTO;
import business.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/customer/{customerNumber}")
    public ResponseEntity<List<PaymentDTO>> getPaymentsByCustomer(@PathVariable Integer customerNumber) {
        return ResponseEntity.ok(paymentService.getPaymentsByCustomerNumber(customerNumber));
    }
    
    @GetMapping("/summary")
    public ResponseEntity<List<CustomerSpendingDTO>> getCustomerSpendingSummary() {
        return ResponseEntity.ok(paymentService.getCustomerSpendingSummary());
    }
    
    @GetMapping("/customer/{customerNumber}/total")
    public ResponseEntity<BigDecimal> getTotalAmountByCustomer(@PathVariable Integer customerNumber) {
        return ResponseEntity.ok(paymentService.getTotalAmountByCustomerNumber(customerNumber));
    }
}