package business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import business.entity.OrderDetail;
import business.entity.OrderDetailId;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {
    List<OrderDetail> findByOrderOrderNumber(Integer orderNumber);
    List<OrderDetail> findByProductProductCode(String productCode);
    List<OrderDetail> findByOrderCustomerCustomerNumber(Integer customerNumber);
}