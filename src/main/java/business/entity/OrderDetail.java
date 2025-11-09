package business.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orderdetails")
@IdClass(OrderDetailId.class)
public class OrderDetail {
    @Id
    private Integer orderNumber;

    @Id
    private String productCode;

    private Integer quantityOrdered;
    private BigDecimal priceEach;
    private Short orderLineNumber;

    @ManyToOne
    @JoinColumn(name = "orderNumber", insertable = false, updatable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "productCode", insertable = false, updatable = false)
    private Product product;

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Integer getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(Integer quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	public BigDecimal getPriceEach() {
		return priceEach;
	}

	public void setPriceEach(BigDecimal priceEach) {
		this.priceEach = priceEach;
	}

	public Short getOrderLineNumber() {
		return orderLineNumber;
	}

	public void setOrderLineNumber(Short orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
    
    
}