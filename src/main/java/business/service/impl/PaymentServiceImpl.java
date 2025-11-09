package business.service.impl;

import business.dto.CustomerSpendingDTO;
import business.dto.PaymentDTO;
import business.entity.Payment;
import business.exception.InvalidCustomerNumberException;
import business.repository.CustomerRepository;
import business.repository.PaymentRepository;
import business.service.PaymentService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final CustomerRepository customerRepository;

    public PaymentServiceImpl(CustomerRepository customerRepository, PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<PaymentDTO> getPaymentsByCustomerNumber(Integer customerNumber) {

    	List<PaymentDTO> filtered =  paymentRepository.findByCustomerCustomerNumber(customerNumber).stream()
                .map(payment -> new PaymentDTO(
                        payment.getCheckNumber(),
                        payment.getPaymentDate(),
                        payment.getAmount()))
                .collect(Collectors.toList());
    	
    	if (filtered.size() == 0) {
    	    throw new InvalidCustomerNumberException();
    	}
    	return filtered;
    }
    
    @Override
    public List<CustomerSpendingDTO> getCustomerSpendingSummary() {
        return customerRepository.findAll().stream()
                .map(customer -> {
                    List<Payment> payments = paymentRepository.findByCustomerCustomerNumber(customer.getCustomerNumber());
                    BigDecimal total = payments.stream()
                            .map(Payment::getAmount)
                            .reduce(BigDecimal.ZERO, BigDecimal::add);
                    return new CustomerSpendingDTO(
                            customer.getCustomerNumber(),
                            customer.getCustomerName(),
                            total
                    );
                })
                .collect(Collectors.toList());
    }
    
    @Override
    public BigDecimal getTotalAmountByCustomerNumber(Integer customerNumber) {
        if (!customerRepository.existsById(customerNumber)) {
            throw new InvalidCustomerNumberException();
        }

        return paymentRepository.findByCustomerCustomerNumber(customerNumber).stream()
                .map(payment -> payment.getAmount())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}