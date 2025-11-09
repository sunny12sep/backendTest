package business.service.impl;

import org.springframework.stereotype.Service;

import business.dto.CustomerOrderSummaryDTO;
import business.dto.OrderDTO;
import business.dto.OrderTotalDTO;
import business.entity.Customer;
import business.entity.Order;
import business.entity.OrderDetail;
import business.exception.InvalidCustomerNumberException;
import business.exception.InvalidOrderNumberException;
import business.exception.InvalidStatusException;
import business.repository.CustomerRepository;
import business.repository.OrderDetailRepository;
import business.repository.OrderRepository;
import business.service.OrderService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final CustomerRepository customerRepository;

    public OrderServiceImpl(CustomerRepository customerRepository, OrderRepository orderRepository, OrderDetailRepository orderDetailRepository) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.customerRepository = customerRepository;
    }
    
    @Override
    public CustomerOrderSummaryDTO getCustomerOrderSummary(Integer customerNumber) {
        Customer customer = customerRepository.findById(customerNumber)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Long orderCount = orderRepository.countByCustomerCustomerNumber(customerNumber);

        return new CustomerOrderSummaryDTO(
                customer.getCustomerNumber(),
                customer.getCustomerName(),
                orderCount
        );
    }

    @Override
    public List<OrderDTO> getOrdersByCustomerNumber(Integer customerNumber) {
    	
    	List<OrderDTO> filtered = orderRepository.findByCustomerCustomerNumber(customerNumber).stream()
            .map(order -> new OrderDTO(
                order.getOrderNumber(),
                order.getOrderDate(),
                order.getShippedDate(),
                order.getStatus(),
                order.getCustomer().getCustomerName()))
            .collect(Collectors.toList());
        
        if (filtered.size() == 0) {
            throw new InvalidCustomerNumberException();
        }
        return filtered;
    }
    
    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
            .map(order -> new OrderDTO(
                order.getOrderNumber(),
                order.getOrderDate(),
                order.getShippedDate(),
                order.getStatus(),
                order.getCustomer().getCustomerName()))
            .collect(Collectors.toList());
    }

	@Override
	public List<OrderDTO> getOrdersByCustomerAndStatus(Integer customerNumber, String status) {
		
		if (customerRepository.existsById(customerNumber) == false) {
            throw new InvalidCustomerNumberException();
        }
		
		List<String> allStatus = new ArrayList<>();
		allStatus.add("Shipped");
		allStatus.add("Resolved");
		allStatus.add("Cancelled");
		allStatus.add("On Hold");
		allStatus.add("Disputed");
		allStatus.add("In Process");
		
		if (allStatus.contains(status) == false) {
			throw new InvalidStatusException();
		}
		
		return orderRepository.findByCustomerCustomerNumberAndStatus(customerNumber, status).stream()
		        .map(order -> new OrderDTO(
		            order.getOrderNumber(),
		            order.getOrderDate(),
		            order.getShippedDate(),
		            order.getStatus(),
		            order.getCustomer().getCustomerName()
		        ))
		        .collect(Collectors.toList());
	}
	
	@Override
	public List<OrderDTO> getOrdersByCustomerAndProduct(Integer customerNumber, String productCode) {
	    
		List<OrderDetail> details = orderDetailRepository.findByProductProductCode(productCode);

	    return details.stream()
	        .map(OrderDetail::getOrder)
	        .filter(order -> order.getCustomer().getCustomerNumber().equals(customerNumber))
	        .distinct()
	        .map(order -> new OrderDTO(
	            order.getOrderNumber(),
	            order.getOrderDate(),
	            order.getShippedDate(),
	            order.getStatus(),
	            order.getCustomer().getCustomerName()
	        ))
	        .collect(Collectors.toList());
	}
	
	@Override
	public Map<String, Long> getOrderStatusCountsForCustomer(Integer customerNumber) {
	    List<Order> orders = orderRepository.findByCustomerCustomerNumber(customerNumber);
	    Map<String, Long> statusCounts = new LinkedHashMap<>();
	    for (Order order : orders) {
	        statusCounts.put(order.getStatus(), statusCounts.getOrDefault(order.getStatus(), 0L) + 1);
	    }
	    return statusCounts;
	}
	
	@Override
	public OrderTotalDTO getOrderTotalDetails(Integer orderNumber) {
	    Order order = orderRepository.findById(orderNumber)
	    		.orElseThrow(InvalidOrderNumberException::new);

	    String customerName = order.getCustomer().getCustomerName();
	    BigDecimal totalAmount = order.getOrderDetails().stream()
	        .map(detail -> detail.getPriceEach().multiply(BigDecimal.valueOf(detail.getQuantityOrdered())))
	        .reduce(BigDecimal.ZERO, BigDecimal::add);

	    return new OrderTotalDTO(orderNumber, customerName, totalAmount);
	}
}
