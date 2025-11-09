package business.dto;

import java.math.BigDecimal;

public class OrderDetailDTO {

    private Integer orderNumber;
    private String productCode;
    private Integer quantityOrdered;
    private BigDecimal priceEach;

    public OrderDetailDTO(Integer orderNumber, String productCode, Integer quantityOrdered, BigDecimal priceEach) {
        this.orderNumber = orderNumber;
        this.productCode = productCode;
        this.quantityOrdered = quantityOrdered;
        this.priceEach = priceEach;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public String getProductCode() {
        return productCode;
    }

    public Integer getQuantityOrdered() {
        return quantityOrdered;
    }

    public BigDecimal getPriceEach() {
        return priceEach;
    }
}