package business.repository;

import business.entity.Payment;
import business.entity.PaymentId;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, PaymentId> {
    List<Payment> findByCustomerCustomerNumber(Integer customerNumber);
}