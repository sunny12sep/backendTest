package business.service.impl;

import business.dto.OrderDetailDTO;
import business.exception.InvalidOrderNumberException;
import business.repository.OrderDetailRepository;
import business.repository.OrderRepository;
import business.service.OrderDetailService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;
    private final OrderRepository orderRepository;

    public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository, OrderRepository orderRepository) {
        this.orderDetailRepository = orderDetailRepository;
        this.orderRepository = orderRepository;
    }


    @Override
    public List<OrderDetailDTO> getAllOrderDetails() {
        return orderDetailRepository.findAll().stream()
            .map(detail -> new OrderDetailDTO(
                detail.getOrderNumber(),
                detail.getProductCode(),
                detail.getQuantityOrdered(),
                detail.getPriceEach()))
            .collect(Collectors.toList());
    }

    @Override
    public List<OrderDetailDTO> getOrderDetailsByOrderNumber(Integer orderNumber) {
    	List<OrderDetailDTO> filtered = orderDetailRepository.findByOrderOrderNumber(orderNumber).stream()
            .map(detail -> new OrderDetailDTO(
                detail.getOrderNumber(),
                detail.getProductCode(),
                detail.getQuantityOrdered(),
                detail.getPriceEach()))
            .collect(Collectors.toList());
    	
    	if (filtered.size() == 0) {
    		throw new InvalidOrderNumberException();
    	}
    	return filtered;
    }
    
    @Override
    public List<OrderDetailDTO> getOrderDetailsByOrderStatus() {
        return orderRepository.findByStatus("SHIPPED").stream()
            .flatMap(order -> order.getOrderDetails().stream())
            .map(detail -> new OrderDetailDTO(
                detail.getOrderNumber(),
                detail.getProductCode(),
                detail.getQuantityOrdered(),
                detail.getPriceEach()))
            .collect(Collectors.toList());
    }

}