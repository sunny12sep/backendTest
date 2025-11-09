package business.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import business.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {	
    List<Order> findByCustomerCustomerNumber(Integer customerNumber);
    List<Order> findByStatus(String status);
    Long countByCustomerCustomerNumber(Integer customerNumber);
    List<Order> findByCustomerCustomerNumberAndStatus(Integer customerNumber, String status);
}