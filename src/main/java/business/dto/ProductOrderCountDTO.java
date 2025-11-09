package business.dto;

public class ProductOrderCountDTO {
    private String productCode;
    private Long orderCount;

    public ProductOrderCountDTO(String productCode, Long orderCount) {
        this.productCode = productCode;
        this.orderCount = orderCount;
    }

    public String getProductCode() {
        return productCode;
    }

    public Long getOrderCount() {
        return orderCount;
    }
}