package business.service.impl;

import business.dto.ProductOrderCountDTO;
import business.entity.OrderDetail;
import business.repository.OrderDetailRepository;
import business.service.CustomerOrderService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    private final OrderDetailRepository orderDetailRepository;

    public CustomerOrderServiceImpl(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    public List<ProductOrderCountDTO> getProductOrderCounts(Integer customerNumber) {
        List<OrderDetail> orderDetails = orderDetailRepository.findByOrderCustomerCustomerNumber(customerNumber);

        Map<String, Long> productCountMap = new HashMap<>();
        for (OrderDetail detail : orderDetails) {
            String productCode = detail.getProductCode();
            productCountMap.put(productCode, productCountMap.getOrDefault(productCode, 0L) + 1);
        }

        List<ProductOrderCountDTO> result = new ArrayList<>();
        for (Map.Entry<String, Long> entry : productCountMap.entrySet()) {
            result.add(new ProductOrderCountDTO(entry.getKey(), entry.getValue()));
        }

        return result;
    }
}