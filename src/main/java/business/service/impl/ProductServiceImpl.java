package business.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import business.dto.ProductDTO;
import business.entity.Order;
import business.entity.OrderDetail;
import business.entity.Product;
import business.exception.InvalidCustomerNumberException;
import business.exception.InvalidOrderNumberException;
import business.repository.CustomerRepository;
import business.repository.OrderDetailRepository;
import business.repository.OrderRepository;
import business.repository.ProductRepository;
import business.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public ProductServiceImpl(CustomerRepository customerRepository, OrderRepository orderRepository, OrderDetailRepository orderDetailRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }
    
    @Override
    public List<ProductDTO> getProductsByProductLine(String productLine) {
        List<Product> products = productRepository.findByProductLine_ProductLine(productLine);
        return products.stream()
                .map(p -> new ProductDTO(p.getProductCode(), p.getProductName(), p.getBuyPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getProductsByCustomerNumber(Integer customerNumber) {
        
    	List<Order> orders = orderRepository.findByCustomerCustomerNumber(customerNumber);
        Set<Product> products = new HashSet<>();
        for (Order order : orders) {
            List<OrderDetail> details = orderDetailRepository.findByOrderOrderNumber(order.getOrderNumber());
            for (OrderDetail detail : details) {
                products.add(detail.getProduct());
            }
        }

        List<ProductDTO> filtered = products.stream()
                .map(p -> new ProductDTO(p.getProductCode(), p.getProductName(), p.getBuyPrice()))
                .collect(Collectors.toList());
        
        if (filtered.size() == 0) {
            throw new InvalidCustomerNumberException();
        }
        return filtered;
    }

    @Override
    public List<ProductDTO> getProductsByOrderNumber(Integer orderNumber) {
    	List<ProductDTO> filtered = orderDetailRepository.findByOrderOrderNumber(orderNumber).stream()
                .map(detail -> {
                    var product = detail.getProduct();
                    return new ProductDTO(
                            product.getProductCode(),
                            product.getProductName(),
                            product.getBuyPrice()
                    );
                })
                .collect(Collectors.toList());
    	
    	if (filtered.size() == 0) {
    		throw new InvalidOrderNumberException();
    	}
    	return filtered;
    }
}