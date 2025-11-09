package business.service;

import business.dto.CustomerSpendingDTO;
import business.dto.PaymentDTO;
import java.math.BigDecimal;
import java.util.List;

public interface PaymentService {
    List<PaymentDTO> getPaymentsByCustomerNumber(Integer customerNumber);
    List<CustomerSpendingDTO> getCustomerSpendingSummary();
    BigDecimal getTotalAmountByCustomerNumber(Integer customerNumber);
}