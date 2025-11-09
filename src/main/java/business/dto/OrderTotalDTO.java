package business.dto;

import java.math.BigDecimal;

public class OrderTotalDTO {
    private Integer orderNumber;
    private String customerName;
    private BigDecimal totalAmount;

    public OrderTotalDTO(Integer orderNumber, String customerName, BigDecimal totalAmount) {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
}