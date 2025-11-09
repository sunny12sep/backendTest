package business.dto;

import java.math.BigDecimal;

public class CustomerSpendingDTO {
    private Integer customerNumber;
    private String customerName;
    private BigDecimal totalAmount;

    public CustomerSpendingDTO(Integer customerNumber, String customerName, BigDecimal totalAmount) {
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
    }

    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
}